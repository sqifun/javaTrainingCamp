package io.kimmking.cache.pubsub;

import org.redisson.client.protocol.pubsub.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author da
 * @version 1.0
 * @description: TODO
 * @date 2022年03月27日 14:45
 */
@RestController
@RequestMapping("/iot")
public class IotController {

    //注入Redis消息容器对象
    @Autowired
    RedisMessageListenerContainer redisMessageListenerContainer;

    @RequestMapping(value = "/unLock", method = RequestMethod.POST)
    public boolean unLock(@RequestParam(value = "thingName") String thingName,
                          @RequestParam(value = "requestId") String requestId)
            throws InterruptedException, ExecutionException, TimeoutException {

        //此处实现异步消息调用处理....

        //生成监听频道Key
        String key = "IOT_" + thingName + "_" + requestId;
        //创建监听Topic
        //绑定channel
        ChannelTopic channelTopic = new ChannelTopic(key);
        //创建消息任务对象
        IotMessageTask iotMessageTask = new IotMessageTask();
        //任务对象及监听Topic添加到消息监听容器
        try {
            redisMessageListenerContainer.addMessageListener(new IotMessageListener(iotMessageTask), channelTopic);
            System.out.println("start redis subscribe listener" + key);
            //进入同步阻塞等待，超时时间设置为60秒
            //接收发布到来的消息
            Message message = (Message) iotMessageTask.getIotMessageFuture().get(60000, TimeUnit.MILLISECONDS);
            System.out.println("receive redis callback message" + message.toString());
        } finally {
            //销毁消息监听对象
            if (iotMessageTask != null) {
                redisMessageListenerContainer.removeMessageListener(iotMessageTask.getMessageListener());
            }
        }
        return true;
    }
}

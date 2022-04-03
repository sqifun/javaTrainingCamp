package io.kimmking.cache.pubsub;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * @author da
 * @version 1.0
 * @description: TODO
 * @date 2022年03月27日 14:51
 */
public class IotMessageListener implements MessageListener {

    IotMessageTask iotMessageTask;

    public IotMessageListener(IotMessageTask iotMessageTask) {
        this.iotMessageTask = iotMessageTask;
    }

    //实现消息发布监听处理方法
    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("subscribe redis iot task response:{}" + message.toString());
        //线程阻塞完成
        iotMessageTask.getIotMessageFuture().complete(message);
    }
}

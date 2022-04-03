package io.kimmking.cache.pubsub;


import org.springframework.data.redis.connection.MessageListener;

import java.util.concurrent.CompletableFuture;

/**
 * @author da
 * @version 1.0
 * @description: TODO
 * @date 2022年03月26日 20:24
 */
public class IotMessageTask {

    //声明线程异步阻塞对象(JDK 1.8新提供Api)
    private CompletableFuture iotMessageFuture = new CompletableFuture();

    //声明消息监听对象
    private MessageListener messageListener;

    //声明超时时间
    private boolean isTimeout;

    public IotMessageTask() {
    }

    public CompletableFuture getIotMessageFuture() {
        return iotMessageFuture;
    }

    public void setIotMessageFuture(CompletableFuture iotMessageFuture) {
        this.iotMessageFuture = iotMessageFuture;
    }

    public MessageListener getMessageListener() {
        return messageListener;
    }

    public void setMessageListener(MessageListener messageListener) {
        this.messageListener = messageListener;
    }

    public boolean isTimeout() {
        return isTimeout;
    }

    public void setTimeout(boolean timeout) {
        isTimeout = timeout;
    }
}

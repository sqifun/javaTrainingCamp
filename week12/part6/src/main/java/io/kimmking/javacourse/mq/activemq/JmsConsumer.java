package io.kimmking.javacourse.mq.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author da
 * @version 1.0
 * @description: TODO
 * @date 2022年04月02日 22:25
 */
@Component
public class JmsConsumer {

    @JmsListener(destination = "activeTest")
    public void receiveMessage(final Map message) {
        System.out.println(message.toString());
    }
}

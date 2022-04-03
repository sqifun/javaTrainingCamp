package io.kimmking.javacourse.mq.activemq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.apache.camel.model.dataformat.JsonLibrary.Gson;

/**
 * @author da
 * @version 1.0
 * @description: TODO
 * @date 2022年04月02日 22:26
 */
@Component
public class JmsProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(final String topic, final String message) {

//        Map map = new Gson().fromJson(message, Map.class);
        ;
        jmsTemplate.convertAndSend(topic, (Map) JSONObject.parse(message));
    }
}

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.kimmking.kmq.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lw1243925457
 */
@Component
@Slf4j
public class CustomBroker {

    private Map<String, CustomQueue> queueMap = new HashMap<>();

    public boolean send(String topic, String content) {
        CustomQueue queue = queueMap.getOrDefault(topic, new CustomQueue());
        queue.put(content);
        queueMap.put(topic, queue);
        return true;
    }

    public List<String> poll(String topic, String group, int rate) {
        CustomQueue queue = queueMap.get(topic);

        List<String> messages = new ArrayList<>();
        if (queue == null) {
            return messages;
        }

        log.info("queue message amount : " + queue.size());
        while (!queue.isEmpty() || rate > 0) {
            String message = queue.get(group);
            if (message == null) {
                break;
            }
            messages.add(message);
            rate -= 1;
        }

        return messages;
    }
}

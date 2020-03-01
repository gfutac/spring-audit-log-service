package com.gfutac.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuditTopicConsumer {

    @JmsListener(destination = "${topics.audit.name}")
    public void onMessage(String content) {
        // for now just log it. in future - elasticsearch?
        log.info(content);
    }
}

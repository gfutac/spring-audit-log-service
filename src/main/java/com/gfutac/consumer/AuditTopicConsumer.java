package com.gfutac.consumer;

import com.gfutac.service.ElasticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuditTopicConsumer {

    @Autowired
    private ElasticService elasticService;

    @JmsListener(destination = "${topics.audit.name}")
    public void onReceivedAuditMessage(String content) {
        this.elasticService.saveAuditEntry(content);
    }
}

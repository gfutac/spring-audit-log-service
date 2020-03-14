package com.gfutac.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gfutac.model.AuditEntity;
import com.gfutac.model.AuditEntityElasticRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ElasticService {

    @Autowired
    private AuditEntityElasticRepository auditEntityElasticRepository;

    @Autowired
    private ObjectMapper mapper;

    public AuditEntity saveAuditEntry(String content) {
        log.info("{}", content);

        AuditEntity entity = null;

        try {
            entity = mapper.readValue(content, AuditEntity.class);
            this.auditEntityElasticRepository.save(entity);
        } catch (JsonProcessingException e) {
            log.error("Could not deserialize incoming message", e);
        }

        return entity;
    }

    public List<AuditEntity> findAll() {
        var result = new ArrayList<AuditEntity>();
        this.auditEntityElasticRepository.findAll().forEach(result::add);
        return result;
    }

    public List<AuditEntity> findByTypeAndId(String entityType, Object entityKey) {
        var sort = Sort
                .sort(AuditEntity.class)
                .by(AuditEntity::getEntityStateChangeTime)
                .descending();

        return this.auditEntityElasticRepository.findByEntityTypeAndEntityKey(entityType, entityKey, sort);
    }

    public void deleteAll() {
        this.auditEntityElasticRepository.deleteAll();
    }
}

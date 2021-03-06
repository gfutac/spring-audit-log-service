package com.gfutac.model;

import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface AuditEntityElasticRepository extends ElasticsearchRepository<AuditEntity, String> {
    List<AuditEntity> findByEntityTypeAndEntityKey(String entityType, Object entityKey, Sort sort);
}

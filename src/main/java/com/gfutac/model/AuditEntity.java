package com.gfutac.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;

@Getter
@Setter
@ToString
@Accessors(chain = true)

@Document(indexName = "audit-log", type = "audit-entity")
public class AuditEntity {

    @Id
    private String id;

    private String entityType;
    private EntityStateChangeType entityStateChangeType;
    private Instant entityStateChangeTime;
    private HashMap<String, Object> entity;
    private Object entityKey;
}

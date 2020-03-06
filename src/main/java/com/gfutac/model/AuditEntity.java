package com.gfutac.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;

@Getter
@Setter
@Accessors(chain = true)
public class AuditEntity {
    private String entityType;
    private EntityStateChangeType entityStateChangeType;
    private Instant entityStateChangeTime;
    private HashMap<String, String> entity;
    private Serializable entityKey;
}

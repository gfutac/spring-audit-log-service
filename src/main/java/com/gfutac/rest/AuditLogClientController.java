package com.gfutac.rest;

import com.gfutac.model.AuditEntity;
import com.gfutac.service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping(value = "/audit-log/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuditLogClientController {

    @Autowired
    private ElasticService elasticService;

    @GetMapping(value = "/all-entries")
    public List<AuditEntity> findAll() {
        return this.elasticService.findAll();
    }

    @GetMapping(value = "/entry")
    public List<AuditEntity> findByTypeAndKey(@RequestParam() String entityType, @RequestParam() Serializable entityKey) {
        return this.elasticService.findByTypeAndId(entityType, entityKey);
    }
}

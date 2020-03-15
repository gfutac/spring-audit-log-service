package com.gfutac.rest;

import com.gfutac.model.AuditEntity;
import com.gfutac.service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/audit-log/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuditLogClientController {

    @Autowired
    private ElasticService elasticService;

    // region all-entries
    @GetMapping(value = "/all-entries")
    public List<AuditEntity> findAll() {
        return this.elasticService.findAll();
    }

    @DeleteMapping(value = "/all-entries")
    public void deleteAll() {
        this.elasticService.deleteAll();
    }
    // endregion

    // region entry
    @GetMapping(value = "/entry")
    public List<AuditEntity> findByTypeAndKey(@RequestParam() String entityType, @RequestParam() Object entityKey) {
        return this.elasticService.findByTypeAndId(entityType, entityKey);
    }
    // endregion
}

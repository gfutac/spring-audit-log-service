package com.gfutac.config.elastic;

import com.gfutac.config.elastic.converters.InstantStringConversion;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchEntityMapper;
import org.springframework.data.elasticsearch.core.EntityMapper;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions;

import java.util.Arrays;

@Configuration
public class ElasticConfig extends AbstractElasticsearchConfiguration {

    @Value("${elasticsearch.client.address}")
    private String clientAddress;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        return RestClients.create(ClientConfiguration.create(clientAddress)).rest();
    }

    @Bean
    @Override
    public EntityMapper entityMapper() {

        ElasticsearchEntityMapper entityMapper =
                new ElasticsearchEntityMapper(this.elasticsearchMappingContext(), new DefaultConversionService());

        entityMapper.setConversions(elasticsearchCustomConversions());
        return entityMapper;
    }

    @Bean
    @Override
    public ElasticsearchCustomConversions elasticsearchCustomConversions() {
        return new ElasticsearchCustomConversions(Arrays.asList(new InstantStringConversion.InstantToString(), new InstantStringConversion.StringToInstant()));
    }
}

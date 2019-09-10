package five.service.spring.db.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application-inmemory.yml")
public class InmemDataSourceConfig {
    public static final Logger LOG = LoggerFactory.getLogger(InmemDataSourceConfig.class);

    @Bean
    @ConfigurationProperties(prefix = "spring.inmemory-datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("inmemDataSource")
    @DependsOn("dataSourceProperties")
    public DataSource getInmemDataSource(DataSourceProperties dataSourceProperties) {
        LOG.info("Initializing datasource: {}", dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

}

package fr.genepisep.icompetences.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
    @Value("${database.user}")
    String user;

    @Value("${database.password}")
    String password;

    @Value("${database.jdbc-string}")
    String jdbcString;

    @Bean
    @Primary
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .username(user)
                .password(password)
                .url(jdbcString)
                .build();
    }
}

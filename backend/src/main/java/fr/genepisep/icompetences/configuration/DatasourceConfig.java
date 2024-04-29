package fr.genepisep.icompetences.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Value("${db.username}")
    String user;

    @Value("${db.password}")
    String pass;

    @Value("${db.string}")
    String dbString;
    @Bean
    public DataSource defaultDataSource() {
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.driverClassName("org.postgresql.Driver");
        builder.url(dbString);
        builder.password(pass);
        builder.username(user);
        return builder.build();
    }
}

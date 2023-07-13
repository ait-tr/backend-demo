package de.ait.todo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * 7/13/2023
 * backend-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Profile("prod")
@Configuration
public class DigitalOceanDataSourceConfiguration {

    @Value("${todo.USERNAME}")
    private String username;

    @Value("${todo.PASSWORD}")
    private String password;

    @Value("${todo.HOSTNAME}")
    private String hostname;

    @Value("${todo.PORT}")
    private String port;

    @Value("${todo.DATABASE}")
    private String database;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://" + hostname +":" + port + "/" + database)
                .username(username)
                .password(password)
                .build();

    }

}

package org.example.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.Objects;

@Configuration
@ComponentScan
@PropertySource("classpath:database.properties")
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty(Constants.URL));
        driverManagerDataSource.setUsername(environment.getProperty(Constants.USER));
        driverManagerDataSource.setPassword(environment.getProperty(Constants.PASSWORD));
        driverManagerDataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty(Constants.DRIVER)));
        return driverManagerDataSource;
    }
}

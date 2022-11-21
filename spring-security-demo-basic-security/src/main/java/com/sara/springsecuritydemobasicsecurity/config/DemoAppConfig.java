package com.sara.springsecuritydemobasicsecurity.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Objects;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sara.springsecuritydemobasicsecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

    // set up a variable to hold the properties
    @Autowired
    private Environment env;

    // set up a logger for diagnosis
    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }


    // define a bean for our security datasource
    @Bean
    public DataSource securityDatasource() {
        // create connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        // set up the jdbc driver class
        try {
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        // log the connection props
        logger.info(">>>> jdbc.url=" + env.getProperty("jdbc.url"));
        logger.info(">>>> jdbc.user=" + env.getProperty("jdbc.user"));

        // set up database connection props
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        securityDataSource.setMinPoolSize(
                getIntProperty("connection.pool.minPoolSize")
        );

        securityDataSource.setMaxPoolSize(
                getIntProperty("connection.pool.maxPoolSize")
        );

        securityDataSource.setMaxIdleTime(
                getIntProperty("connection.pool.maxIdleTime")
        );
        return securityDataSource;
    }

    private int getIntProperty(String propName) {
        return Integer.parseInt(Objects.requireNonNull(env.getProperty(propName)));
    }
}

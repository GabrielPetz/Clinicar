/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template.html file, choose Tools | Templates
 * and open the template.html in the editor.
 */
package clinicar.web.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * @author Petz
 * @since 08/06/18
 */
@Configuration
public class DBConfig {

    public static final Integer INITIAL_SIZE = 3;
    public static final Integer MAX_ACTIVE = 3;
    public static final Integer MAX_IDLE = 3;
    public static final Integer MIN_IDLE = 0;


    // TELEMETRY_API, OFFSET,
    @Qualifier("clinicarDB")
    @Bean(name = "clinicarDataSource")
    @ConfigurationProperties(prefix = "clinicar.datasource")
    public DataSource clinicarDataSource() {
        DataSource ds = new DataSource();
        ds.setInitialSize(INITIAL_SIZE);
        ds.setMaxActive(MAX_ACTIVE);
        ds.setMaxIdle(MAX_IDLE);
        ds.setMinIdle(MIN_IDLE);
        return ds;
    }

    @Bean("clinicarJdbcTemplate")
    public JdbcTemplate clinicarJdbcTemplate(DataSource clinicarDataSource) {
        return new JdbcTemplate(clinicarDataSource);
    }

}

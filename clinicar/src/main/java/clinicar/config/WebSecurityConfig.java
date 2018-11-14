package clinicar.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * @author Petz
 * @since 21/08/18
 */
@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    private Environment env;

    @Bean(destroyMethod = "")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("clinicar.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("clinicar.datasource.url"));
        dataSource.setUsername(env.getProperty("clinicar.datasource.username"));
        dataSource.setPassword(env.getProperty("clinicar.datasource.password"));
        return dataSource;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(getDataSource())
                .usersByUsernameQuery("select usremail as username, usrpassword as password, usractive as active "
                        + "from public.users where usremail=? ")
                .authoritiesByUsernameQuery("select usremail as username, UPPER(roldesc) as role "
                        + "from users u, role r where usrrole = rolid and usremail = ? ")
                .passwordEncoder(new BCryptPasswordEncoder());

//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("admin");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String[] patterns = {"/home/**", "/js/**", "/css/**"};

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("**")
                .permitAll().mvcMatchers(HttpMethod.POST, "/clinicar/user/**");

        http.authorizeRequests()
                .antMatchers("/admin")
                .hasAuthority("admin")
                .anyRequest()
                .authenticated();

        http.formLogin().loginPage("/login").defaultSuccessUrl("/loginsuccess")
                .permitAll(true);

        http.logout().permitAll()
                .invalidateHttpSession(true).clearAuthentication(true).deleteCookies();

        http.exceptionHandling().accessDeniedPage("/error/403");

    }

}

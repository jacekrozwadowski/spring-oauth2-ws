package spring.oauth2.ws.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan({ "spring.oauth2.ws.web.controller" })
public class ResourceServerWebConfig extends WebMvcConfigurerAdapter {
}

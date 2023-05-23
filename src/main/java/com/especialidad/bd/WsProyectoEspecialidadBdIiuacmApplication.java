package com.especialidad.bd;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@PropertySource(value = "file:${UACM_WS}/WSProyectoEspecialidadBdIIUACM.properties", ignoreResourceNotFound = true)
public class WsProyectoEspecialidadBdIiuacmApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsProyectoEspecialidadBdIiuacmApplication.class, args);
	}
	@Autowired
	 private Environment env;
	@Bean
	  public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	            .allowedOrigins("*")
	            .allowCredentials(false)
	            .allowedHeaders("*")
	            .allowedMethods("POST", "GET", "DELETE", "PUT", "OPTIONS");
	      }
	    };
	  }
	@Bean
	@Qualifier("sqlserver")
		public DataSource dataSourceSqlServerAdmin() throws NamingException {
		return (DataSource) new JndiTemplate().lookup(env.getProperty("DSSMSSQLDSSQLSERVER"));
	}
}

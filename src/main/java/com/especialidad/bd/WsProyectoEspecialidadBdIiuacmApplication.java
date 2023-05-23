package com.especialidad.bd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WsProyectoEspecialidadBdIiuacmApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsProyectoEspecialidadBdIiuacmApplication.class, args);
	}
	
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

}

package com.icshop7.delivery;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }
    
    
// //Added new by Amit in Sep 
//    //https://icshop7.com
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
////       registry.addMapping("/**").allowedOrigins("http://localhost:4200"); //this code creates Problem.. its the Solution
////    	registry.addMapping("/**").allowedOrigins("http://icshop7.com");  
//    	registry.addMapping("/**").allowedOrigins("*");  
//    }
//    
//    
//    
//    
//    @Bean
//    CorsConfiguration corsConfiguration() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE","PUT"));
//        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "X-XSRF-TOKEN", "Authorization"));
//        configuration.setAllowCredentials(true);
//        return configuration;
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfiguration());
//        return source;
//    }

}
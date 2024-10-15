package com.iwillbfine.jenkinsproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                /* Ingress 적용 이후 CORS 불필요로 인한 경로 제거 */
                .allowedOrigins()
                /* Ingress 적용 이전 프론트 워커노드 포트에 대한 CORS 처리 */
//                .allowedOrigins("http://localhost:30000")
//                .allowedOrigins("*") // permit all
//                .allowedOrigins("http://localhost:5173")
//                .allowedOrigins("http://localhost:8011")
//                .allowedOrigins("http://localhost:5173", "http://localhost:8011")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}

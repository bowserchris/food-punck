package org.ironhack.Food_Punck.config;

import org.ironhack.Food_Punck.util.CommonConst;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(CommonConst.ADD_MAPPINGS)	// currently "/**" this should following everything /
                .allowedOrigins(CommonConst.ALLOWED_ORIGINS)  // currently 8080, alter this if port is occupied
                .allowedMethods(CommonConst.ALLOWED_METHOD_GET,
                		CommonConst.ALLOWED_METHOD_POST,
                		CommonConst.ALLOWED_METHOD_PUT,
                		CommonConst.ALLOWED_METHOD_DELETE,
                		CommonConst.ALLOWED_METHOD_OPTIONS)
                .allowedHeaders(CommonConst.ALLOWED_HEADERS) // currently "*"
                .allowCredentials(CommonConst.ALLOWED_CREDENTIALS) // currently true
                .maxAge(CommonConst.MAX_AGE_SITE); // currently 3600
    }
	
}

package com.hucs.manager.web.config;

import com.hucs.manager.web.interceptors.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/api", c -> true); // Adiciona o prefixo "/api" a todos os controladores
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .defaultContentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .favorParameter(false) // Evita que o tipo de mídia seja determinado por parâmetros de URL
                .ignoreAcceptHeader(true); // Ignora o cabeçalho "Accept", respondendo sempre com JSON
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Adiciona o TokenInterceptor para todas as rotas
        registry.addInterceptor(tokenInterceptor)
                .excludePathPatterns("/api/auth/**","/api/h2/**")
                .addPathPatterns("/**"); // Aplica o interceptor a todas as requisições

        // Se quiser limitar o interceptor a rotas específicas:
        // .addPathPatterns("/api/**");
    }




}


package com.example.demo.web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    /* configuracion del idioma */
    @Bean
    public LocaleContextResolver localeResolver(){
        /* i18n = internacionalization */
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }
    
    /* interceptor para cambiar de idioma de forma dinamica */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        
        var lci = new LocaleChangeInterceptor();
        /* cual va a ser el parametro que nos defina el nuevo lenguaje 'lang' */
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        
        registro.addInterceptor(localeChangeInterceptor());
    }
    
    @Override /* mapear pads que no pasan por el controlador */
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403");
    }
}

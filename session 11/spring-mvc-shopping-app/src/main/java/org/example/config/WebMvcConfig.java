package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public UrlBasedViewResolver urlBasedViewResolver() {

        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setPrefix("/WEB-INF/views/");
        urlBasedViewResolver.setSuffix(".jsp");
        urlBasedViewResolver.setViewClass(JstlView.class);
        urlBasedViewResolver.setExposeContextBeansAsAttributes(true);

        return urlBasedViewResolver;

    }

    @Bean
    public DataSource dataSource() {

        var jndiDataSourceLookup = new JndiDataSourceLookup();
        jndiDataSourceLookup.setResourceRef(true);
        var dataSource = jndiDataSourceLookup.getDataSource("jdbc/springDB");

        return dataSource;
    }

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {

        RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
        // if enable a method mapped to "/organizations" matches to "/organizations/"
        handlerMapping.setUseTrailingSlashMatch(true);
        // if enable a method mapped to "/organiaztions" matches to "/organizations.*"
        handlerMapping.setUseSuffixPatternMatch(true);

        return handlerMapping;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/").setViewName("/home");
    }
}

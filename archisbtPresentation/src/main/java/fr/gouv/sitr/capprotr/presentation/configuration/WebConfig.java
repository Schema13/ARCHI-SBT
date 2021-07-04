package fr.gouv.sitr.capprotr.presentation.configuration;

import org.apache.catalina.filters.SetCharacterEncodingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@PropertySource(value = "classpath:/application.properties", ignoreResourceNotFound = true)
public class WebConfig implements WebMvcConfigurer {

    /**
     * Character encoding filter bean.
     *
     * @return the filter registration bean
     */
    @Bean
    public FilterRegistrationBean<SetCharacterEncodingFilter> characterEncodingFilterBean() {
        FilterRegistrationBean<SetCharacterEncodingFilter> registrationBean = new FilterRegistrationBean<>();
        SetCharacterEncodingFilter characterEncodingFilter = new SetCharacterEncodingFilter();
        registrationBean.setFilter(characterEncodingFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registrationBean.addInitParameter("encoding", "UTF-8");
        registrationBean.addInitParameter("ignore", "true");

        return registrationBean;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addResourceHandlers(org.springframework.web.servlet.config.annotation.
     * ResourceHandlerRegistry)
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // specifying static resource location for themes related files(css etc)
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/");
    }

}

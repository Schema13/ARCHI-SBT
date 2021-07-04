package fr.gouv.sitr.capprotr.presentation.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("fr.gouv.sitr.capprotr.persistance")
@EnableAspectJAutoProxy
@EntityScan("fr.gouv.sitr.capprotr.domain.entities")
@ComponentScan(basePackages = "fr.gouv.sitr.capprotr")
public class CapprotrInitializerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CapprotrInitializerApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CapprotrInitializerApplication.class, args);
    }

}

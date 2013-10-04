package org.mjmayor.baseproject.config;

import org.mjmayor.persistence.config.PersistenceRepositoryConfig;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
// @Import({ RepositoryConfig.class, AlumnoBeansConfig.class, AsignaturaBeansConfig.class, ProfesorBeansConfig.class })
@Import({ PersistenceRepositoryConfig.class, ProfesorBeanConfig.class })
@ComponentScan("org.mjmayor.baseproject")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver irResolver() {
		InternalResourceViewResolver ir = new InternalResourceViewResolver();
		ir.setPrefix("/WEB-INF/views/");
		ir.setSuffix(".jsp");
		return ir;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasenames(new String[] { "messages/messages", "errors/errors" });
		return resourceBundleMessageSource;
	}
}

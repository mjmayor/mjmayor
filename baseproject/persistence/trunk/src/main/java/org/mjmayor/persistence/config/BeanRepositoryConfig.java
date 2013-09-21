package org.mjmayor.persistence.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class BeanRepositoryConfig extends WebMvcConfigurerAdapter {

	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("config/database.properties"));
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}
}

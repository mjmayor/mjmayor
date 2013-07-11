package org.mjmayor.jpa.config;

import org.mjmayor.jpa.interceptors.JPAInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class JPAConfig {

	@Bean
	public JPAInterceptor jpaInterceptor() {
		return new JPAInterceptor();
	}
}

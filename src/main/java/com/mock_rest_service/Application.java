package com.mock_rest_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class Application {

	@Bean
	public CommonsRequestLoggingFilter logFilter() {
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludeQueryString(true);
		filter.setIncludePayload(true);
		filter.setIncludeHeaders(true);
		filter.setIncludeClientInfo(true);

		filter.setMaxPayloadLength(10000);
		return filter;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

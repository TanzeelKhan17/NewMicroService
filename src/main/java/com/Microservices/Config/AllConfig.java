package com.Microservices.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AllConfig {

	@Bean
	@LoadBalanced
	public RestTemplate restTemp() {
		return new RestTemplate();

	}

}

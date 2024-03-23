package com.patent.microservice;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import java.time.Duration;
@SpringBootApplication
@EnableFeignClients
public class PatentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatentApplication.class, args);
	}


	// Define circuit breaker configuration
//	CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
//			.failureRateThreshold(50) // Failure rate threshold in percentage
//			.waitDurationInOpenState(Duration.ofMillis(1000)) // Time to wait in open state before transitioning to half-open
//			.slidingWindowSize(5) // Number of recent calls to consider for failure rate calculation
//			.build();
//
//	// Create a circuit breaker based on the configuration
//	CircuitBreaker circuitBreaker = CircuitBreaker.of("myCircuitBreaker", circuitBreakerConfig);

}

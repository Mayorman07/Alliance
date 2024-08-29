package com.project.discovery_service_alliance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceAllianceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceAllianceApplication.class, args);
	}

}

<<<<<<< HEAD
package com.project.alliance;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AllianceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllianceApplication.class, args);
	}

}
=======
package com.project.alliance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AllianceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllianceApplication.class, args);
	}

}
>>>>>>> e0589cf7366caabbb3463afb18dbcfb834fb30b9

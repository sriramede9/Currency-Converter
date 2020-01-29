package com.sri.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}

}
  
//refer https://tech.asimio.net/2017/02/02/Refreshable-Configuration-using-Spring-Cloud-Config-Server-Spring-Cloud-Bus-RabbitMQ-and-Git.html
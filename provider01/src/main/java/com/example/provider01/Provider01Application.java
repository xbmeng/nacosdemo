package com.example.provider01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class Provider01Application {

	public static void main(String[] args) {
		SpringApplication.run(Provider01Application.class, args);
	}

	@RestController
	class EchoController {
		@Value("${server.port}")
		private String port;

		@RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
		public String echo(@PathVariable String string) {
			System.out.println(string);

			return "Hello Nacos Discovery01 " + "server port : " + port + string;
		}
	}

}

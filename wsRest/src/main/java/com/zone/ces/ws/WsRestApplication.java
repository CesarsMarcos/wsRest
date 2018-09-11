package com.zone.ces.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//(scanBasePackages={"com.zone.ces.ws.controller"})
public class WsRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsRestApplication.class, args);
	}
}

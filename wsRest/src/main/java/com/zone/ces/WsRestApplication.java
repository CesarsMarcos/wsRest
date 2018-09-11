package com.zone.ces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.zone.ces.ws.controller"})
//@ComponentScan
public class WsRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsRestApplication.class, args);
	}
}

package org.kau.mufiServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.TimeZone;

@SpringBootApplication(exclude = { UserDetailsServiceAutoConfiguration.class })
@EnableFeignClients
public class MufiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MufiServerApplication.class, args);

		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		TimeZone tz = TimeZone.getDefault();
		System.out.println("현재 시간대: " + tz.getID());


	}

}
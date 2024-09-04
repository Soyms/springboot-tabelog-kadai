package com.example.nagoyameshi.controller;

//あとで削除
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
//
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}) //あとで削除
@Controller
public class AuthController {
	
	//あとで削除
	public static void main(String[] args) {
	    SpringApplication.run(AuthController.class, args);
	}
	
	@GetMapping("/auth/login")
	public String login() {
	    return "auth/login";
	}
}

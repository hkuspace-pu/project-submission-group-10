package com.springboot;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.utils.TokenKey;

/**
 * Hk comp 2003 HongKongNatureWatch group pro
 * @author Leo
 * @date 24/10/2022
 * @apiNote backend for the application front-end
 * http://127.0.0.1:888/swagger-ui/index.html#/get-topic-content-controller
 * https://api.hktreewatch.org/swagger-ui/
 * */

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
	
}

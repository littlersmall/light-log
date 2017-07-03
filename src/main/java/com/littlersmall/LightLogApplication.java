package com.littlersmall;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.littlersmall.example.LogExample;
import com.littlersmall.example.TestInterface;

@SpringBootApplication
public class LightLogApplication {
	@Autowired
	LogExample logExample;

	@Autowired
	TestInterface testInterface;

	@PostConstruct
	public void init() throws InterruptedException {
		//logExample.argTest("hello", "world");
		//logExample.timeTest();
		testInterface.fun();
	}

	public static void main(String[] args) {
		SpringApplication.run(LightLogApplication.class, args);
	}
}

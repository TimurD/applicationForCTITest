package com.example.demo;

import com.example.domain.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.http.HTTPException;


@Controller
@EnableAutoConfiguration
public class DemoApplication {

	@PostMapping("/")
	public @ResponseBody Test postTest(@RequestHeader("Tenant-Ref") String module, @RequestBody Test test) throws Exception {
		System.out.println(module);
		return test;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

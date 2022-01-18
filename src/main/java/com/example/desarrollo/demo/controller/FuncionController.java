package com.example.desarrollo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")

public class FuncionController {

	@GetMapping("hello")
	public String sayHello() {
		return "Hola mundo";
	}

}

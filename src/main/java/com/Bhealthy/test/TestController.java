package com.Bhealthy.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {


	@GetMapping("/test1")
	@ResponseBody
	public String test1() {
		return "Hello world";
	}
	
	@GetMapping("/test2")
	public String test2() {
		return "test/test";
	}
}

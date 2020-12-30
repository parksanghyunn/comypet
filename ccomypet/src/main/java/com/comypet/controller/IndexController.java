package com.comypet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/*")
public class IndexController {
	@GetMapping("/")
	public String view() {
		return "view";
	}
	
	@GetMapping("/index")
	public void index() {}
}

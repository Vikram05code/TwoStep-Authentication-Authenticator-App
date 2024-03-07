package com.vikram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {

	@GetMapping("user")
	public ModelAndView user() {
		return new ModelAndView("user");
	}
	
	
	@RequestMapping
	public ModelAndView qrcode() {
		return new ModelAndView("qrcode");
	}
	
}

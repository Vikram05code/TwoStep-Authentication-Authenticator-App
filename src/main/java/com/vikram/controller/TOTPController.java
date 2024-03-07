package com.vikram.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vikram.model.User;
import com.vikram.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/2fa")
public class TOTPController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public @ResponseBody
	User createUser(@RequestBody User user) {
		
		User savedUser = userService.createUser(user);
		savedUser.setPassword("");
		
		return savedUser;
	}
	
	
	@GetMapping("/qrcode/get/{userName}")
	public String generateQRCode(@PathVariable String userName) throws Throwable {
		
		String otpProtocol = userService.generateOTPProtocol(userName);
		System.out.println(otpProtocol);
		
		return userService.generateQRCode(otpProtocol);
	}
	
	@PostMapping("/qrcode/validate/{userName}")
	public boolean validateTotp(@PathVariable String userName, @Valid @RequestBody String requestJson) {
		JSONObject json = new JSONObject(requestJson);
		
		return userService.validateTotp(userName, Integer.parseInt(json.getString("totpKey")));
	}
	
	
}

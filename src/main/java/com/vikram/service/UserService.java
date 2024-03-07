package com.vikram.service;

import com.vikram.model.User;

public interface UserService {

	User createUser(User user);
	
	String generateOTPProtocol(String userName);
	
	String generateQRCode(String otpProtocol) throws Throwable;
	
	boolean validateTotp(String userName, Integer totpKey);
	
}

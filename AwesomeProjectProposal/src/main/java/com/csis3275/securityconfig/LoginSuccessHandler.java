package com.csis3275.securityconfig;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.csis3275.controller_auth.AuthController;
import com.csis3275.controller_member.HomeController_Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	public static int State = 0; // 0 is user, 1 is admin

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		AuthController.setUserDetails((UserDetails) authentication.getPrincipal());
		UserDetails userDetails = AuthController.getUserDetails();
		String username = userDetails.getUsername();
		//HomeController_Member.setToken_s();
		if (State == 0) {
			response.sendRedirect("/member");
		} else if (State == 1) {
			response.sendRedirect("/admin");
		} 
	}
}

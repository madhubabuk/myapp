package com.hub.myapp.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class MyAppController {

	@Autowired
	private org.springframework.session.jdbc.JdbcIndexedSessionRepository sessionRepository;

	
	@GetMapping("/msg")
	public String getMessage() {
		return "Hello World!";
	}
	
	
	@GetMapping("/redirect")
	 public RedirectView redirectWithUsingRedirectView() {
		System.out.println("this is running");
		 return new RedirectView("/msg");
	 }

	@GetMapping("/timeoutuser/{user}")
	public String timeOutUser(@PathVariable("user") String user) {
		
		getSessions(user).forEach(sessionRepository::deleteById);
		/*
		 * sessionRepository.findByPrincipalName(user).keySet().forEach(t->{
		 * SessionInformation sessInfo = sessionRegistry.getSessionInformation(t);
		 * sessInfo.expireNow(); });
		 */
		
		
		System.out.println("session logged out");
		return user+ " expired";
	}

	@Cacheable("session")
	public Set<String> getSessions(String user) {
		return sessionRepository.findByPrincipalName(user).keySet();
	}
}

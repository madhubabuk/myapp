package com.hub.myapp.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.session.CompositeSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;
import org.springframework.security.web.session.ConcurrentSessionFilter;

@Configuration
@EnableWebSecurity
public class SecConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers("/resources/**"); }
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("passwd")).roles("USER");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/h2-console/**").permitAll().anyRequest().authenticated().and().formLogin().and().logout().and().httpBasic();
		//.defaultSuccessUrl("/home",true)
		http.headers().frameOptions().disable();
	//	http.sessionManagement().sessionAuthenticationStrategy(concurrentSession());
	//	 http.addFilterBefore(concurrentSessionFilter(), ConcurrentSessionFilter.class);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/*
	@Bean
	public SessionRegistry getSessionRegistry() {
	    return new SessionRegistryImpl();
	}
	
	 @Bean
	 ConcurrentSessionFilter concurrentSessionFilter() {
	            CustomSessionInformationExpiredStrategy redirectStrategy = new CustomSessionInformationExpiredStrategy("/logout");
	            System.out.println("############# concurrentSessionFilter #################");
	            CustomConcurrentSessionFilter concurrentSessionFilter = new CustomConcurrentSessionFilter(getSessionRegistry(), redirectStrategy);
	            return concurrentSessionFilter;
	    }
	 
	 
	 @Bean
	 public CompositeSessionAuthenticationStrategy concurrentSession() {

	            ConcurrentSessionControlAuthenticationStrategy concurrentAuthenticationStrategy = new ConcurrentSessionControlAuthenticationStrategy(getSessionRegistry());
	            concurrentAuthenticationStrategy.setMaximumSessions(1);
	            //concurrentAuthenticationStrategy.setExceptionIfMaximumExceeded(true);
	            List<SessionAuthenticationStrategy> delegateStrategies = new ArrayList<SessionAuthenticationStrategy>();
	            delegateStrategies.add(concurrentAuthenticationStrategy);
	            delegateStrategies.add(new SessionFixationProtectionStrategy());
	            delegateStrategies.add(new RegisterSessionAuthenticationStrategy(getSessionRegistry()));

	            CompositeSessionAuthenticationStrategy authenticationStrategy =  new CompositeSessionAuthenticationStrategy(delegateStrategies);
	            return authenticationStrategy;
	    }*/
}

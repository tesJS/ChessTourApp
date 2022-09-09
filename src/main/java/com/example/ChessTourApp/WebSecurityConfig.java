package com.example.ChessTourApp;


import java.util.ArrayList;
import com.example.ChessTourApp.service.UserDetailServiceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



/*import com.example.Bookstore.service.UserDetailServiceImpl;*/


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	  @Autowired UserDetailServiceImpl userDetailsService;
	 
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder) {		
		this.passwordEncoder = passwordEncoder;
	}


	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		
        http
        .authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
        .and()
        .logout()
        .and()        
        .authorizeRequests().antMatchers("/player/**","/user/**",
        		"/tour/api/save","/tour/api/result/save") //Enalbe RESTful access from my react fron end
        .permitAll()
        .anyRequest().authenticated()        
        .and().csrf().disable()
        
      .formLogin()
	      .loginPage("/login")
	      .permitAll()
          .defaultSuccessUrl("/tour/list/", true)
          .permitAll()
        .and()
        .logout()
        	.logoutUrl("/logout")
	        .permitAll()
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
        	.clearAuthentication(true)
        	.invalidateHttpSession(true)
        	.deleteCookies("JSESSIONID", "remember-me")
        	.logoutSuccessUrl("/login");
      
        
    }  
	
	// Uses users data from the database
	
	  @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	  throws Exception {
	  auth.userDetailsService(userDetailsService).passwordEncoder(new
	  BCryptPasswordEncoder()); 
	  
	  
	  }
	 
	 
	  
	  

	
	 
	 
}

package com.csis3275.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.csis3275.controller_oauth2.CustomOAuth2UserService;

import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
	    return new MvcRequestMatcher.Builder(introspector);
	}
	
	//
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception{

        http.csrf(c -> c.disable())

                .authorizeHttpRequests(request -> request
                        //.requestMatchers(mvc.pattern("/admin-page")).hasAuthority("ADMIN")
                        //.requestMatchers(mvc.pattern("/user-page")).hasAuthority("USER")
                        .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/loginpage/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/error/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/test")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/testAPICharts")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/**/*.*")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/login/oauth2/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/login/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/oauth2/**")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/admin/**")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/member/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasAuthority("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/member/**")).hasAnyAuthority("ADMIN", "USER")
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/oauth2/**")).permitAll()
                        .anyRequest().authenticated())
                .headers(headers -> headers.frameOptions().disable())
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")))
                .formLogin(login -> login.permitAll()
                        .loginPage("/loginpage")
                        .usernameParameter("email")
                        .passwordParameter("pass")
                        .defaultSuccessUrl("/admin"))
                .oauth2Login(login -> login
                        .loginPage("/loginpage")
                        .userInfoEndpoint()
                        .userService(userService)
                        .and()
                        .defaultSuccessUrl("/member/valida")
                        )
                .logout(logout -> logout.logoutSuccessUrl("/").permitAll());

		return http.build();		
	}

    @Bean
    UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("admin")
				.password("password")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
	
	  @Autowired
	    private CustomOAuth2UserService userService;
	  
	@Autowired
	public void configure (AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	

}

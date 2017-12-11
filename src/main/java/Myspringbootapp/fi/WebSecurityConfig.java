package Myspringbootapp.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private Myspringbootapp.fi.webcon.UserDetailServiceImpl userDetailsService;
	@Override

protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/css/**").permitAll()
	.and()
	.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated()
	.and()
	.formLogin()
	.loginPage("/login").defaultSuccessUrl("/home").permitAll()
	.and()
	.logout().permitAll();
}

@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	//auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	
	auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	
}
  

}

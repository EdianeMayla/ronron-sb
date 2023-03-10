package ronron.spring.boot.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	CustomUserDetailsService userDetailsService;
	
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	private String[] WHITE_LIST = new String[]{
			"/api/userscreator","/api/animals/perdidos","/filtrar"
	};
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
	  http.csrf().disable();
		http.authorizeRequests()
		.antMatchers(WHITE_LIST).permitAll()
		.anyRequest().authenticated()
		.and().httpBasic();
	}

}

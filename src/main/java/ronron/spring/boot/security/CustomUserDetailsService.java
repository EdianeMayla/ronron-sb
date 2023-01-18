package ronron.spring.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ronron.spring.boot.model.entities.Users;
import ronron.spring.boot.model.repositories.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UsersRepository userRepository;
	
	@Override
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users existsUser = userRepository.findByUsername(username);
		
		if (existsUser == null) {
			throw new Error("User already exists!");
		}
		
		return existsUser;
	}

}

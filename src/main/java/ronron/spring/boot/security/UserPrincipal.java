//package exercicio.spring.boot.security;
//
//import java.util.Collection;
//
//import org.apache.catalina.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import exercicio.spring.boot.model.entities.Users;
//
//public class UserPrincipal implements UserDetails{
//	
//	private String username;
//	private String password;
//	private Collection<? extends GrantedAuthority> authorities;
//	
//	public UserPrincipal(User user) {
//		this.username= user.getUsername();
//		this.password = user.getPassword();
//	}
//	
//	
//	public static UserPrincipal create(Users existsUser) {
//		return new UserPrincipal(existsUser);
//	}
//	
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return password;
//	}
//
//	@Override
//	public String getUsername() {
//		return username;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//}

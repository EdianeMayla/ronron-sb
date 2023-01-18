package ronron.spring.boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ronron.spring.boot.model.entities.Users;
import ronron.spring.boot.model.repositories.UsersRepository;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Users save(Users user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        usersRepository.save(user);
        return user;
    }

    public Iterable<Users> obterUsuarios() {
        return usersRepository.findAll();
    }
}

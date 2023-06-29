package ru.skypro.homework.springsecurity.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.skypro.homework.springsecurity.pojo.AuthUser;
import ru.skypro.homework.springsecurity.repository.UserRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public SecurityUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = userRepository.findByUsername(username);
        //AuthUserDTO userDTO = AuthUserDTO.fromAuthUser(userRepository.findByUsername(username));
        if (authUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new SecurityUserPrincipal(authUser);
    }
}

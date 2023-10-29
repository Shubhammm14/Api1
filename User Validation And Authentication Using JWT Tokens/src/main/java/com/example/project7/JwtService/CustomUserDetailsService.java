package com.example.project7.JwtService;

import com.example.project7.jwtmodel.CustomUserDetails;
import com.example.project7.jwtmodel.User;
import com.example.project7.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        final User user = userRepository.findByName(name);
        if (user == null) {
            throw new UsernameNotFoundException("user not found!!");
        } else {
            return new CustomUserDetails(user);
        }

    }
}

package com.rahi.springsecurityc2.services;

import com.rahi.springsecurityc2.model.SecurityUser;
import com.rahi.springsecurityc2.model.User;
import com.rahi.springsecurityc2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

/**
 * @Author Amimul Ehsan
 * @Created at 10/21/21
 * @Project spring-security-c1
 */


public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername( String userName ) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUserName(userName);
        User user1 = user.orElseThrow(() -> new UsernameNotFoundException("ERROR!"));
        return new SecurityUser(user1);
    }
}

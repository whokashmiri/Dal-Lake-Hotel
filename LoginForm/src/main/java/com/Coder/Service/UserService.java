package com.Coder.Service;

import com.Coder.Model.ApplicationUser;
import com.Coder.Model.Role;
import com.Coder.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
     @Autowired
     private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Details Service");
        return userRepository.findByUsername(username).
                orElseThrow(() ->
        new UsernameNotFoundException("Username not found"));
//        System.out.println("User Details ");
//        if(!username.equals("Aaqib"))
//            throw new UsernameNotFoundException("Not Aaqib");
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(1,"USER"));
//
//        return new ApplicationUser(1,"Aaqib" , passwordEncoder
//                .encode("password"),roles);
    }
}

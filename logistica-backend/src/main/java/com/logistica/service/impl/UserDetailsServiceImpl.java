package com.logistica.service.impl;

import com.logistica.entity.User;
import com.logistica.repository.UserRepository;

import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if ("logistica".equals(username)) {
//			//return new User("logistica", "$2a$14$dB45z8lYkx5KTGSk5eULIekBRzJ7T4I83Ni0ykSHBOZl2xuwhTbey",
//			return new User("logistica", "$2a$10$ixlPY3AAd4ty1l6E2IsQ9OFZi2ba9ZQE0bP7RFcGIWNhyFrrT3YUi",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	}
        
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("--3-----"+username);
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        System.out.println("--4-----"+user.getEmail());
        return UserDetailsImpl.build(user);
    }
    
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//            if ("logistica".equals(username)) {
//                    //return new User("logistica", "$2a$14$dB45z8lYkx5KTGSk5eULIekBRzJ7T4I83Ni0ykSHBOZl2xuwhTbey",
//                    User user =  new User("logistica", "HOLA@X.COM", "$2a$10$ixlPY3AAd4ty1l6E2IsQ9OFZi2ba9ZQE0bP7RFcGIWNhyFrrT3YUi");
//                    System.out.println("--5-----"+username);
//                    return UserDetailsImpl.build(user);
//            } else {
//                    System.out.println("--6-----"+username);
//                    throw new UsernameNotFoundException("User not found with username: " + username);
//            }
//    }

}
package me.naveen.springsecurityoauth.Service;

import me.naveen.springsecurityoauth.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by navee on 10-10-2016.
 */
@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Fetching User");
      return new UserRepository().loadByUsername(username);
    }
}

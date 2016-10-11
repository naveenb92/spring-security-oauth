package me.naveen.springsecurityoauth.respository;

import me.naveen.springsecurityoauth.model.ApplicationUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by navee on 10-10-2016.
 */
public class UserRepository {


    public User loadByUsername(String username){

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<GrantedAuthority>();
        grantedAuthoritySet.add(grantedAuthority);

        ApplicationUser applicationUser = new ApplicationUser(username,"Demo@123",grantedAuthoritySet);
        applicationUser.setId(12L);
        applicationUser.setTenantId("Tenant 1");
        return applicationUser;
    }

}

package me.naveen.springsecurityoauth.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by Naveen Babu on 05-05-2016.
 */
public class ApplicationUser extends User {

    private Long id;
    private String tenantId;

    public ApplicationUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username,password,authorities);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}

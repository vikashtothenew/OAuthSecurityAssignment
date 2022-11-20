package com.example.SecurityAssignment.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String email;
    private String password;

    //TO ADD - GETTERS AND SETTERS

    private String first_name;
    private String middle_name;
    private String last_name;
    private boolean is_deleted;
    private boolean is_active;
    private boolean is_expired;
    private boolean is_locked;
    private Date password_update_date;
    private int invalid_attempt_count;



    List<GrantAuthorityImpl> grantAuthorityList;

    public User(String username, String password, List<GrantAuthorityImpl> grantAuthorityList) {
        this.email = username;
        this.password = password;
        this.grantAuthorityList = grantAuthorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantAuthorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

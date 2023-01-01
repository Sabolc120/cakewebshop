package com.example.cakeExamBackend.Security.SImplementations;

import com.example.cakeExamBackend.Models.UserModel;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
public class UserDetailsImpl implements UserDetails {

    private final UserModel userModel;

    Set<GrantedAuthority> authorities = null;

    public UserDetailsImpl(UserModel userModel) {
        this.userModel= userModel;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userModel.getAuthorities()));
        if(userModel.getAuthorities() == null){
            userModel.setAuthorities("USER");
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userModel.getUserPassword();
    }

    @Override
    public String getUsername() {
        return userModel.getUserName();
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

package org.example.Service;

import org.example.Entity.UserInfo;
import org.example.Entity.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class CustomUserDetails implements UserDetails {


    private String userName ;
    private String passWord ;

    Collection<? extends GrantedAuthority> authorities ;

     public CustomUserDetails(UserInfo user){

         this.userName = getUsername() ;
         this.passWord = getPassword() ;
         List<GrantedAuthority> auths = new ArrayList<>();

         for(UserRole role : user.getRoles()){
             auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
         }

         this.authorities = auths ;
     }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities ;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

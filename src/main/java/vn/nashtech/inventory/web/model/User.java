package vn.nashtech.inventory.web.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
@Data
public class User implements UserDetails {
    private long id;
    private String username;
    private String password;
    private  String email;
    private  String firstName;
    private String lastName;

    public User() {
    }


    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    @Override public String getUsername() {
        return username;
    }

//    public String getUserName() {
//        return userName;
//    }

    @Override public boolean isAccountNonExpired() {
        return true;
    }

    @Override public boolean isAccountNonLocked() {
        return true;
    }

    @Override public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //    private String fullName;
//    private String email;
//    private String phoneNumber;
//    private int avatar;
//    private String role;
//    private String createdDate;
//    private String modifiedDate;
//    private String lastUsed;
}

package org.example.rentcar.entity;

import org.example.rentcar.enums.Role;
import org.example.rentcar.utility.core_entity.CoreEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users extends CoreEntity implements UserDetails {
    @Column(nullable = false, unique = true)
    String userName;
    String name;
    String email;
    String phone;
    String licence;
    String password;
    Double balance;
    @Enumerated(EnumType.STRING)
    Role role;

    @OneToMany(mappedBy = "user")
    List<Apeal> apeals;

    @OneToMany(mappedBy = "user")
    List<Order> orders;

    @OneToMany(mappedBy = "user")
    List<Like> likes;

    @OneToMany(mappedBy = "user")
    List<Comment> comments;

    @OneToMany(mappedBy = "user")
    List<Reply> replies;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "ROLE_" + role.name());
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}

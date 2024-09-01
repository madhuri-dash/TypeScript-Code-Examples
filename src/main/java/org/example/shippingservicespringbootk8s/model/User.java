package org.example.shippingservicespringbootk8s.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(nullable = false)
        private Integer id;

        @Column(nullable = false)
        private String fullName;

        @Column(unique = true, length = 100, nullable = false)
        private String email;

        @Getter
        @Column(nullable = false)
        private String password;

        @CreationTimestamp
        @Column(updatable = false, name = "created_at")
        private Date createdAt;

        @UpdateTimestamp
        @Column(name = "updated_at")
        private Date updatedAt;

        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of();
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

        // Getters and setters
    }
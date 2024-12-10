package org.lifeline.model;

import jakarta.persistence.*;

@Entity
@Table(name="Auth")
public class AuthRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "EmailId", nullable = false, unique = true)
    private String email;
    @Column(name = "Password", nullable = false)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

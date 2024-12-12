package org.lifeline.model;

import jakarta.persistence.*;
import org.lifeline.enums.RegistrationType;

@Entity
@Table(name="Auth")
public class AuthRequest {
    @Id
    private Long id;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private RegistrationType registrationType;

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

    public RegistrationType getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(RegistrationType registrationType) {
        this.registrationType = registrationType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

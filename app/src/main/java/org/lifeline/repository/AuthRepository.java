package org.lifeline.repository;

import org.lifeline.model.AuthRequest;
import org.lifeline.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthRequest, Long> {
    AuthRequest findByEmail(String email);
}

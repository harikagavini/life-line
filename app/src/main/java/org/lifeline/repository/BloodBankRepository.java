package org.lifeline.repository;

import org.lifeline.model.BloodBank;
import org.lifeline.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodBankRepository extends JpaRepository<BloodBank, Long> {
    BloodBank findByEmail(String email);
    BloodBank findByBranchId(String branchId);
}

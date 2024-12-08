package org.lifeline.repository;

import org.lifeline.model.HospitalLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalLocationRepository extends JpaRepository<HospitalLocation, Long> {
}

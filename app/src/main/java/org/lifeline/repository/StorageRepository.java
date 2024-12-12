package org.lifeline.repository;

import org.lifeline.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage, String> {
}

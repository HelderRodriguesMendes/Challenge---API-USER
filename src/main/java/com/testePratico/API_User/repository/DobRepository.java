package com.testePratico.API_User.repository;

import com.testePratico.API_User.model.Dob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DobRepository extends JpaRepository<Dob, Long> {
}

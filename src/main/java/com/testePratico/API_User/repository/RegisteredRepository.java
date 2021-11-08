package com.testePratico.API_User.repository;

import com.testePratico.API_User.model.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredRepository extends JpaRepository<Registered, Long> {
}

package com.testePratico.API_User.repository;

import com.testePratico.API_User.model.Timezone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimezoneRepository extends JpaRepository<Timezone, Long> {
}

package com.testePratico.API_User.repository;

import com.testePratico.API_User.model.IdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdEntityRepository extends JpaRepository<IdEntity, Long> {
}

package com.testePratico.API_User.repository;

import com.testePratico.API_User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT MAX(imported_t) FROM users", nativeQuery = true)
    public LocalDateTime getLastImport();

    @Query(value = "SELECT * FROM users WHERE status = 1", nativeQuery = true)
    public List<User> getAllUsersPublished();
}

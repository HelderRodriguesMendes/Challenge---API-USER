package com.testePratico.API_User.repository;

import com.testePratico.API_User.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable(value = "getLastImport")
    @Transactional
    @Query(value = "SELECT MAX(imported_t) FROM users WHERE status = 1", nativeQuery = true)
    public LocalDateTime getLastImport();

    @Transactional
    @Query(value = "SELECT * FROM users WHERE status = 1", nativeQuery = true)
    public Page<User> getAllUsersPublished(Pageable pageable);

    @Transactional
    @Query(value = "SELECT * FROM users WHERE status = 1 and id_user_api = ?1", nativeQuery = true)
    public Optional<User> getUserId(Long userId);

    @Transactional
    @Query(value = "select * from users LIMIT 1", nativeQuery = true)
    public Optional<User> checkDatabaseNull();

    @Transactional
    @Modifying
    @Query(value = "update users set status = 0 where id_user_api = ?1", nativeQuery = true)
    public void delete(Long id);
}

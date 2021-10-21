package com.rahi.springsecurityc2.repo;

import com.rahi.springsecurityc2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author Amimul Ehsan
 * @Created at 10/21/21
 * @Project spring-security-c1
 */

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUserName( String userName );
}

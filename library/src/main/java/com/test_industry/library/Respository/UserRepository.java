package com.test_industry.library.Respository;

import com.test_industry.library.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

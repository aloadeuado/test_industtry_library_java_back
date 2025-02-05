package com.test_industry.library.Respository;

import com.test_industry.library.Models.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {
}

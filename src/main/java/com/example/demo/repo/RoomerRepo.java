package com.example.demo.repo;

import com.example.demo.model.Roomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomerRepo extends JpaRepository<Roomer, Long> {
}

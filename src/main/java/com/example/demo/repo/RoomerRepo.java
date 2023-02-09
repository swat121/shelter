package com.example.demo.repo;

import com.example.demo.model.Roomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomerRepo extends JpaRepository<Roomer, Long> {
    @Query(value="SELECT * FROM roomer WHERE id =?1", nativeQuery = true)
    Roomer findRoomerById(Long id);

    List<Roomer> findAllByRoomNumber(int number);
}

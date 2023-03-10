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

    @Query(value = "select * from roomer where move_out_date is null", nativeQuery = true)
    List<Roomer> findAllLiving();

    List<Roomer> findAllByRoomNumber(int number);

    List<Roomer> findAllBySecondName(String secondName);
}

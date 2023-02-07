package com.example.demo.service;

import com.example.demo.model.Roomer;
import com.example.demo.repo.RoomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class RoomerService {

    private final RoomerRepo roomerRepo;
    private Date currentDate;

    public void saveRoomer(Roomer roomer) {
        currentDate = new Date();
        roomer.setSettlementDate(currentDate);
        roomerRepo.save(roomer);
    }
}

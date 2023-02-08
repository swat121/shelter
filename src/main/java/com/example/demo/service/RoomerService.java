package com.example.demo.service;

import com.example.demo.model.Roomer;
import com.example.demo.repo.RoomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public List<Roomer> getListOfRoomers(){
        return roomerRepo.findAll();
    }
    public Roomer getRoomerById(Long id) {
        return roomerRepo.findRoomerById(id);
    }
    public void editRoomer(Roomer roomer) {
        this.roomerRepo.save(roomer);
    }
}

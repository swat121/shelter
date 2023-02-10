package com.example.demo.service;

import com.example.demo.model.Roomer;
import com.example.demo.repo.RoomRepo;
import com.example.demo.repo.RoomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomerService {

    private final RoomerRepo roomerRepo;
    private final RoomRepo roomRepo;
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
        return roomerRepo.findById(id).orElse(null) ;
    }
    public void editRoomer(Roomer roomer) {
        this.roomerRepo.save(roomer);
    }
    public boolean isRoomFree(Roomer roomer) {
        int numberOfRoom = roomer.getRoomNumber();
        int peopleInRoom = roomerRepo.findAllByRoomNumber(numberOfRoom).size();
        return peopleInRoom < roomRepo.findRoomByNumber(numberOfRoom).getCapacity();
    }
    public List<Roomer> getListOfRoomersBySecondName(String secondName) {
        return roomerRepo.findAllBySecondName(secondName);
    }
}

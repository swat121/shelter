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
    public List<Roomer> getAllRoomers(){
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
    public boolean isRoomExist(Roomer roomer) {
        return roomRepo.findRoomByNumber(roomer.getRoomNumber()) != null;
    }
    public List<Roomer> getListOfRoomersBySecondName(String secondName) {
        return roomerRepo.findAllBySecondName(secondName);
    }
    public void evictRoomer(Long id) {
        System.out.println("=============================================111111111111111111111");
        currentDate = new Date();
        System.out.println("============================================= 2");
        Roomer roomer = roomerRepo.findRoomerById(id);
        System.out.println("============================================= 3");
        roomer.setMoveOutDate(currentDate);
        System.out.println("============================================= 4");
        roomerRepo.save(roomer);
    }

    public List<Roomer> getThisRoomers() {
        return roomerRepo.findAllLiving();
    }
}

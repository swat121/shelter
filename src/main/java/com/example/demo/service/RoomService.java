package com.example.demo.service;

import com.example.demo.model.Room;
import com.example.demo.model.Roomer;
import com.example.demo.repo.RoomRepo;
import com.example.demo.repo.RoomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepo roomRepo;
    private final RoomerRepo roomerRepo;

    public List<Roomer> getRoomersByRoom(int number) {
        return roomerRepo.findAllByRoomNumber(number);
    }

    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }
}

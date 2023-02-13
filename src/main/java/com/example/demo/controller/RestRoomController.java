package com.example.demo.controller;

import com.example.demo.model.Room;
import com.example.demo.repo.RoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestRoomController {

    private final RoomRepo roomRepo;

    @PostMapping("/api/rooms/add")
    public Room addRoom(@RequestParam(value = "number", required = false) int number, @RequestParam(value = "capacity", required = false) int capacity) {
        Room room = new Room();
        room.setCapacity(capacity);
        room.setNumber(number);
        return roomRepo.save(room);
    }
}

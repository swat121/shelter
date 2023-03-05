package com.example.demo.controller;

import com.example.demo.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/")
    public String getRooms(Model model) {
        return "main";
    }
    @GetMapping("/rooms/{id}")
    public String getRoomById(Model model, @PathVariable(value = "id") int number) {
        model.addAttribute("roomers", roomService.getRoomersByRoom(number));
        return "room";
    }
    @GetMapping("/load")
    public String getLoadRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "main";
    }
}

package com.example.demo.controller;

import com.example.demo.model.Roomer;
import com.example.demo.service.RoomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RoomerController {
    private final RoomerService roomerService;

    @GetMapping("/roomer/save")
    public String saveRoomer(Model model){
        model.addAttribute("roomer", new Roomer());
        return "save";
    }

    @PostMapping("/roomer/save")
    public String getDataOfRoomer(@ModelAttribute("roomer") Roomer roomer) {
        roomerService.saveRoomer(roomer);
        return "redirect:/roomers";
    }
    @GetMapping("/roomers")
    public String getListOfRoomers(Model model){
        model.addAttribute("list", roomerService.getListOfRoomers());
        return "list";
    }
}

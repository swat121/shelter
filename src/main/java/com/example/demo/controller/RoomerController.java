package com.example.demo.controller;

import com.example.demo.model.Roomer;
import com.example.demo.service.RoomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/roomer/{id}")
    public String getRoomer(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("roomer", roomerService.getRoomerById(id));
        return "roomer-info";
    }

    @GetMapping("/roomer/{id}/update")
    public String getRoomerForUpdate(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("roomer", roomerService.getRoomerById(id));
        return "roomer-edit";
    }
    @PostMapping("/roomer/update/{id}")
    public String updateRoomer(@ModelAttribute("updateRoomer") Roomer updateRoomer, @PathVariable(value = "id") Long id) {
        updateRoomer.setId(id);
        roomerService.editRoomer(updateRoomer);
        return "redirect:/roomers";
    }
}

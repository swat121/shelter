package com.example.demo.controller;

import com.example.demo.model.Roomer;
import com.example.demo.service.RoomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RoomerController {
    private final RoomerService roomerService;

    @GetMapping("/roomer/add")
    public String saveRoomer(Model model){
        model.addAttribute("roomer", new Roomer());
        return "save";
    }

    @PostMapping("/roomer/add")
    public String getDataOfRoomer(@Valid @ModelAttribute("roomer") Roomer roomer, BindingResult result) {
        if (result.hasErrors()) {
            return "save";
        }
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
        Roomer roomer = roomerService.getRoomerById(id);
        if (roomer == null) {
            model.addAttribute("message", "Roomer does not exist");
        } else {
            model.addAttribute("roomer", roomer);
        }
        return "roomer-info";
    }

    @GetMapping("/roomer/{id}/edit")
    public String getRoomerForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Roomer roomer = roomerService.getRoomerById(id);
        if (roomer == null) {
            model.addAttribute("message", "Roomer does not exist");
        } else {
            model.addAttribute("roomer", roomer);
        }
        return "roomer-edit";
    }
    @PostMapping("/roomer/update/{id}")
    public String updateRoomer(@Valid @ModelAttribute("updateRoomer") Roomer updateRoomer, @PathVariable(value = "id") Long id, BindingResult result) {
        if (result.hasErrors()) {
            return "roomer-info";
        }
        Roomer roomer = roomerService.getRoomerById(id);
        updateRoomer.setSettlementDate(roomer.getSettlementDate());
        updateRoomer.setMoveOutDate(roomer.getMoveOutDate());
        updateRoomer.setId(id);
        roomerService.editRoomer(updateRoomer);
        return "redirect:/roomers";
    }
}

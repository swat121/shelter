package com.example.demo.controller;


import com.example.demo.model.Roomer;
import com.example.demo.service.RoomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class RoomerController {
    private final RoomerService roomerService;

    @GetMapping("/roomers/add")
    public String saveRoomer(Model model){
        model.addAttribute("roomer", new Roomer());
        return "save";
    }

    @PostMapping("/roomers/add")
    public String getDataOfRoomer(@Valid @ModelAttribute("roomer") Roomer roomer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "save";
        }
        if (!roomerService.isRoomExist(roomer)) {
            model.addAttribute("message", "Такої кімнати не існує");
            return "roomer-edit";
        }
        if (!roomerService.isRoomFree(roomer)) {
            model.addAttribute("message", "Ця кімната зайнята");
            return "save";
        }
        roomerService.saveRoomer(roomer);
        return "redirect:/roomers";
    }
    @GetMapping("/roomers")
    public String getListOfRoomers(Model model){
        model.addAttribute("list", roomerService.getListOfRoomers());
        model.addAttribute("roomers", new Roomer());
        return "list";
    }

    @PostMapping("/roomers")
    public String findRoomer(@ModelAttribute("roomers") Roomer roomer, Model model, BindingResult bindingResult) {
        List<Roomer> roomers = roomerService.getListOfRoomersBySecondName(roomer.getSecondName());
        if (roomers.isEmpty()) {
            bindingResult.addError(new FieldError("roomers","secondName","Такого мешканця не існує"));
        } else {
            model.addAttribute("list", roomers);
        }
        return "list";

    }

    @GetMapping("/roomers/{id}")
    public String getRoomer(@PathVariable(value = "id") Long id, Model model) {
        Roomer roomer = roomerService.getRoomerById(id);
        if (roomer == null) {
            model.addAttribute("message", "Roomer does not exist");
        } else {
            model.addAttribute("roomer", roomer);
        }
        return "roomer-info";
    }

    @GetMapping("/roomers/{id}/edit")
    public String getRoomerForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Roomer roomer = roomerService.getRoomerById(id);
        if (roomer == null) {
            model.addAttribute("message", "Roomer does not exist");
        } else {
            model.addAttribute("roomer", roomer);
        }
        return "roomer-edit";
    }
    @PostMapping("/roomers/update/{id}")
    public String updateRoomer(@Valid @ModelAttribute("updateRoomer") Roomer updateRoomer, @PathVariable(value = "id") Long id, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "roomer-info";
        }
        Roomer roomer = roomerService.getRoomerById(id);
        if (!roomerService.isRoomExist(updateRoomer)) {
            model.addAttribute("roomer", roomer);
            model.addAttribute("errorNumber", "Такої кімнати не існує");
            return "roomer-edit";
        }
        if (!roomerService.isRoomFree(updateRoomer)) {
            model.addAttribute("roomer", roomer);
            model.addAttribute("errorNumber", "Ця кімната зайнята");
            return "roomer-edit";
        }
        updateRoomer.setSettlementDate(roomer.getSettlementDate());
        updateRoomer.setMoveOutDate(roomer.getMoveOutDate());
        updateRoomer.setId(id);
        roomerService.editRoomer(updateRoomer);
        return "redirect:/roomers";
    }
}

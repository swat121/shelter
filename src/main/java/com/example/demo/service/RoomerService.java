package com.example.demo.service;

import com.example.demo.model.Roomer;
import com.example.demo.repo.RoomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomerService {

    private final RoomerRepo roomerRepo;

    public void saveRoomer(Roomer roomer) {
        roomerRepo.save(roomer);
    }
}

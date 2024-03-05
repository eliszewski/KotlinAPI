package com.example.kotlinspring.controller;

import com.example.kotlinspring.entity.Trainer;
import com.example.kotlinspring.repository.TrainerRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("trainer")
public class TrainerController {

    @Autowired
    private TrainerRepository trainerRepository;

    @GetMapping("/")
    public List<Trainer> getAll(){
        return trainerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Trainer getById(Long id){
        return trainerRepository.findById(id).orElseThrow(() -> new NoResultException("Trainer with id: " + " not found."));
    }

    @PostMapping("/")
    public Trainer add(Trainer trainer){
        return trainerRepository.save(trainer);
    }
}

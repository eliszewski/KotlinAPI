package com.example.kotlinspring.controller

import com.example.kotlinspring.entity.Trainer
import com.example.kotlinspring.repository.TrainerRepository
import jakarta.persistence.NoResultException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/trainer")
class TrainerController {

    @Autowired
    private lateinit var trainerRepository: TrainerRepository

    @GetMapping("/")
    fun getAll(): List<Trainer> {
        return trainerRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Trainer {
        return trainerRepository.findById(id).orElseThrow { NoResultException("Trainer with id: $id not found.") }
    }

    @PostMapping("/")
    fun add(@RequestBody trainer: Trainer): Trainer {
        return trainerRepository.save(trainer)
    }
}

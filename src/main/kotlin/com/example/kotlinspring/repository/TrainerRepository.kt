package com.example.kotlinspring.repository

import com.example.kotlinspring.entity.Trainer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrainerRepository : JpaRepository<Trainer, Long>{
}
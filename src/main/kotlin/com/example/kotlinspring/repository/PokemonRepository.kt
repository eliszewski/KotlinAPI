package com.example.kotlinspring.repository

import com.example.kotlinspring.entity.Pokemon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PokemonRepository : JpaRepository<Pokemon, Long>

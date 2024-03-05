package com.example.kotlinspring.controller

import com.example.kotlinspring.entity.Pokemon
import com.example.kotlinspring.repository.PokemonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/pokemon")
class PokemonController {

    @Autowired
    lateinit var pokemonRepository: PokemonRepository

    @GetMapping("/")
    fun getAllPokemon(): List<Pokemon> {
        return pokemonRepository.findAll()
    }

    @GetMapping("/template")
    fun getPokemon(model: Model): String {
        val pokemonList = pokemonRepository.findAll()
        model.addAttribute("pokemonList", pokemonList)
        return "pokemon-list"
    }

    @GetMapping("/{id}")
    fun getPokemonById(@PathVariable id: Long): Pokemon {
        return pokemonRepository.findById(id)
            .orElseThrow { NoSuchElementException("Pokemon with id $id not found") }
    }

    @PostMapping("/")
    fun addPokemon(@RequestBody pokemon: Pokemon): Pokemon {
        return pokemonRepository.save(pokemon)
    }

    @PutMapping("/{id}")
    fun updatePokemon(@PathVariable id: Long, @RequestBody updatedPokemon: Pokemon): Pokemon {
        val existingPokemon = pokemonRepository.findById(id)
            .orElseThrow { NoSuchElementException("Pokemon with id $id not found") }

        existingPokemon.species = updatedPokemon.species
        existingPokemon.level = updatedPokemon.level
        existingPokemon.primaryType = updatedPokemon.primaryType

        return pokemonRepository.save(existingPokemon)
    }

    @DeleteMapping("/{id}")
    fun deletePokemon(@PathVariable id: Long) {
        if (!pokemonRepository.existsById(id)) {
            throw NoSuchElementException("Pokemon with id $id not found")
        }
        pokemonRepository.deleteById(id)
    }
}

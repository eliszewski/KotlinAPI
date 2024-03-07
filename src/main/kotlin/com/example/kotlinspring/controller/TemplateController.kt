package com.example.kotlinspring.controller

import com.example.kotlinspring.repository.PokemonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/template")
class TemplateController() {
    @Autowired
    private lateinit var pokemonRepository: PokemonRepository
    @GetMapping("/pokemon/all")
    fun getPokemon(model: Model): String {
        val pokemonList = pokemonRepository.findAll()
        model.addAttribute("pokemonList", pokemonList)
        return "pokemon-list"
    }
}

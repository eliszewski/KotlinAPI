package com.example.kotlinspring

import com.example.kotlinspring.entity.Pokemon
import com.example.kotlinspring.entity.Trainer
import com.example.kotlinspring.entity.TrainerClass
import com.example.kotlinspring.entity.Type
import com.example.kotlinspring.repository.PokemonRepository
import com.example.kotlinspring.repository.TrainerRepository
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
class AppSetup {
    var addData : Boolean = false
    @Autowired
    lateinit var pokemonRepository: PokemonRepository

    @Autowired
    lateinit var trainerRepository: TrainerRepository

    @PostConstruct
    fun setup(){
        if(addData) {
            var trainer1 : Trainer = Trainer()
            trainer1.name = "Kevin"
            trainer1.trainerClass = TrainerClass.ACE_TRAINER

            var trainer2 : Trainer = Trainer()
            trainer2.name = "Red"
            trainer2.trainerClass = TrainerClass.POKEMON_TRAINER
            var pokemon1 : Pokemon = Pokemon()
            pokemon1.species = "Zubat"
            pokemon1.level = 15
            pokemon1.primaryType = Type.FLYING
            pokemon1.secondaryType = Type.POISON
            pokemon1.nickName = pokemon1.species
            pokemon1.trainer = trainer1

            trainerRepository.save(trainer1)
            trainerRepository.save(trainer2)
            pokemonRepository.save(pokemon1)
        }
    }
}
package com.example.kotlinspring.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name="POKEMON")
data class Pokemon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id : Long = 0,

    @Column(name = "SPECIES")
    var species: String = "",

    @Column(name = "NICKNAME")
    var nickName: String = species,

    @Column(name = "LVL")
    var level: Int = 1,

    @Enumerated(EnumType.STRING)
    @Column(name = "PRIMARY_TYPE")
    var primaryType: Type = Type.NONE,

    @Enumerated(EnumType.STRING)
    @Column(name = "SECONDARY_TYPE")
    var secondaryType: Type = Type.NONE,

    @ManyToOne
    @JoinColumn(name = "TRAINER_ID")
    @JsonBackReference
    var trainer: Trainer? = null

)

enum class Type {
    NONE,
    NORMAL,
    FIRE,
    WATER,
    ELECTRIC,
    GRASS,
    ICE,
    FIGHTING,
    POISON,
    GROUND,
    FLYING,
    PSYCHIC,
    BUG,
    ROCK,
    GHOST,
    DRAGON,
    DARK,
    STEEL,
    FAIRY
}


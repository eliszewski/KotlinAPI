package com.example.kotlinspring.entity
import kotlin.collections.MutableList



import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="TRAINER")
data class Trainer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id : Long = 0,

    @Column(name = "NAME")
    var name : String = "",

    @Enumerated(EnumType.STRING)
    @Column(name = "TRAINER_CLASS")
    var trainerClass: TrainerClass = TrainerClass.UNKNOWN,

    @OneToMany(mappedBy = "trainer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var pokemon: MutableList<Pokemon> = mutableListOf()

)

enum class TrainerClass {
    ACE_TRAINER,
    BEAUTY,
    BLACK_BELT,
    BURGLAR,
    COOL_TRAINER,
    CRUSH_GIRL,
    CRUSH_KIN,
    DRAGON_TAMER,
    EXPERT_TRAINER,
    HEX_MANIAC,
    HIKER,
    KINDLER,
    LADY,
    LASS,
    LEADER,
    POKEMON_BREEDER,
    POKEMON_RANGER,
    POKEMON_TRAINER,
    POKE_FAN,
    PSYCHIC,
    RIDER,
    ROCKET_GRUNT,
    ROLLER_BOY,
    SCHOOL_KID,
    SCIENTIST,
    SWIMMER,
    TRIATHLETE,
    TUBER,
    TUBERINA,
    TWINS,
    YOUNGSTER,
    UNKNOWN
}


import kotlin.system.exitProcess


open class Opponent(var name: String, var health: Double) {


    var originHeatlhCommon: Double


    init {
        this.originHeatlhCommon = health
    }

    open fun reduceHealthByHospital(character: Character) {

    }


    open fun attackOpponent(characterList: MutableList<Character>, attack: Int) {
        val defeatedTargets = mutableListOf<Character>()
        if (characterList.isNotEmpty()) {
            for (target in characterList) {
                target.health -= attack
                target.health = roundDouble(target.health)
                println("FUN ATTACK ON ALL WARRIORS. An opponent ${target.name} has been defeated. Health ${target.name} equals ${target.health} ")
            }
            println("------------------------------------------------")
        }
    }


    open fun healthOpponent(opponent: Opponent, points: Int) {
        opponent.health += points
        opponent.health = roundDouble(opponent.health)
        println("${opponent.name} has been reinstated to $points points")
        println("${opponent.name} has more health ${opponent.health}")
        println("------------------------------------------------")
    }

    open fun attackcOpponent(character: Character, attack: Int) {
        character.health -= attack
        character.health = roundDouble(character.health)
        println("${this.name} attacked and dealt $attack damage")
        println("${character.name} has more health ${character.health}")
        println("------------------------------------------------")
    }


}

import kotlin.system.exitProcess


open class Opponent(var name: String, var health: Double) {


    var originHeatlhCommon: Double


    init {
        this.originHeatlhCommon = health
    }

    open fun reduceHealthByHospital(character: Character) {

    }
    open fun attackOpponent(characterList: MutableList<Character>, attack: Int) {
        if (characterList.isNotEmpty()) {
            for (target in characterList) {
                target.health -= attack
                target.health = roundDouble(target.health)
                println(redTextStrongOpponent("FUN ATTACK ON ALL WARRIORS. An opponent ${target.name} has been defeated. Health ${target.name} equals ${target.health} "))
            }
            println(redTextStrongOpponent("------------------------------------------------"))
        }
    }


    open fun attackcOpponent(character: Character, attack: Int) {
        character.health -= attack
        character.health = roundDouble(character.health)
        println(redTextStrongOpponent("${this.name} attacked and dealt $attack damage.${character.name} has more health ${character.health}"))
        println(redTextStrongOpponent("------------------------------------------------"))
    }




}

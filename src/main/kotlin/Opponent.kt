open class Opponent(var name: String, var health: Double) {
    var originHealthCommon: Double = health

    private fun coloredMessageSeparator(): String {
        return when (this) {
            is CommonOpponent -> purpleTextCommonOpponent("------------------------------------------------")
            is StrongOpponent -> redTextStrongOpponent("------------------------------------------------")
            else -> "------------------------------------------------"
        }
    }


    open fun allAtOnce(characterList: MutableList<Character>, attack: Int) {
        if (characterList.isNotEmpty()) {
            for (target in characterList) {
                target.health -= attack
                target.health = roundDouble(target.health)
//                println(redTextStrongOpponent("FUN ATTACK ON ALL WARRIORS. ${target.name} has been defeated. Health ${target.name} equals ${target.health} "))
                val message = "FUN ATTACK ON ALL WARRIORS. ${target.name} has been defeated. Health ${target.name} equals ${target.health}"
                val coloredMessage = when (this) {
                    is CommonOpponent -> purpleTextCommonOpponent(message)
                    is StrongOpponent -> redTextStrongOpponent(message)
                    else -> message
                }
                println(coloredMessage)
            }
            println(coloredMessageSeparator())
//            println(redTextStrongOpponent("------------------------------------------------"))
        }
    }


    open fun commonAttack(character: Character, attack: Int) {
        character.health -= attack
        character.health = roundDouble(character.health)
//        println(redTextStrongOpponent("${this.name} attacked and dealt $attack damage.${character.name} has more health ${character.health}"))
//        println(redTextStrongOpponent("------------------------------------------------"))
        val message = "{this.name} attacked and dealt $attack damage.${character.name} has more health ${character.health}"
        val coloredMessage = when (this) {
            is CommonOpponent -> purpleTextCommonOpponent(message)
            is StrongOpponent -> redTextStrongOpponent(message)
            else -> message
        }
        println(coloredMessage)
        println(coloredMessageSeparator())
    }
    open fun reduceHealthByHospital(character: Character) {

    }


}

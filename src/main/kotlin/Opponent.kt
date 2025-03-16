abstract class Opponent(val name: String, var health: Double) {
    var originHealthCommon: Double = health

    // Greift alle Charaktere gleichzeitig an, berücksichtigt aktiven Schild
    open fun allAtOnce(characterList: MutableList<Character>, attack: Int) {
        if (characterList.isNotEmpty()) {
            //Die for-Schleife wird verwendet, um eine Sammlung zu durchlaufen.
            for (target in characterList) {
                var finalAttack = attack
                if (target.isShieldActive) {
                    finalAttack = (attack * 0.2).toInt() // Reduziert den Schaden um 80%, lässt 20% übrig
                    println(
                        when (this) {
                            is CommonOpponent -> purpleTextCommonOpponent("${target.name}'s shield reduced the damage by 80%!")
                            is StrongOpponent -> redTextStrongOpponent("${target.name}'s shield reduced the damage by 80%!")
                            is OpponentSaboteur -> brownTextOpponentSaboteur("${target.name}'s shield reduced the damage by 80%!")
                            else -> "${target.name}'s shield reduced the damage by 80%!"
                        }
                    )
                }
                target.health -= finalAttack
                target.health = roundDouble(target.health)
                val message = "FUN ATTACK ON ALL WARRIORS. ${target.name} has been defeated. Health ${target.name} equals ${target.health}"
                val coloredMessage = when (this) {
                    is CommonOpponent -> purpleTextCommonOpponent(message)
                    is StrongOpponent -> redTextStrongOpponent(message)
                    is OpponentSaboteur -> brownTextOpponentSaboteur(message)
                    else -> message
                }
                println(coloredMessage)
            }
            println(coloredMessageSeparator())
        }
    }

    // Führt einen normalen Angriff auf einen einzelnen Charakter aus, berücksichtigt aktiven Schild
    open fun commonAttack(character: Character, attack: Int) {
        var finalAttack = attack
        if (character.isShieldActive) {
            finalAttack = (attack * 0.2).toInt() // Reduziert den Schaden um 80%, lässt 20% übrig
            println(
                when (this) {
                    is CommonOpponent -> purpleTextCommonOpponent("${character.name}'s Schild hat den Schaden um 80% reduziert!")
                    is StrongOpponent -> redTextStrongOpponent("${character.name}'s Schild hat den Schaden um 80% reduziert!")
                    is OpponentSaboteur -> brownTextOpponentSaboteur("${character.name}'s Schild hat den Schaden um 80% reduziert!")
                    else -> "${character.name}'s Schild hat den Schaden um 80% reduziert!"
                }
            )
        }
        character.health -= finalAttack
        character.health = roundDouble(character.health)
        val message = "${this.name} attacked and dealt $attack damage.${character.name} has more health ${character.health}"
        val coloredMessage = when (this) {
            is CommonOpponent -> purpleTextCommonOpponent(message)
            is StrongOpponent -> redTextStrongOpponent(message)
            is OpponentSaboteur -> brownTextOpponentSaboteur(message)
            else -> message
        }
        println(coloredMessage)
        println(coloredMessageSeparator())
    }

    open fun reduceHealthByHospital(character: Character) {
    }

    // Gibt eine farbige Trennlinie zurück, abhängig vom Charaktertyp
    private fun coloredMessageSeparator(): String {
        return when (this) {
            is CommonOpponent -> purpleTextCommonOpponent("------------------------------------------------")
            is StrongOpponent -> redTextStrongOpponent("------------------------------------------------")
            else -> "------------------------------------------------"
        }
    }
}

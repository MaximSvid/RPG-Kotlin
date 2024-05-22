import kotlin.math.roundToInt


fun roundDouble(health: Double): Double {
    var roundedHealthToInt = (health * 100).roundToInt()
    var roundedHealth: Double = roundedHealthToInt / 100.0
    return roundedHealth
}

fun chooseCharacter(character: Character, opponent: Opponent, bag: Bag) {
    println(
        """
        Choose a character...
        [1] - Swordsman
        [2] - Rider
        [3] - Archer
    """.trimIndent()
    )
    val chooseCharacterInput = readln()

    when (chooseCharacterInput) {
        "1" -> {
            val swordsman = character as Swordsman
            println(
                """
                Swordsman attacked...
                Select the type of attack...
                [1] - Normal attack
                [2] - Enhanced attack (quantity limited. Attacks available ${swordsman.numberStrongAttacks})
                You can offer treatment for your friends...
                [3] - Conventional treatment
                [4] - Enhanced treatment (quantity limited. Treatments available ${swordsman.numberStrongTreatments})
                [5] - Use a bag of medical supplies (The amount of medicine available (${bag.amountOfMedicine})
                [6] - Use the bag to increase your strength (The amount of power ${bag.amountOfPower})
            """.trimIndent()
            )
            val choiceAttack = readln()
            when (choiceAttack) {
                "1" -> swordsman.swordAttack(opponent)
                "2" -> swordsman.superStrongSwordAttack(opponent)
                "3" -> swordsman.swordHealth(character)
                "4" -> swordsman.superSwordHealth(character)
                "5" -> bag.useMedicine(character)
                "6" -> bag.usePower(character)
                else -> {
                    println("Enter a number between 1 and 4")
                    chooseCharacter(character, opponent, bag)
                }
            }
        }

        "2" -> {
            val rider = character as Rider
            println(
                """
                Rider attacked...
                Select the type of attack...
                [1] - Normal attack
                [2] - Enhanced attack (quantity limited. Attacks available ${rider.numberStrongAttacks})
                You can offer treatment for your friends...
                [3] - Conventional treatment
                [4] - Enhanced treatment (quantity limited. Treatments available ${rider.numberStrongTreatments})
                [5] - Use a bag of medical supplies (The amount of medicine available (${bag.amountOfMedicine})
                [6] - Use the bag to increase your strength (The amount of power ${bag.amountOfPower})
            """.trimIndent()
            )
            val choiceAttack = readln()
            when (choiceAttack) {
                "1" -> rider.riderAttack(opponent)
                "2" -> rider.superStrongRiderAttack(opponent)
                "3" -> rider.riderHealth(character)
                "4" -> rider.superRiderHealth(character)
                "5" -> bag.useMedicine(character)
                "6" -> bag.usePower(character)
                else -> {
                    println("Enter a number between 1 and 4")
                    chooseCharacter(character, opponent, bag)
                }
            }
        }
        "3" -> {
            val archer = character as Archer
            println(
                """
                Rider attacked...
                Select the type of attack...
                [1] - Normal attack
                [2] - Enhanced attack (quantity limited. Attacks available ${archer.numberStrongAttacks})
                You can offer treatment for your friends...
                [3] - Conventional treatment
                [4] - Enhanced treatment (quantity limited. Treatments available ${archer.numberStrongTreatments})
                [5] - Use a bag of medical supplies (The amount of medicine available (${bag.amountOfMedicine})
                [6] - Use the bag to increase your strength (The amount of power ${bag.amountOfPower})
            """.trimIndent()
            )
            val choiceAttack = readln()
            when (choiceAttack) {
                "1" -> archer.archerAttack(opponent)
                "2" -> archer.superStrongArcherAttack(opponent)
                "3" -> archer.archerHealth(character)
                "4" -> archer.superArcherHealth(character)
                "5" -> bag.useMedicine(character)
                "6" -> bag.usePower(character)
                else -> {
                    println("Enter a number between 1 and 4")
                    chooseCharacter(character, opponent, bag)
                }
            }

        }
    }
}

fun chooseActionCharacter() {

}
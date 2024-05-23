import kotlin.math.roundToInt


fun roundDouble(health: Double): Double {
    var roundedHealthToInt = (health * 100).roundToInt()
    var roundedHealth: Double = roundedHealthToInt / 100.0
    return roundedHealth
}

fun start (characterList: MutableList<Character>, opponentList: MutableList<Opponent>, bag: Bag) {
    println(
        """
        Choose a character...
        [1] - Swordsman
        [2] - Rider
        [3] - Archer
    """.trimIndent()
    )
    val chooseCharacterInput = readln()
    if (chooseCharacterInput == "1") {
        selectingAttackTypeSwordsman(characterList, opponentList, bag)
    } else if (chooseCharacterInput == "2"){
        selectingAttackTypeRider(characterList, opponentList, bag)
    } else if (chooseCharacterInput == "3") {
        selectingAttackTypeArcher(characterList, opponentList, bag)
    } else {
        println("Enter a number between 1 and 4")
        start(characterList, opponentList, bag)
    }
}


fun selectingAttackTypeSwordsman (characterList: MutableList<Character>, opponentList: MutableList<Opponent>, bag: Bag) {
    val swordsman = characterList.find { it is Swordsman } as? Swordsman
    /*
    Sucht nach dem ersten Element in characterList, das eine Instanz der Klasse Rider ist.
Überträgt das gefundene Element auf den Typ „Reiter“.
     */
    val opponent = opponentList.firstOrNull()
    /*
    Der Ausdruck val opponent = opponentList.firstOrNull() wird verwendet, um das erste Element aus der opponentList abzurufen, wenn ein solches Element existiert, oder null zu erhalten, wenn die Liste leer ist.
     */
    if (swordsman != null && opponent != null) {
        println(
            """
                Swordsman attacked...
                Select the type of attack...
                [1] - Normal attack
                [2] - Enhanced attack (quantity limited. Attacks available ${swordsman.numberStrongAttacks})
                You can offer treatment for your friends...
                [3] - Conventional treatment
                [4] - Enhanced treatment (quantity limited. Treatments available ${swordsman.numberStrongTreatments})
                The bag has already been used in this round ---${bag.isUsedBag}---
                 If ---!!!true!!!--- no more use this round.
                [5] - Bag
            """.trimIndent()
        )
        val choiceAttack = readln()
        when (choiceAttack) {
            "1" -> swordsman.swordAttack(opponent)
            "2" -> swordsman.superStrongSwordAttack(opponent)
            "3" -> swordsman.swordHealth(swordsman)
            "4" -> swordsman.superSwordHealth(swordsman)
            "5" -> {
                println("""
                     [1] - Use a bag of medical supplies (The amount of medicine available (${bag.amountOfMedicine})
                     [2] - Use the bag to increase your strength (The amount of power ${bag.amountOfPower})
                """.trimIndent())
                val choiceBag = readln()
                when (choiceBag) {
                    "1" -> bag.useMedicine(swordsman)
                    "2" -> bag.usePower(swordsman)
                    else -> {
                        println("Enter a number between 1 and 5")
                        selectingAttackTypeSwordsman(characterList, opponentList, bag)
                    }
                }
            }

            else -> {
                println("Enter a number between 1 and 5")
                selectingAttackTypeSwordsman(characterList, opponentList, bag)
            }
        }
    }


}

fun selectingAttackTypeRider(characterList: MutableList<Character>, opponentList: MutableList<Opponent>, bag: Bag) {
    val rider = characterList.find { it is Rider} as? Rider
    var opponent = opponentList.firstOrNull()
    if (rider != null && opponent != null) {
        println(
            """
                Rider attacked...
                Select the type of attack...
                [1] - Normal attack
                [2] - Enhanced attack (quantity limited. Attacks available ${rider.numberStrongAttacks})
                You can offer treatment for your friends...
                [3] - Conventional treatment
                [4] - Enhanced treatment (quantity limited. Treatments available ${rider.numberStrongTreatments})
                The bag has already been used in this round ---${bag.isUsedBag}---
                 If ---!!!true!!!--- no more use this round.
                [5] - Bag
            """.trimIndent()
        )
        val choiceAttack = readln()
        when (choiceAttack) {
            "1" -> rider.riderAttack(opponent)
            "2" -> rider.superStrongRiderAttack(opponent)
            "3" -> rider.riderHealth(rider)
            "4" -> rider.superRiderHealth(rider)
            "5" -> {
                println("""
                     [1] - Use a bag of medical supplies (The amount of medicine available (${bag.amountOfMedicine})
                     [2] - Use the bag to increase your strength (The amount of power ${bag.amountOfPower})
                """.trimIndent())
                val choiceBag = readln()
                when (choiceBag) {
                    "1" -> bag.useMedicine(rider)
                    "2" -> bag.usePower(rider)
                    else -> {
                        println("Enter a number between 1 and 5")
                        selectingAttackTypeSwordsman(characterList, opponentList, bag)
                    }
                }
            }
            else -> {
                println("Enter a number between 1 and 5")
                selectingAttackTypeRider(characterList, opponentList, bag)
            }
        }
    }

}

fun selectingAttackTypeArcher(characterList: MutableList<Character>, opponentList: MutableList<Opponent>, bag: Bag) {
    val archer = characterList.find { it is Archer } as? Archer
    var opponent = opponentList.firstOrNull()
    if (archer != null && opponent != null) {
        println(
            """
                Archer attacked...
                Select the type of attack...
                [1] - Normal attack
                [2] - Enhanced attack (quantity limited. Attacks available ${archer.numberStrongAttacks})
                You can offer treatment for your friends...
                [3] - Conventional treatment
                [4] - Enhanced treatment (quantity limited. Treatments available ${archer.numberStrongTreatments})
                The bag has already been used in this round ---${bag.isUsedBag}---
                If ---!!!true!!!--- no more use this round.
                [5] - Bag
            """.trimIndent()
        )
        val choiceAttack = readln()
        when (choiceAttack) {
            "1" -> archer.archerAttack(opponent)
            "2" -> archer.superStrongArcherAttack(opponent)
            "3" -> archer.archerHealth(archer)
            "4" -> archer.superArcherHealth(archer)
            "5" -> {
                println("""
                     [1] - Use a bag of medical supplies (The amount of medicine available (${bag.amountOfMedicine})
                     [2] - Use the bag to increase your strength (The amount of power ${bag.amountOfPower})
                """.trimIndent())
                val choiceBag = readln()
                when (choiceBag) {
                    "1" -> bag.useMedicine(archer)
                    "2" -> bag.usePower(archer)
                    else -> {
                        println("Enter a number between 1 and 5")
                        selectingAttackTypeSwordsman(characterList, opponentList, bag)
                    }
                }
            }
            else -> {
                println("Enter a number between 1 and 4")
                selectingAttackTypeArcher(characterList, opponentList, bag)
            }
        }
    }

}




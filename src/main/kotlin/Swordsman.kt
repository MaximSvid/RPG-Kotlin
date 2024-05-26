class Swordsman(name: String, health: Double) : Character(name, health) {

    fun swordAttack(opponent: Opponent) {
        val attack = 20
        val modifiedAttck = (attack * attackFactor).toInt()
        println("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with his sword")
//        println("${this.name} attacked with his sword")
        super.attackCharacter(opponent, modifiedAttck)
    }

    fun superStrongSwordAttack(opponent: Opponent) {
            val attack = 50
            println("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with his sword")
//            println("${this.name} attacked with his sword")
            super.attackCharacter(opponent, attack)
    }

    fun swordHealth(character: Character) {
        var points = 15
        println("The state of health ${character.name} is equal to ${character.health}. A USUALLY treatment was utilized.")
//        println("A USUALLY treatment was utilized.")
        super.healthCharacter(character, points)
    }

    fun superSwordHealth(character: Character) {
            var points = 30
            println("The state of health ${character.name} is equal to ${character.health}. A SUPER treatment was utilized.")
//            println("A SUPER treatment was utilized.")
            super.healthCharacter(character, points)
    }

    override fun selectingAttackType(opponent: Opponent, bag: Bag) {
        println(
            """ Swordsman attacked...
                Select the type of attack...
                [1] - Normal attack || [2] - Enhanced attack || [3] - Conventional treatment || [4] - Enhanced treatment || [5] - Bag             
                The bag has already been used in this round ---${bag.isUsedBag}---
            """.trimIndent()
        )
        val choiceAttack = readln()
        when (choiceAttack) {
            "1" -> swordAttack(opponent)
            "2" -> superStrongSwordAttack(opponent)
            "3" -> swordHealth(this)
            "4" -> superSwordHealth(this)
            "5" -> {
                println("""
                     If the status is true --== ${bag.isUsedBag} ==--, press [0]
                     [1] - Use a bag of medical supplies (The amount of medicine available (${bag.amountOfMedicine})
                     [2] - Use the bag to increase your strength (The amount of power ${bag.amountOfPower})
                """.trimIndent())
                val choiceBag = readln()
                when (choiceBag) {
                    "1" -> bag.useMedicine(this)
                    "2" -> bag.usePower(this)
                    else -> {
                        println("Enter a number between 1 and 5")
                        selectingAttackType(opponent, bag)
                    }
                }
            }

            else -> {
                println("Enter a number between 1 and 5")
                selectingAttackType(opponent, bag)
            }
        }
    }


//    fun selectingAttackTypeSwordsman (characterList: MutableList<Character>, opponentList: MutableList<Opponent>, bag: Bag) {
//        val swordsman = characterList.find { it is Swordsman } as? Swordsman
//        /*
//        Sucht nach dem ersten Element in characterList, das eine Instanz der Klasse Rider ist.
//    Überträgt das gefundene Element auf den Typ „Reiter“.
//         */
//        val opponent = opponentList.firstOrNull()
//        /*
//        Der Ausdruck val opponent = opponentList.firstOrNull() wird verwendet, um das erste Element aus der opponentList abzurufen, wenn ein solches Element existiert, oder null zu erhalten, wenn die Liste leer ist.
//         */
//        if (swordsman != null && opponent != null) {
//            println(
//                """
//                Swordsman attacked...
//                Select the type of attack...
//                [1] - Normal attack
//                [2] - Enhanced attack
//                You can offer treatment for your friends...
//                [3] - Conventional treatment
//                [4] - Enhanced treatment
//                The bag has already been used in this round ---${bag.isUsedBag}---
//                 If ---!!!true!!!--- no more use this round.
//                [5] - Bag
//            """.trimIndent()
//            )
//            val choiceAttack = readln()
//            when (choiceAttack) {
//                "1" -> swordsman.swordAttack(opponent)
//                "2" -> swordsman.superStrongSwordAttack(opponent)
//                "3" -> swordsman.swordHealth(swordsman)
//                "4" -> swordsman.superSwordHealth(swordsman)
//                "5" -> {
//                    println("""
//                     If the status is true ${bag.isUsedBag}, press [0]
//                     [1] - Use a bag of medical supplies (The amount of medicine available (${bag.amountOfMedicine})
//                     [2] - Use the bag to increase your strength (The amount of power ${bag.amountOfPower})
//                """.trimIndent())
//                    val choiceBag = readln()
//                    when (choiceBag) {
//                        "1" -> bag.useMedicine(swordsman)
//                        "2" -> bag.usePower(swordsman)
//                        else -> {
//                            println("Enter a number between 1 and 5")
//                            selectingAttackTypeSwordsman(characterList, opponentList, bag)
//                        }
//                    }
//                }
//
//                else -> {
//                    println("Enter a number between 1 and 5")
//                    selectingAttackTypeSwordsman(characterList, opponentList, bag)
//                }
//            }
//        }
//
//
//    }



}
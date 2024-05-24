class Rider(name: String, health: Double) : Character(name, health) {

    fun riderAttack(opponent: Opponent) {
        val attack = 30
        val modifiedAttck = (attack * attackFactor).toInt()
        println("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with a rider on horseback")
//        println("${this.name} attacked with a rider on horseback")
        super.attackCharacter(opponent, modifiedAttck)
    }

    fun superStrongRiderAttack(opponent: Opponent) {
        val attack = 60
        println("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with a rider on horseback")
//        println("${this.name} attacked with a rider on horseback")
        super.attackCharacter(opponent, attack)
    }

    fun riderHealth(character: Character) {
        var points = 25

        println("The state of health ${character.name} is equal to ${character.health}. A USUALLY treatment was utilized.")
//        println("A USUALLY treatment was utilized.")
        super.healthCharacter(character, points)
    }

    fun superRiderHealth(character: Character) {
        var points = 50
        println("The state of health ${character.name} is equal to ${character.health}. A SUPER treatment was utilized.")
//        println("A SUPER treatment was utilized.")
        super.healthCharacter(character, points)
    }

    override fun selectingAttackType(opponent: Opponent, bag: Bag) {
        println(
            """ Rider attacked...
                Select the type of attack...
                [1] - Normal attack || [2] - Enhanced attack || [3] - Conventional treatment || [4] - Enhanced treatment || [5] - Bag             
                The bag has already been used in this round ---${bag.isUsedBag}---
            """.trimIndent()
        )
        val choiceAttack = readln()
        when (choiceAttack) {
            "1" -> riderAttack(opponent)
            "2" -> superStrongRiderAttack(opponent)
            "3" -> riderHealth(this)
            "4" -> superRiderHealth(this)
            "5" -> {
                println("""
                     If the status is true ${bag.isUsedBag}, press [0]
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


//    fun selectingAttackTypeRider(
//        characterList: MutableList<Character>,
//        opponentList: MutableList<Opponent>,
//        bag: Bag
//    ) {
//        val rider = characterList.find { it is Rider } as? Rider
//        var opponent = opponentList.firstOrNull()
//        if (rider != null && opponent != null) {
//            println(
//                """
//                Rider attacked...
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
//                "1" -> rider.riderAttack(opponent)
//                "2" -> rider.superStrongRiderAttack(opponent)
//                "3" -> rider.riderHealth(rider)
//                "4" -> rider.superRiderHealth(rider)
//                "5" -> {
//                    println(
//                        """
//                      If the status is true == ${bag.isUsedBag}, press [0]
//                     [1] - Use a bag of medical supplies (The amount of medicine available (${bag.amountOfMedicine})
//                     [2] - Use the bag to increase your strength (The amount of power ${bag.amountOfPower})
//                """.trimIndent()
//                    )
//                    val choiceBag = readln()
//                    when (choiceBag) {
//                        "1" -> bag.useMedicine(rider)
//                        "2" -> bag.usePower(rider)
//                        else -> {
//                            println("Enter a number between 1 and 5")
//                            selectingAttackTypeRider(characterList, opponentList, bag)
//                        }
//                    }
//                }
//
//                else -> {
//                    println("Enter a number between 1 and 5")
//                    selectingAttackTypeRider(characterList, opponentList, bag)
//                }
//            }
//        }
//
//    }
}
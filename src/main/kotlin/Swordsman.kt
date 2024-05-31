class Swordsman(name: String, health: Double) : Character(name, health) {

    private fun swordAttack(opponent: Opponent) {
        val attack = 20
        val modifiedAttack = (attack * attackFactor).toInt()
        println(blueTextSwordsman("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with his sword"))
        super.attackCharacter(opponent, modifiedAttack)
    }

    private fun superStrongSwordAttack(opponent: Opponent) {
        val attack = 50
        println(blueTextSwordsman("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with his sword"))
        super.attackCharacter(opponent, attack)
    }

    private fun swordHealth(character: Character) {
        val points = 15
        println(blueTextSwordsman("The state of health ${character.name} is equal to ${character.health}. A USUALLY treatment was utilized."))
        super.healthCharacter(character, points)
    }

    private fun superSwordHealth(character: Character) {
        val points = 30
        println(blueTextSwordsman("The state of health ${character.name} is equal to ${character.health}. A SUPER treatment was utilized."))
        super.healthCharacter(character, points)
    }

    override fun selectingAttackType(opponent: Opponent, bag: Bag) {
        println(
            blueTextSwordsman(
                """ Swordsman attacked...
                Select the type of attack...
                [1] - Normal attack || [2] - Enhanced attack || [3] - Conventional treatment || [4] - Enhanced treatment || [5] - Bag             
                The bag has already been used in this round ---${bag.isUsedBag}---
            """.trimIndent()
            )
        )
        val choiceAttack = readln()
        when (choiceAttack) {
            "1" -> swordAttack(opponent)
            "2" -> superStrongSwordAttack(opponent)
            "3" -> swordHealth(this)
            "4" -> superSwordHealth(this)
            "5" -> {
                if (bag.isUsedBag) {
                    println(pintTextBag("The bag was used in this round"))
                    selectingAttackType(opponent, bag)
                } else {
                    println(
                        pintTextBag(
                            """
                     [1] - Use a bag of medical supplies (The amount of medicine available (${bag.amountOfMedicine})
                     [2] - Use the bag to increase your strength (The amount of power ${bag.amountOfPower})
                """.trimIndent()
                        )
                    )
                    val choiceBag = readln()
                    when (choiceBag) {
                        "1" -> bag.useMedicine(this)
                        "2" -> bag.usePower(this)
                        else -> {
                            println(
                                pintTextBag("Enter a number between 1 and 5")
                            )
                            selectingAttackType(opponent, bag)
                        }
                    }
                }
            }
            else -> {
                println(pintTextBag("Enter a number between 1 and 5"))
                selectingAttackType(opponent, bag)
            }
        }
    }
}
class Rider(name: String, health: Double) : Character(name, health) {

    private fun riderAttack(opponent: Opponent) {
        val attack = 30
        val modifiedAttck = (attack * attackFactor).toInt()
        println(yellowTextRider("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with a rider on horseback"))
        super.attackCharacter(opponent, modifiedAttck)
    }

    private fun superStrongRiderAttack(opponent: Opponent) {
        val attack = 60
        println(yellowTextRider("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with a rider on horseback"))
        super.attackCharacter(opponent, attack)
    }

    private fun riderHealth(character: Character) {
        val points = 25
        println(yellowTextRider("The state of health ${character.name} is equal to ${character.health}. A USUALLY treatment was utilized."))
        super.healthCharacter(character, points)
    }

    private fun superRiderHealth(character: Character) {
        val points = 50
        println(yellowTextRider("The state of health ${character.name} is equal to ${character.health}. A SUPER treatment was utilized."))
        super.healthCharacter(character, points)
    }

    override fun selectingAttackType(opponent: Opponent, bag: Bag) {
        println(
            yellowTextRider(
                """ Rider attacked...
                Select the type of attack...
                [1] - Normal attack || [2] - Enhanced attack || [3] - Conventional treatment || [4] - Enhanced treatment || [5] - Bag             
                The bag has already been used in this round ---${bag.isUsedBag}---
            """.trimIndent()
            )
        )
        val choiceAttack = readln()
        when (choiceAttack) {
            "1" -> riderAttack(opponent)
            "2" -> superStrongRiderAttack(opponent)
            "3" -> riderHealth(this)
            "4" -> superRiderHealth(this)
            "5" -> {
                println(
                    pintTextBag(
                        """
                     If the status is true --== ${bag.isUsedBag} ==--, press [0]
                     [1] - Use a bag of medical supplies (The amount of medicine available (${bag.amountOfMedicine})
                     [2] - Use the bag to increase your strength (The amount of power ${bag.amountOfPower})
                """.trimIndent()
                    )
                )
                val choiceBag = readln()
                when (choiceBag) {
                    "1" -> {
                        if (bag.isUsedBag) {
                            println(pintTextBag("The bag has already been used in this round. Just pick an attack!!!"))
                            selectingAttackType(opponent, bag)
                        } else {
                            bag.useMedicine(this)
                        }
                    }

                    "2" -> {
                        if (bag.isUsedBag) {
                            println(pintTextBag("The bag has already been used in this round. Just pick an attack!!!"))
                            selectingAttackType(opponent, bag)
                        } else {
                            bag.usePower(this)
                        }
                    }

                    else -> {
                        println(
                            pintTextBag("Enter a number between 1 and 5")
                        )
                        selectingAttackType(opponent, bag)
                    }
                }
            }

            else -> {
                println(yellowTextRider("Enter a number between 1 and 5"))
                selectingAttackType(opponent, bag)
            }
        }
    }
}
class Archer(name: String, health: Double) : Character(name, health) {



    private fun archerAttack(opponent: Opponent) {
        val attack = 10
        val modifiedAttck = (attack * attackFactor).toInt()
        println(greenTextRider("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with his bow"))
        super.attackCharacter(opponent, modifiedAttck)
    }

    private fun superStrongArcherAttack(opponent: Opponent) {
            val attack = 25
            println(greenTextRider("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with his bow"))
            super.attackCharacter(opponent, attack)
    }

    private fun archerHealth(character: Character) {
        val points = 20
        println(greenTextRider("The state of health ${character.name} is equal to ${character.health}. A USUALLY treatment was utilized."))
        super.healthCharacter(character, points)
    }

    private fun superArcherHealth(character: Character) {
            val points = 35
            println(greenTextRider("The state of health ${character.name} is equal to ${character.health}. A SUPER treatment was utilized."))
            super.healthCharacter(character, points)
    }

    override fun selectingAttackType(opponent: Opponent, bag: Bag) {
        println(greenTextRider(
            """ Archer attacked...
                Select the type of attack...
                [1] - Normal attack || [2] - Enhanced attack || [3] - Conventional treatment || [4] - Enhanced treatment || [5] - Bag             
                The bag has already been used in this round ---${bag.isUsedBag}---
            """.trimIndent()
        )
        )
        val choiceAttack = readln()
        when (choiceAttack) {
            "1" -> archerAttack(opponent)
            "2" -> superStrongArcherAttack(opponent)
            "3" -> archerHealth(this)
            "4" -> superArcherHealth(this)
            "5" -> {
                println(pintTextBag("""
                     If the status is true  --== ${bag.isUsedBag} ==--, press [0]
                     [1] - Use a bag of medical supplies (The amount of medicine available (${bag.amountOfMedicine})
                     [2] - Use the bag to increase your strength (The amount of power ${bag.amountOfPower})
                """.trimIndent()))
                val choiceBag = readln()
                when (choiceBag) {
                    "1" -> {
                        if (bag.isUsedBag){
                            println(pintTextBag("The bag has already been used in this round. Just pick an attack!!!"))
                            selectingAttackType(opponent, bag)
                        }else {
                            bag.useMedicine(this)
                        }
                    }
                    "2" -> {
                        if (bag.isUsedBag){
                            println(pintTextBag("The bag has already been used in this round. Just pick an attack!!!"))
                            selectingAttackType(opponent, bag)
                        } else {
                            bag.usePower(this)
                        }
                    }
                    else -> {
                        println (
                            pintTextBag("Enter a number between 1 and 5"))
                        selectingAttackType(opponent, bag)
                    }
                }
            }

            else -> {
                println(greenTextRider("Enter a number between 1 and 5"))
                selectingAttackType(opponent, bag)
            }
        }
    }
}
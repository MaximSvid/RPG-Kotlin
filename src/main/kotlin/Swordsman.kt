class Swordsman(name: String, health: Double) : Character(name, health) {

    fun swordAttack(opponent: Opponent) {
        val attack = 20
        val modifiedAttck = (attack * attackFactor).toInt()
        println("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with his sword")
        super.attackCharacter(opponent, modifiedAttck)
    }

    fun superStrongSwordAttack(opponent: Opponent) {
            val attack = 50
            println("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with his sword")
            super.attackCharacter(opponent, attack)
    }

    fun swordHealth(character: Character) {
        var points = 15
        println("The state of health ${character.name} is equal to ${character.health}. A USUALLY treatment was utilized.")
        super.healthCharacter(character, points)
    }

    fun superSwordHealth(character: Character) {
            var points = 30
            println("The state of health ${character.name} is equal to ${character.health}. A SUPER treatment was utilized.")
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
}
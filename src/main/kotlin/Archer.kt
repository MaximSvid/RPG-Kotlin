class Archer(name: String, health: Double) : Character(name, health) {
    var numberStrongAttacks = 3
    var numberStrongTreatments = 4


    fun archerAttack(opponent: Opponent) {
        val attack = 10
        val modifiedAttck = (attack * attackFactor).toInt()
        println("Current health status is ${opponent.health}")
        println("${this.name} attacked with his bow")
        super.attackCharacter(opponent, modifiedAttck)
    }

    fun superStrongArcherAttack(opponent: Opponent) {
        if (numberStrongAttacks > 0) {
            val attack = 25
            println("Current health status is ${opponent.health}")
            println("${this.name} attacked with his bow")

            super.attackCharacter(opponent, attack)
        } else {
            println("Boosted attacks are no longer available")
        }


    }

    fun archerHealth(character: Character) {
        var points = 20
        println("The state of health ${character.name} is equal to ${character.health}")
        println("A USUALLY treatment was utilized.")
        super.healthCharacter(character, points)
    }

    fun superArcherHealth(character: Character) {
        if (numberStrongTreatments > 0) {
            var points = 35
            println("The state of health ${character.name} is equal to ${character.health}")
            println("A SUPER treatment was utilized.")
            numberStrongTreatments--
            println("Available number of strong treatment for ${this.name} is $numberStrongAttacks")
            super.healthCharacter(character, points)
        } else {
            println("Strong treatment is $numberStrongTreatments and is no linger available")
        }

    }


}
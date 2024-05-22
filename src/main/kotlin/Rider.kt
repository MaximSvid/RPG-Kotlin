class Rider(name: String, health: Double) : Character(name, health) {
    var numberStrongAttacks = 3
    var numberStrongTreatments = 4

    fun riderAttack(opponent: Opponent) {
        val attack = 30
        println("Current health status is ${opponent.health}")
        println("${this.name} attacked with a rider on horseback")
        super.attackCharacter(opponent, attack)
    }

    fun superStrongRiderAttack(opponent: Opponent) {
        if (numberStrongAttacks > 0) {
            val attack = 60
            println("Current health status is ${opponent.health}")
            println("${this.name} attacked with a rider on horseback")
            numberStrongAttacks--
            println("Available number of strong attacks for ${this.name} is $numberStrongAttacks")
            super.attackCharacter(opponent, attack)
        } else {
            println("Boosted attacks are no longer available")
        }

    }

    fun riderHealth(character: Character) {
        var points = 25
        println("The state of health ${character.name} is equal to ${character.health}")
        println("A USUALLY treatment was utilized.")
        super.healthCharacter(character, points)
    }

    fun superRiderHealth(character: Character) {
        if (numberStrongTreatments > 0) {
            var points = 50
            println("The state of health ${character.name} is equal to ${character.health}")
            numberStrongAttacks--
            println("Available number of strong attacks for ${this.name} is $numberStrongAttacks")
            println("A SUPER treatment was utilized.")
            super.healthCharacter(character, points)
        } else {
            println("Boosted attacks are no longer available")
        }

    }
}
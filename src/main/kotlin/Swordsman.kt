class Swordsman(name: String, health: Double) : Character(name, health) {
    var numberStrongAttacks = 3
    var numberStrongTreatments = 4

    fun swordAttack(opponent: Opponent) {
        val attack = 20
        val modifiedAttck = (attack * attackFactor).toInt()
        println("Current health status is ${opponent.health}")
        println("${this.name} attacked with his sword")
        super.attackCharacter(opponent, modifiedAttck)
    }

    fun superStrongSwordAttack(opponent: Opponent) {
        if (numberStrongAttacks > 0) {
            val attack = 50
            println("Current health status is ${opponent.health}")
            println("${this.name} attacked with his sword")
            numberStrongAttacks--
            println("Available number of strong attacks for ${this.name} is $numberStrongAttacks")
            super.attackCharacter(opponent, attack)
        }  else {
            println("Boosted attacks are no longer available")
        }

    }

    fun swordHealth(character: Character) {
        var points = 15
        println("The state of health ${character.name} is equal to ${character.health}")
        println("A USUALLY treatment was utilized.")
        super.healthCharacter(character, points)
    }

    fun superSwordHealth(character: Character) {
        if (numberStrongTreatments > 0) {
            var points = 30
            println("The state of health ${character.name} is equal to ${character.health}")
            println("A SUPER treatment was utilized.")
            numberStrongTreatments--
            println("Available number of strong treatment for ${this.name} is $numberStrongAttacks")
            super.healthCharacter(character, points)
        } else {
            println("Strong treatment is $numberStrongTreatments and is no linger available")
        }

    }

    fun selectingAttackTypeSwordsman () {
        if ()
    }


}
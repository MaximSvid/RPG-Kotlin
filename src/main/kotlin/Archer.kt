class Archer(name: String, health: Double) : Character(name, health) {



    fun archerAttack(opponent: Opponent) {
        val attack = 10
        val modifiedAttck = (attack * attackFactor).toInt()
        println("Current health status ${opponent.name} is ${opponent.health}")
        println("${this.name} attacked with his bow")
        super.attackCharacter(opponent, modifiedAttck)
    }

    fun superStrongArcherAttack(opponent: Opponent) {
            val attack = 25
            println("Current health status ${opponent.name} is ${opponent.health}")
            println("${this.name} attacked with his bow")
            super.attackCharacter(opponent, attack)
    }

    fun archerHealth(character: Character) {
        var points = 20
        println("The state of health ${character.name} is equal to ${character.health}")
        println("A USUALLY treatment was utilized.")
        super.healthCharacter(character, points)
    }

    fun superArcherHealth(character: Character) {
            var points = 35
            println("The state of health ${character.name} is equal to ${character.health}")
            println("A SUPER treatment was utilized.")
            super.healthCharacter(character, points)
    }


}
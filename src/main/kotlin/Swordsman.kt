class Swordsman(name: String, health: Double) : Character(name, health) {

    fun swordAttack(opponent: Opponent) {
        val attack = 20
        val modifiedAttck = (attack * attackFactor).toInt()
        println("Current health status ${opponent.name} is ${opponent.health}")
        println("${this.name} attacked with his sword")
        super.attackCharacter(opponent, modifiedAttck)
    }

    fun superStrongSwordAttack(opponent: Opponent) {
            val attack = 50
            println("Current health status ${opponent.name} is ${opponent.health}")
            println("${this.name} attacked with his sword")
            super.attackCharacter(opponent, attack)
    }

    fun swordHealth(character: Character) {
        var points = 15
        println("The state of health ${character.name} is equal to ${character.health}")
        println("A USUALLY treatment was utilized.")
        super.healthCharacter(character, points)
    }

    fun superSwordHealth(character: Character) {
            var points = 30
            println("The state of health ${character.name} is equal to ${character.health}")
            println("A SUPER treatment was utilized.")
            super.healthCharacter(character, points)
    }




}
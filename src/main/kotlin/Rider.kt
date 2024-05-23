class Rider(name: String, health: Double) : Character(name, health) {

    fun riderAttack(opponent: Opponent) {
        val attack = 30
        val modifiedAttck = (attack * attackFactor).toInt()
        println("Current health status ${opponent.name} is ${opponent.health}")
        println("${this.name} attacked with a rider on horseback")
        super.attackCharacter(opponent, modifiedAttck)
    }

    fun superStrongRiderAttack(opponent: Opponent) {
            val attack = 60
            println("Current health status ${opponent.name} is ${opponent.health}")
            println("${this.name} attacked with a rider on horseback")
            super.attackCharacter(opponent, attack)
    }

    fun riderHealth(character: Character) {
        var points = 25

        println("The state of health ${character.name} is equal to ${character.health}")
        println("A USUALLY treatment was utilized.")
        super.healthCharacter(character, points)
    }

    fun superRiderHealth(character: Character) {
            var points = 50
            println("The state of health ${character.name} is equal to ${character.health}")
            println("A SUPER treatment was utilized.")
            super.healthCharacter(character, points)
    }
}
class Archer(name: String, health: Double) : Character(name, health) {

    fun archerAttack(opponent: Opponent) {
        val attack = 10
        println("Current health status is ${opponent.health}")
        println("${this.name} attacked with his bow")
        super.attackCharacter(opponent, attack)
    }

    fun superStrongArcherAttack(opponent: Opponent) {
        val attack = 25
        println("Current health status is ${opponent.health}")
        println("${this.name} attacked with his bow")
        super.attackCharacter(opponent, attack)
    }

    fun archerHealth(character: Character) {
        var points = 20
        println("A USUALLY treatment was utilized.")
        super.healthCharacter(character, points)
    }

    fun superArcherHealth(character: Character) {
        var points = 35
        println("A SUPER treatment was utilized.")
        super.healthCharacter(character, points)
    }
}
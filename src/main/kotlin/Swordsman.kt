class Swordsman(name: String, health: Double) : Character(name, health) {

    fun swordAttack(opponent: Opponent) {
        val attack = 20
        println("Current health status is ${opponent.health}")
        println("${this.name} attacked with his sword")
        super.attackCharacter(opponent, attack)
    }

    fun superStrongSwordAttack(opponent: Opponent) {
        val attack = 50
        println("Current health status is ${opponent.health}")
        println("${this.name} attacked with his sword")
        super.attackCharacter(opponent, attack)
    }

    fun swordHealth(character: Character) {
        var points = 15
        println("A USUALLY treatment was utilized.")
        super.healthCharacter(character, points)
    }

    fun superSwordHealth(character: Character) {
        var points = 30
        println("A SUPER treatment was utilized.")
        super.healthCharacter(character, points)
    }


}
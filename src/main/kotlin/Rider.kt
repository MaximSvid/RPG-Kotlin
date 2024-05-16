class Rider(name: String, health: Double) : Character(name, health) {

    fun riderAttack(opponent: Opponent) {
        val attack = 30
        println("Current health status is ${opponent.health}")
        println("${this.name} attacked with a rider on horseback")
        super.attackCharacter(opponent, attack)
    }

    fun superStrongRiderAttack(opponent: Opponent) {
        val attack = 60
        println("Current health status is ${opponent.health}")
        println("${this.name} attacked with a rider on horseback")
        super.attackCharacter(opponent, attack)
    }

    fun riderHealth(character: Character) {
        var points = 25
        println("A USUALLY treatment was utilized.")
        super.healthCharacter(character, points)
    }

    fun superRiderHealth(character: Character) {
        var points = 50
        println("A SUPER treatment was utilized.")
        super.healthCharacter(character, points)
    }
}
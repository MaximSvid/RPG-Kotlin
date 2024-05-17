open class Character(var name: String, var health: Double, var level: Int = 1) {

    val isDeadCharacter: Boolean = false
    var ap: Double // Attack Points
    var originHP: Double
    var attackFactor: Double = 1.0

    init {
        this.ap = level * 2.0
        this.originHP = health
    }

    open fun attackCharacter(opponent: Opponent, attack: Int) {

        opponent.health -= attack
        opponent.health = roundDouble(opponent.health)
        println("${this.name} attacked and dealt $attack damage")
        println("${this.name} has more health ${opponent.health}")
        println("------------------------------------------------")

        if (opponent.health <= 0) {
            println("${opponent.name} dropped out of the game")
            opponent.isDeadOpponent = true
        }

    }

    open fun healthCharacter(character: Character, points: Int) {
        character.health += points
        character.health = roundDouble(character.health)
        println("${this.name} has been reinstated to $points points")
        println("${this.name} has more health ${character.health}")
        println("------------------------------------------------")

        if (character.health <= 0) {
            println("Health cannot be restored because ${character.name} one died")
        }
    }


}
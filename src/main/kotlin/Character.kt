open class Character(var name: String, var health: Double) {


    open fun attackCharacter(opponent: Opponent, attack: Int) {

        opponent.health -= attack
        println("${this.name} attacked and dealt $attack damage")
        println("${this.name} has more health ${opponent.health}")
        println("------------------------------------------------")

        if (opponent.health <= 0) {
            println("${opponent.name} dropped out of the game")
            opponent.isDead = true
        }

    }

    open fun healthCharacter(character: Character, points: Int) {
        character.health += points
        println("${this.name} has been reinstated to $points points")
        println("${this.name} has more health ${character.health}")
        println("------------------------------------------------")

        if (character.health <= 0) {
            println("Health cannot be restored because ${character.name} one died")
        }
    }


}
class CommonOpponent(name: String, health: Double): Opponent(name, health) {

    fun opponentAttackOnAllWarriors (warriorList: MutableList<Character>) {
        val attack = 20
        println("The enemy attacked...")
        super.attackOpponent(warriorList, attack)
    }

    fun commonOpponentPlusHealth (opponent: Opponent) {
        val points = 30
        println("The state of health ${opponent.name} is equal to ${opponent.health}")
        super.healthOpponent(opponent, points)
    }
    fun commonOpponentAttack (character: Character) {
        var attack = 35
        println("Current health status ${character.name} is ${character.health}")
        println("${this.name} attacked with a normal attack")
        super.attackcOpponent(character, attack)
    }

    fun commonStrongOpponentAttack (character: Character) {
        var attack = 50
        println("Current health status is ${character.health}")
        println("${this.name} attacking with an intensified attack")
        super.attackcOpponent(character, attack)
    }

}
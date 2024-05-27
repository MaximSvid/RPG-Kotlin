open class Character(var name: String, var health: Double, level: Int = 1) {

    var ap: Double // Attack Points
    var originHP: Double
    var attackFactor: Double = 1.0
    var isHospital: Boolean = false


    init {
        this.ap = level * 2.0
        this.originHP = health
    }



    open fun attackCharacter(opponent: Opponent, attack: Int) {
        opponent.health -= attack
        opponent.health = roundDouble(opponent.health)
        println("${this.name} attacked and dealt $attack damage. ${opponent.name} has more health ${opponent.health}")
        println("------------------------------------------------")
    }

    open fun healthCharacter(character: Character, points: Int) {
        character.health += points
        character.health = roundDouble(character.health)
        println("${this.name} has been reinstated to $points points. ${this.name} has more health ${character.health}")
        println("------------------------------------------------")
    }

    open fun selectingAttackType (opponent: Opponent, bag: Bag) {

    }

}
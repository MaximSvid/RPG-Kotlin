open class Character(var name: String, var health: Double, var level: Int = 1) {

    var isDeadCharacter: Boolean = false
    var ap: Double // Attack Points
    var originHP: Double
    var attackFactor: Double = 1.0
    var isHospital: Boolean = false
    var isHospitalRound: Int = 0
//    var shieldActove: Boolean = false


    init {
        this.ap = level * 2.0
        this.originHP = health
    }

//    open fun increasePowerByTenPercent () {
//        ap *= 1.1
//    }



    open fun attackCharacter(opponent: Opponent, attack: Int) {

        opponent.health -= attack
        opponent.health = roundDouble(opponent.health)
        println("${this.name} attacked and dealt $attack damage")
        println("${opponent.name} has more health ${opponent.health}")
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

//    open fun actovateShield(character: Character) {
//        if (!shieldActove) {
//            shieldActove = true
//            println("${character.name} has activated the shield")
//        } else {
//            println("The shield has already been activated")
//        }
//    }


}
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
        println("${this.name} attacked and dealt $attack damage. ${opponent.name} has more health ${opponent.health}")
//        println("${opponent.name} has more health ${opponent.health}")
        println("------------------------------------------------")

//        if (opponent.health <= 0) {
//            println("${opponent.name} dropped out of the game")
//            opponent.isDeadOpponent = true
//        }

    }

    open fun healthCharacter(character: Character, points: Int) {
        character.health += points
        character.health = roundDouble(character.health)
        println("${this.name} has been reinstated to $points points. ${this.name} has more health ${character.health}")
//        println("${this.name} has more health ${character.health}")
        println("------------------------------------------------")

//        if (character.health <= 0) {
//            println("Health cannot be restored because ${character.name} one died")
//        }
    }

    // Typumwandlung verwenden
//    open fun start(characterList: MutableList<Character>, opponentList: MutableList<Opponent>, bag: Bag) {
//        println(
//            """
//        Choose a character...
//        [1] - Swordsman
//        [2] - Rider
//        [3] - Archer
//    """.trimIndent()
//        )
//        val chooseCharacterInput = readln()
//        val character = when (chooseCharacterInput) {
//            "1" -> characterList.find { it is Swordsman } as? Swordsman
//            "2" -> characterList.find { it is Rider } as? Rider
//            "3" -> characterList.find { it is Archer } as? Archer
//            else -> null
//        }
//
//        if (character != null) {
//            when (character) {
//                is Swordsman -> character.selectingAttackTypeSwordsman(characterList, opponentList, bag)
//                is Rider -> character.selectingAttackTypeRider(characterList, opponentList, bag)
//                is Archer -> character.selectingAttackTypeArcher(characterList, opponentList, bag)
//            }
//        } else {
//            println("Enter a number between 1 and 3")
//            start(characterList, opponentList, bag)
//        }
//    }

    open fun selectingAttackType (opponent: Opponent, bag: Bag) {

    }

}
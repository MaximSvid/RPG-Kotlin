open class Character(var name: String, var health: Double) {

    var originHP: Double =
        health //Der Gesundheitszustand beträgt 100 %. Vorausgesetzt, dieser Wert ist der Höchstwert bei der Initialisierung
    var attackFactor: Double = 1.0 //eine der Funktionen erhöht diesen Wert um 10%
    var isHospital: Boolean =
        false //Eine der Funktionen (reduceHealthByHospital) setzt voraus, dass eine Spielfigur jeweils nur einmal im Krankenhaus sein kann.

    private fun coloredMessageSeparator(): String {
        return when (this) {
            is Swordsman -> blueTextSwordsman("------------------------------------------------")
            is Archer -> greenTextArcher("------------------------------------------------")
            is Rider -> yellowTextRider("------------------------------------------------")
            else -> "------------------------------------------------"
        }
    }

    open fun attackCharacter(opponent: Opponent, attack: Int) {
        opponent.health -= attack
        opponent.health = roundDouble(opponent.health)
//        println(blueTextSwordsman("${this.name} attacked and dealt $attack damage. ${opponent.name} has more health ${opponent.health}"))
        val message =
            "${this.name} attacked and dealt $attack damage. ${opponent.name} has more health ${opponent.health}"
        val coloredMessage = when (this) {
            is Swordsman -> blueTextSwordsman(message)
            is Archer -> greenTextArcher(message)
            is Rider -> yellowTextRider(message)
            else -> message
        }
        println(coloredMessage)
        println(coloredMessageSeparator())
    }

    open fun healthCharacter(character: Character, points: Int) {
        character.health += points
        character.health = roundDouble(character.health)
//        println(blueTextSwordsman("${this.name} has been reinstated to $points points. ${this.name} has more health ${character.health}"))
//        println(blueTextSwordsman("------------------------------------------------"))
        val message =
            "${this.name} has been reinstated to $points points. ${this.name} has more health ${character.health}"
        val coloredMessage = when (this) {
            is Swordsman -> blueTextSwordsman(message)
            is Archer -> greenTextArcher(message)
            is Rider -> yellowTextRider(message)
            else -> message
        }
        println(coloredMessage)
        println(coloredMessageSeparator())
    }

    open fun selectingAttackType(opponent: Opponent, bag: Bag) {
    }

}
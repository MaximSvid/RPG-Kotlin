open class Character(var name: String, var health: Double) {

    var originHP: Double = health //Der Gesundheitszustand beträgt 100 %. Vorausgesetzt, dieser Wert ist der Höchstwert bei der Initialisierung
    var attackFactor: Double = 1.0 //eine der Funktionen erhöht diesen Wert um 10%
    var isHospital: Boolean = false  //Eine der Funktionen (reduceHealthByHospital) setzt voraus, dass eine Spielfigur jeweils nur einmal im Krankenhaus sein kann.
    var isShieldActive: Boolean = false // Flag, das anzeigt, ob der Schild aktiv ist

    // Aktiviert den Schild, falls er noch nicht aktiv ist
    open fun activateShield() {
        if (isShieldActive) {
            println(
                when (this) {
                    is Swordsman -> blueTextSwordsman("$name's shield is already active!")
                    is Archer -> greenTextArcher("$name's shield is already active!")
                    is Rider -> yellowTextRider("$name's shield is already active!")
                    else -> "$name's shield is already active!"
                }
            )
        } else {
            isShieldActive = true
            println(
                when (this) {
                    is Swordsman -> blueTextSwordsman("$name raised their shield! Incoming damage will be reduced by 80%.")
                    is Archer -> greenTextArcher("$name raised their shield! Incoming damage will be reduced by 80%.")
                    is Rider -> yellowTextRider("$name raised their shield! Incoming damage will be reduced by 80%.")
                    else -> "$name raised their shield! Incoming damage will be reduced by 80%!"
                }
            )
        }
        println(coloredMessageSeparator())
    }

    // Setzt den Schildstatus zurück (deaktiviert den Schild)
    fun resetShield () {
        isShieldActive = false // Deaktiviert den Schild für die nächste Runde
    }

    // Gibt eine farbige Trennlinie basierend auf dem Charaktertyp zurück
    private fun coloredMessageSeparator(): String {
        return when (this) {
            is Swordsman -> blueTextSwordsman("------------------------------------------------")
            is Archer -> greenTextArcher("------------------------------------------------")
            is Rider -> yellowTextRider("------------------------------------------------")
            else -> "------------------------------------------------"
        }
    }

    // Das Wort "open" bedeutet, dass diese Funktion überschrieben werden kann (override).
    // Ich weiß nicht, welcher Held diese Funktion verwenden wird, daher verwende ich das Wort "this.name"(im swift self).
    open fun attackCharacter(opponent: Opponent, attack: Int) {
        opponent.health -= attack
        opponent.health = roundDouble(opponent.health)
        val message = "${this.name} attacked and dealt $attack damage. ${opponent.name} has more health ${opponent.health}"
        val coloredMessage = when (this) {
            is Swordsman -> blueTextSwordsman(message)
            is Archer -> greenTextArcher(message)
            is Rider -> yellowTextRider(message)
            else -> message
        }
        println(coloredMessage)
        println(coloredMessageSeparator())
    }

    // Heilt einen Charakter um eine bestimmte Anzahl an Punkten; kann überschrieben werden
    open fun healthCharacter(character: Character, points: Int) {
        character.health += points // Erhöht die Gesundheit des Charakters um die angegebenen Punkte
        character.health = roundDouble(character.health)
        val message =
            "${this.name} has been reinstated to $points points. ${this.name} has more health ${character.health}"
        //In Kotlin wird das Wort when als multifunktionaler Auswahloperator verwendet, ähnlich wie switch in anderen Programmiersprachen. Es ermöglicht, eine Variable auf die Übereinstimmung mit verschiedenen Bedingungen zu überprüfen und den entsprechenden Codeblock auszuführen.
        val coloredMessage = when (this) {
            is Swordsman -> blueTextSwordsman(message)
            is Archer -> greenTextArcher(message)
            is Rider -> yellowTextRider(message)
            else -> message
        }
        println(coloredMessage)
        println(coloredMessageSeparator())
    }

    // Abstrakte Methode zur Auswahl des Angriffstyps; muss in Unterklassen implementiert werden
    open fun selectingAttackType(opponent: Opponent, bag: Bag) {
        // Leer gelassen, da diese Methode in den Unterklassen überschrieben wird
    }

}
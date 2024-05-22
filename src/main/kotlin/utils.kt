import kotlin.math.roundToInt


fun roundDouble(health: Double): Double {
    var roundedHealthToInt = (health * 100).roundToInt()
    var roundedHealth: Double = roundedHealthToInt / 100.0
    return roundedHealth
}

fun chooseCharacter (character: Character, opponent: Opponent) {
    println("""
        Choose a character...
        [1] - Swordsman
        [2] - Rider
        [3] - Archer
    """.trimIndent())
    val choiceCharacter = readln()
    when (choiceCharacter) {
        "1" -> {
            val swordsman = character as Swordsman
            println("""
                Swordsman attacked...
                Select the type of attack...
                [1] - Normal attack
                [2] - Enhanced attack (quantity limited. Attacks available ${swordsman.numberStrongAttacks})
                You can offer treatment for your friends...
                [3] - Conventional treatment
                [4] - Enhanced treatment (quantity limited. Treatments available ${swordsman.numberStrongTreatments})
            """.trimIndent())
            val choiceAttack = readln()
            when (choiceAttack) {
                "1" -> swordsman.swordAttack(opponent)
                "2" -> swordsman.superStrongSwordAttack(opponent)
            }
        }
    }
}

fun chooseActionCharacter () {

}
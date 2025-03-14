import kotlin.math.roundToInt
//

fun roundDouble(health: Double): Double { //diese Funktion reduziert die Anzahl der Nachkommastellen auf zwei Stellen
    val roundedHealthToInt = (health * 100).roundToInt()
    val roundedHealth: Double = roundedHealthToInt / 100.0
    return roundedHealth
}

fun colorTextReset(text: String, color: String): String {
    val reset = "\u001B[0m"
    return "$color$text$reset"
}

fun blueTextSwordsman(text: String): String {
    val blue = "\u001b[34m"
    return colorTextReset(text, blue)
}

fun yellowTextRider(text: String): String {
    val gray = "\u001B[33m"
    return colorTextReset(text, gray)
}

fun greenTextArcher(text: String): String {
    val green = "\u001B[32m"
    return colorTextReset(text, green)
}

fun redTextStrongOpponent(text: String): String {
    val red = "\u001b[31m"
    return colorTextReset(text, red)
}

fun purpleTextCommonOpponent(text: String): String {
    val purple = "\u001b[35m"
    return colorTextReset(text, purple)
}

fun brownTextOpponentSaboteur(text: String): String {
    val brown = "\u001b[38;5;94m"
    return colorTextReset(text, brown)
}

fun pintTextBag(text: String): String {
    val pink = "\u001b[95m"
    return colorTextReset(text, pink)
}

fun statusColor(text: String): String {
    val white = "\u001b[97m"
    return colorTextReset(text, white)
}

//kleine geschichte das Spiel
fun showIntroduction() {
    val introduction = """
        The Ritter...
        Vor langer Zeit, in einem Land voller grüner Täler und hoher Berge, 
        lebten zwei Völker in Frieden und Harmonie. Die Stämme der Elben und 
        der Menschen teilten das Land und halfen einander in Notzeiten.
        Doch eines Tages erhob sich König, getrieben von Gier und Macht. 
        Er führte seine Armee in den Krieg und zerstörte den Frieden...

        Die Ritter stehen nun bereit, das Böse zu bekämpfen!
        
        Das Spiel beginnt jetzt!"
    """.trimIndent()

    for (char in introduction) {
        print(char)
        Thread.sleep(10) // Kurze Pause zwischen Wörtern
    }
    println()

}

fun statusWarrior(character: Character) {
    println(statusColor(if (character.health > 0) "Warrior ${character.name} has ${character.health} health" else "Warrior ${character.name} dropped out"))
}

fun statusCommonOpponent(commonOpponent: CommonOpponent) {
    println(statusColor(if (commonOpponent.health > 0) "Opponent ${commonOpponent.name} has ${commonOpponent.health} health" else "Opponent ${commonOpponent.name} dropped out"))
}

fun statusStrongOpponent(opponentList: MutableList<Opponent>) {
    val strongOpponent = opponentList.find { it is StrongOpponent }
    if (strongOpponent != null) {
        println(
            statusColor(
                if (strongOpponent.health > 0)
                    "Strong Opponent ${strongOpponent.name} has ${strongOpponent.health} health"
                else
                    "A Strong Opponent dropped out"
            )
        )
    } else {
        println(statusColor("A Strong Opponent has yet to emerge"))
    }
    println(statusColor("-----------------------------------------------"))
}













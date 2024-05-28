import kotlin.math.roundToInt


fun roundDouble(health: Double): Double {
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

fun pintTextBag(text: String): String {
    val pink = "\u001b[95m"
    return colorTextReset(text, pink)
}

fun statusColor(text: String): String {
    val white = "\u001b[97m"
    return colorTextReset(text, white)
}
















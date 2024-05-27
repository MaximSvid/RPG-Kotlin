import kotlin.math.roundToInt


fun roundDouble(health: Double): Double {
    val roundedHealthToInt = (health * 100).roundToInt()
    val roundedHealth: Double = roundedHealthToInt / 100.0
    return roundedHealth
}












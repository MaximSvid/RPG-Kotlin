import kotlin.math.roundToInt


fun roundDouble(health: Double): Double {
    var roundedHealthToInt = (health * 100).roundToInt()
    var roundedHealth: Double = roundedHealthToInt / 100.0
    return roundedHealth
}
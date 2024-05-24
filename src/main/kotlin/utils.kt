import kotlin.math.roundToInt


fun roundDouble(health: Double): Double {
    var roundedHealthToInt = (health * 100).roundToInt()
    var roundedHealth: Double = roundedHealthToInt / 100.0
    return roundedHealth
}

//fun start (characterList: MutableList<Character>, opponentList: MutableList<Opponent>, bag: Bag) {
//    println(
//        """
//        Choose a character...
//        [1] - Swordsman
//        [2] - Rider
//        [3] - Archer
//    """.trimIndent()
//    )
//    val chooseCharacterInput = readln()
//    if (chooseCharacterInput == "1") {
//        selectingAttackTypeSwordsman(characterList, opponentList, bag)
//    } else if (chooseCharacterInput == "2"){
//        selectingAttackTypeRider(characterList, opponentList, bag)
//    } else if (chooseCharacterInput == "3") {
//        selectingAttackTypeArcher(characterList, opponentList, bag)
//    } else {
//        println("Enter a number between 1 and 4")
//        start(characterList, opponentList, bag)
//    }
//}
fun start (characterList: MutableList<Character>, opponentList: MutableList<Opponent>, bag: Bag) {
    var roundNumber: Int = 1
    while (characterList.isNotEmpty() || opponentList.isNotEmpty()) {
        println("---Round number $roundNumber---")
        println("Character's turn:")



        bag.resetBagUse()
        roundNumber++
    }

}










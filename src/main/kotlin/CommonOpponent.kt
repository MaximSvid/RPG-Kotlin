import java.util.Random

// import java.util.Random
//import kotlin.random.Random

class CommonOpponent(name: String, health: Double) : Opponent(name, health) {

    fun opponentAttackOnAllWarriors(warriorList: MutableList<Character>) {
        val attack = 20
        println("The enemy attacked...")
        super.attackOpponent(warriorList, attack)
    }

    //    fun commonOpponentPlusHealth (opponent: Opponent) {
//        val points = 30
//        println("The state of health ${opponent.name} is equal to ${opponent.health}")
//        super.healthOpponent(opponent, points)
//    }
    fun commonOpponentAttack(character: Character) {
        var attack = 35
        println("Current health status ${character.name} is ${character.health}")
        println("${this.name} attacked with a normal attack")
        super.attackcOpponent(character, attack)
    }

    fun commonStrongOpponentAttack(character: Character) {
        var attack = 50
        println("Current health status ${character.name} is ${character.health}")
        println("${this.name} attacking with an intensified attack")
        super.attackcOpponent(character, attack)
    }

    fun inTheHospital(character: Character) {
        if (character.isHospital) {
            println("The character ${character.name} is already in the hospital")
        } else {
            character.isHospital = true
            character.isHospitalRound = 3
            println("${this.name} attacked ${character.name} and ${character.name} was hospitalized")
            println("A warrior with a name ${character.name} was hospitalized for ${character.isHospitalRound} rounds")
        }

    }

    fun reduceHealthByHospital(character: Character) {
        if (character.isHospitalRound > 0 && character.isHospital == true) {
            val healthThreshold =
                0.2 * character.health //Die Funktion ist unwirksam, wenn der Gesundheitszustand weniger als 20% beträgt.
            if (character.health > healthThreshold) {
                val healthToReduce = character.health * 0.15 //Funktion reduziert die Gesundheit um 15%
                character.health -= healthToReduce
                character.health = roundDouble(character.health)
                println("${character.name} health reduced by 15%. Current health: ${character.health}")
                println("------------------------------------------------")
            } else {
                println("${character.name} health is already below 20%.\nThe patient has been discharged from the hospital ")
                println("------------------------------------------------")
            }
            character.isHospitalRound--
        }
    }

    fun randomCommonOpponentAttack(characterList: MutableList<Character>) {
        val attack = kotlin.random.Random.nextInt(4)
        when (attack) {
            0 -> opponentAttackOnAllWarriors(characterList)
            1 -> commonOpponentAttack(characterList.random())
            2 -> commonStrongOpponentAttack(characterList.random())
            3 -> reduceHealthByHospital(characterList.random())
        }
    }


}
import java.util.Random

// import java.util.Random
//import kotlin.random.Random

class CommonOpponent(name: String, health: Double) : Opponent(name, health) {

    internal var isStrongOpponentSummoned: Boolean = false

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
        println("Current health status ${character.name} is ${character.health}. ${this.name} attacked with a normal attack")
//        println("${this.name} attacked with a normal attack")
        super.attackcOpponent(character, attack)
    }

    fun commonStrongOpponentAttack(character: Character) {
        var attack = 50
        println("Current health status ${character.name} is ${character.health}. ${this.name} attacking with an intensified attack")
//        println("${this.name} attacking with an intensified attack")
        super.attackcOpponent(character, attack)
    }

//    override fun inTheHospital(character: Character) {
//        if (character.isHospital) {
//            println("The character ${character.name} is already in the hospital")
//        } else {
//            character.isHospital = true
//            character.isHospitalRound = 3
//            println("${this.name} attacked ${character.name} and ${character.name} was hospitalized ${character.isHospitalRound} rounds")
//        }
//    }

    override fun reduceHealthByHospital(character: Character) {
        character.isHospital = true
        val healthThreshold =
            0.2 * character.health //Die Funktion ist unwirksam, wenn der Gesundheitszustand weniger als 20% beträgt.
        if (character.health > healthThreshold) {
            val healthToReduce = character.health * 0.10 //Funktion reduziert die Gesundheit um 10%
            character.health -= healthToReduce
            character.health = roundDouble(character.health)
            println("${character.name} health reduced by 10%. Current health: ${character.health}")
            println("------------------------------------------------")
        } else {
            println("${character.name} health is already below 20%.\nThe patient has been discharged from the hospital ")
            character.isHospital = false
            println("------------------------------------------------")
        }

    }

//    fun superStrongOpponent(): StrongOpponent {
//        val strongOpponent = StrongOpponent("StrongOpponent", 250.0)
//        return strongOpponent
//    }

//    fun summonStrongOpponent(opponentList: MutableList<Opponent>) {
//        val commonOpponentStrong = StrongOpponent("StrongEnemy", 180.0)
//        opponentList.add(commonOpponentStrong)
//        isStrongOpponentSummoned = true
//
//        println("Support opponent ${commonOpponentStrong.name} is summoned, his health ${commonOpponentStrong.health} in aid the main opponent!")
//    }

    fun enemyHealthStatusNew(opponent: CommonOpponent, opponentList: MutableList<Opponent>) {
        if (health <= 0.5 * originHeatlhCommon && !isStrongOpponentSummoned) { //Wenn die Gesundheit des Gegners unter 50% liegt und der Boss noch nicht beschworen wurde, dann beschwöre den Boss
            println("The enemy's health status is ${opponent.health} and less than 50 percent ")
            summonStrongOpponent(opponentList)
        }
    }

    fun summonStrongOpponent(opponentList: MutableList<Opponent>) {
        val commonOpponentStrong = StrongOpponent("StrongEnemy", 220.0)
        opponentList.add(commonOpponentStrong)
//        val newOpponents = opponentList.toMutableList()
//        newOpponents.add(commonOpponentStrong)
//        opponentList.clear()
//        opponentList.addAll(newOpponents)
        isStrongOpponentSummoned = true
        println("Support opponent ${commonOpponentStrong.name} is summoned, his health ${commonOpponentStrong.health} in aid the main opponent!")
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
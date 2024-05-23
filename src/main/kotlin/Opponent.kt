import kotlin.system.exitProcess


open class Opponent(var name: String, var health: Double, var level: Int = 1) {

    var isDeadOpponent: Boolean = false

    var originHeatlhCommon: Double
    var isStrongOpponentSummoned: Boolean = false


    init {
        this.originHeatlhCommon = health
    }


//    open fun inTheHospital(character: Character) {
//        if (character.isHospital) {
//            println("The character ${character.name} is already in the hospital")
//        } else {
//            character.isHospital = true
//            character.isHospitalRound = 3
//            println("${this.name} attacked ${character.name} and ${character.name} was hospitalized")
//            println("A warrior with a name ${character.name} was hospitalized for ${character.isHospitalRound} rounds")
//        }
//
//    }

//    open fun reduceHealthByHospital(character: Character) {
//        if (character.isHospitalRound > 0 && character.isHospital == true) {
//            val healthThreshold =
//                0.2 * character.health //Die Funktion ist unwirksam, wenn der Gesundheitszustand weniger als 20% beträgt.
//            if (character.health > healthThreshold) {
//                val healthToReduce = character.health * 0.15 //Funktion reduziert die Gesundheit um 15%
//                character.health -= healthToReduce
//                character.health = roundDouble(character.health)
//                println("${character.name} health reduced by 15%. Current health: ${character.health}")
//                println("------------------------------------------------")
//            } else {
//                println("${character.name} health is already below 20%.\nThe patient has been discharged from the hospital ")
//                println("------------------------------------------------")
//            }
//            character.isHospitalRound--
//        }
//    }


    open fun attackOpponent(characterList: MutableList<Character>, attack: Int) {
        val defeatedTargets = mutableListOf<Character>()
        if (characterList.isNotEmpty()) {
            for (target in characterList) {
                target.health -= attack
                target.health = roundDouble(target.health)
                println("An opponent ${target.name} has been defeated. Health ${target.name} equals ${target.health} ")
                if (target.health <= 0) {
                    defeatedTargets.add(target)
                }
            }
            for (warrior in defeatedTargets) {
                characterList.remove(warrior)
                println("${warrior.name} dropped out")
            }

            println("------------------------------------------------")

        }
        if (characterList.isEmpty()) {
            isDeadOpponent = true
            println("The end of the game the opposing team won")
            exitProcess(0)
        }
    }

    open fun enemyHealthStatus(opponent: CommonOpponent, opponentList: MutableList<Opponent>) {
        if (health <= 0.5 * originHeatlhCommon && !isStrongOpponentSummoned) { //Wenn die Gesundheit des Gegners unter 50% liegt und der Boss noch nicht beschworen wurde, dann beschwöre den Boss
            println("The enemy's health status is ${opponent.health} and less than 50 percent ")
            summonStrongOpponent(opponentList)
        }
    }

    open fun summonStrongOpponent(opponentList: MutableList<Opponent>) {
        val summonOpponent = StrongOpponent("StrongEnemy", 180.0)
        opponentList.add(summonOpponent)
        isStrongOpponentSummoned = true

        println("Support opponent ${summonOpponent.name} is summoned, his health ${summonOpponent.health} in aid the main opponent!")
    }

//    open fun healthOpponent (opponent: Opponent, points: Int) {
//        opponent.health += points
//        opponent.health = roundDouble(opponent.health)
//        println("${opponent.name} has been reinstated to $points points")
//        println("${opponent.name} has more health ${opponent.health}")
//        println("------------------------------------------------")
//
//        if (opponent.health <= 0) {
//            println("Health cannot be restored because ${opponent.name} one died")
//            isDeadOpponent = true
//        }
//    }

    open fun attackcOpponent (character: Character, attack: Int) {
        character.health -= attack
        character.health = roundDouble(character.health)
        println("${this.name} attacked and dealt $attack damage")
        println("${character.name} has more health ${character.health}")
        println("------------------------------------------------")

        if (character.health <= 0) {
            println("${character.name} dropped out of the game")
            character.isDeadCharacter = true
        }
    }




}

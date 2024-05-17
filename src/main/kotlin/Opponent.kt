import kotlin.system.exitProcess


open class Opponent(var name: String, var health: Double, var level: Int = 1) {

    var isDeadOpponent: Boolean = false
    var isHospital: Boolean = false
    var isHospitalRound: Int = 0
    var originHeatlhCommon: Double
    var isStrongOpponentSummoned: Boolean = false

    init {
            this.originHeatlhCommon = health
    }

    open fun inTheHospital(character: Character) {
        isHospital = true
        isHospitalRound = 3
        println("${this.name} attacked ${character.name} and ${character.name} was hospitalized")
        println("A warrior with a name ${character.name} was hospitalized for $isHospitalRound rounds")
    }

    open fun reduceHealthByHospital(character: Character) {
        if (isHospitalRound > 0 && isHospital == true) {
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
            isHospitalRound--
        }
    }


    open fun attackOpponent(warriorList: MutableList<Character>, attack: Int) {
        val defeatedTargets = mutableListOf<Character>()
        if (warriorList.isNotEmpty()) {
            for (target in warriorList) {
                target.health -= attack
                target.health = roundDouble(target.health)
                println("An opponent ${target.name} has been defeated. Health ${target.name} equals ${target.health} ")
                if (target.health <= 0) {
                    defeatedTargets.add(target)
                }
            }
            for (warrior in defeatedTargets) {
                warriorList.remove(warrior)
                println("${warrior.name} dropped out")
            }

            println("------------------------------------------------")

        }
        if (warriorList.isEmpty()) {
            isDeadOpponent = true
            println("The end of the game the opposing team won")
            exitProcess(0)
        }
    }

    open fun enemyHealthStatus (opponent: CommonOpponent, opponentList: MutableList<Opponent>) {
        if (health <= 0.5 * originHeatlhCommon && !isStrongOpponentSummoned){ //Wenn die Gesundheit des Gegners unter 50% liegt und der Boss noch nicht beschworen wurde, dann beschwöre den Boss
            summonStrongOpponent(opponentList)
        }
    }

    open fun summonStrongOpponent(opponentList: MutableList<Opponent>) {
        val summonOpponent = StrongOpponent("StrongEnemy", 180.0)
        opponentList.add(summonOpponent)
        isStrongOpponentSummoned = true
        println("Support opponent ${summonOpponent.name} is summoned, his health ${summonOpponent.health} in aid the main opponent!")
    }

}

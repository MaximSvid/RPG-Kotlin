import java.util.Random

// import java.util.Random
//import kotlin.random.Random

class CommonOpponent(name: String, health: Double) : Opponent(name, health) {

    private var isStrongOpponentSummoned: Boolean = false

    private fun opponentAttackOnAllWarriors(warriorList: MutableList<Character>) {
        val attack = 20
        println("ATTACK ON ALL WARRIORS...The enemy attacked...")
        super.attackOpponent(warriorList, attack)
    }

    private fun commonOpponentAttack(character: Character) {
        var attack = 35
        println("NORMAL ATTACK. Current health status ${character.name} is ${character.health}. ${this.name} attacked with a normal attack")
        super.attackcOpponent(character, attack)
    }

    private fun commonStrongOpponentAttack(character: Character) {
        var attack = 50
        println("STRONG ATTACK. Current health status ${character.name} is ${character.health}. ${this.name} attacking with an intensified attack")
        super.attackcOpponent(character, attack)
    }

    private fun commonMegaStrongOpponentAttack(character: Character) {
        val attack = 80
        println("SUPER MEGA STRONG ATTACK. Current health status ${character.name} is ${character.health}. ${this.name} attacking with an intensified attack")
        super.attackcOpponent(character, attack)
    }


    override fun reduceHealthByHospital(character: Character) {
        if (!character.isHospital) {
            character.isHospital = true
            val healthThreshold =
                0.2 * character.health //Die Funktion ist unwirksam, wenn der Gesundheitszustand weniger als 20% beträgt.
            if (character.health > healthThreshold) {
                val healthToReduce = character.health * 0.10 //Funktion reduziert die Gesundheit um 10%
                character.health -= healthToReduce
                character.health = roundDouble(character.health)
                println("FUN IS HOSPITAL!!!${character.name} health reduced by 10%. Current health: ${character.health}")
                println("------------------------------------------------")
            } else {
                println("${character.name} health is already below 20%.\nThe patient has been discharged from the hospital ")
                character.isHospital = false
                println("------------------------------------------------")
            }
        } else {
            println("A character already in the hospital cannot be reapplied")
        }


    }

    fun enemyHealthStatusNew(opponent: CommonOpponent, opponentList: MutableList<Opponent>) {
        if (health <= 0.5 * originHeatlhCommon && !isStrongOpponentSummoned) { //Wenn die Gesundheit des Gegners unter 50% liegt und der Boss noch nicht beschworen wurde, dann beschwöre den Boss
            println("The enemy's health status is ${opponent.health} and less than 50 percent ")
            summonStrongOpponent(opponentList)
        }
    }

    private fun summonStrongOpponent(opponentList: MutableList<Opponent>) {
        val commonOpponentStrong = StrongOpponent("StrongEnemy", 220.0)
        opponentList.add(commonOpponentStrong)
        isStrongOpponentSummoned = true
        println("Support opponent ${commonOpponentStrong.name} is summoned, his health ${commonOpponentStrong.health} in aid the main opponent!")
    }

    fun randomCommonOpponentAttack(characterList: MutableList<Character>) {
        val attack = kotlin.random.Random.nextInt(5)
        when (attack) {
            0 -> opponentAttackOnAllWarriors(characterList)
            1 -> commonOpponentAttack(characterList.random())
            2 -> commonStrongOpponentAttack(characterList.random())
            3 -> reduceHealthByHospital(characterList.random())
            4 -> commonMegaStrongOpponentAttack(characterList.random())

        }
    }


}
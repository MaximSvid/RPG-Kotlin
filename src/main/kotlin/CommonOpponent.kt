// import java.util.Random
//import kotlin.random.Random

class CommonOpponent(name: String, health: Double) : Opponent(name, health) {

    private var isStrongOpponentSummoned: Boolean = false

    private fun opponentAttackOnAllWarriors(warriorList: MutableList<Character>) {
        val attack = 25
        println(purpleTextCommonOpponent("ATTACK ON ALL WARRIORS...The enemy attacked..."))
        super.allAtOnce(warriorList, attack)
    }

    private fun commonOpponentAttack(character: Character) {
        val attack = 35
        println(purpleTextCommonOpponent("NORMAL ATTACK. Current health status ${character.name} is ${character.health}. ${this.name} attacked with a normal attack"))
        super.commonAttack(character, attack)
    }

    private fun commonStrongOpponentAttack(character: Character) {
        val attack = 50
        println(purpleTextCommonOpponent("STRONG ATTACK. Current health status ${character.name} is ${character.health}. ${this.name} attacking with an intensified attack"))
        super.commonAttack(character, attack)
    }

    private fun commonMegaStrongOpponentAttack(character: Character) {
        val attack = 100
        if (kotlin.random.Random.nextBoolean()) { // 50-prozentige Chance auf einen Angriff ( true or false) (if true damm if blocke wird erfuhlt)
            println(purpleTextCommonOpponent("SUPER MEGA STRONG ATTACK. Current health status ${character.name} is ${character.health}. ${this.name} attacking with an intensified attack"))
            super.commonAttack(character, attack)
        } else {
            println(purpleTextCommonOpponent("${this.name} attempted SUPER MEGA STRONG ATTACK but in failed"))
        }

    }


    override fun reduceHealthByHospital(character: Character) {
        val healthThreshold =
            0.2 * character.originHP //Die Funktion ist unwirksam, wenn der Gesundheitszustand weniger als 20% beträgt.
        val healthToReduce = character.originHP * 0.10 //Funktion reduziert die Gesundheit um 10%
        if (character.health > healthThreshold && !character.isHospital) {
            character.isHospital = true
            character.health -= healthToReduce
            character.health = roundDouble(character.health)
            println(purpleTextCommonOpponent("Attack CommonEnemy ${character.name} IS HOSPITAL!!!${character.name} health reduced by 10%. Current health: ${character.health}"))
            println(purpleTextCommonOpponent("------------------------------------------------"))
        } else if (character.health < healthThreshold && character.isHospital) {
            character.isHospital = false
            println(purpleTextCommonOpponent("${character.name} health is already below 20%.\nThe patient has been discharged from the hospital"))
            println(statusColor("------------------------------------------------"))
        } else if (character.isHospital){
            character.health -= healthToReduce
            character.health = roundDouble(character.health)
            println(purpleTextCommonOpponent("Patient's ${character.name} still in the hospital and his health equals ${character.health} points"))
            println(purpleTextCommonOpponent("------------------------------------------------" +
                    ""))
        }
    }


    fun enemyHealthStatusNew(opponent: CommonOpponent, opponentList: MutableList<Opponent>) {
        if (health <= 0.5 * originHealthCommon && !isStrongOpponentSummoned) { //Wenn die Gesundheit des Gegners unter 50% liegt und der Boss noch nicht beschworen wurde, dann beschwöre den Boss
            println(purpleTextCommonOpponent("The enemy's health status is ${opponent.health} and less than 50 percent"))
            summonStrongOpponent(opponentList)
        }
    }

    private fun summonStrongOpponent(opponentList: MutableList<Opponent>) {
        val commonOpponentStrong = StrongOpponent("StrongEnemy", 220.0)
        opponentList.add(commonOpponentStrong)
        isStrongOpponentSummoned = true
        println(purpleTextCommonOpponent("Support opponent ${commonOpponentStrong.name} is summoned, his health ${commonOpponentStrong.health} in aid the main opponent!"))
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
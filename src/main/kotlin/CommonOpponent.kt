// import java.util.Random
//import kotlin.random.Random

class CommonOpponent(name: String, health: Double) : Opponent(name, health) {

    // Reduziert die Gesundheit eines Charakters um 10% und simuliert einen Krankenhausaufenthalt
    override fun reduceHealthByHospital(character: Character) {
        val healthThreshold: Double =
            0.2 * character.originHP //Die Funktion ist unwirksam, wenn der Gesundheitszustand weniger als 20% beträgt. Die Aufgabe dieser Konstante besteht darin, einen Gesundheitswert zu erreichen, der 20 % des ursprünglichen Wertes entspricht.
        val healthToReduce: Double =
            character.originHP * 0.10
        if (character.health > healthThreshold && !character.isHospital) {
            character.isHospital =
                true //Die Variable isHospital ist mein Flag, das ich verwende, damit ich diese Funktion nicht zweimal auf denselben Helden anwenden kann.
            character.health -= healthToReduce
            character.health = roundDouble(character.health)
            println(purpleTextCommonOpponent("Attack CommonEnemy ${character.name} IS HOSPITAL!!!${character.name} health reduced by 10%. Current health: ${character.health}"))
            println(purpleTextCommonOpponent("------------------------------------------------"))
        } else if (character.health < healthThreshold && character.isHospital) {
            character.isHospital = false
            println(purpleTextCommonOpponent("${character.name} health is already below 20%.\nThe patient has been discharged from the hospital"))
            println(statusColor("------------------------------------------------"))
        } else if (character.isHospital) { //Ich verwende diese Logik, um die Gesundheit des Helden jede Runde zu reduzieren.
            character.health -= healthToReduce
            character.health = roundDouble(character.health)
            println(purpleTextCommonOpponent("Patient's ${character.name} still in the hospital and his health equals ${character.health} points"))
            println(purpleTextCommonOpponent("--------------------------------------------------"))
        }
    }

    private var isStrongOpponentSummoned: Boolean = false // Flag, das anzeigt, ob ein starker Gegner beschworen wurde

    // Angriff auf alle Krieger gleichzeitig, verursacht 25 Schaden pro Charakter
    private fun opponentAttackOnAllWarriors(warriorList: MutableList<Character>) {
        val attack = 25
        println(purpleTextCommonOpponent("ATTACK ON ALL WARRIORS...The enemy attacked..."))
        super.allAtOnce(warriorList, attack)
    }

    // Normaler Angriff, verursacht 35 Schaden an einem einzelnen Charakter
    private fun commonOpponentAttack(character: Character) {
        val attack = 35
        println(purpleTextCommonOpponent("NORMAL ATTACK. Current health status ${character.name} is ${character.health}. ${this.name} attacked with a normal attack"))
        super.commonAttack(character, attack)
    }

    // Starker Angriff, verursacht 50 Schaden an einem einzelnen Charakter
    private fun commonStrongOpponentAttack(character: Character) {
        val attack = 50
        println(purpleTextCommonOpponent("STRONG ATTACK. Current health status ${character.name} is ${character.health}. ${this.name} attacking with an intensified attack"))
        super.commonAttack(character, attack)
    }

    // Superstarker Angriff mit 50% Erfolgschance, verursacht 100 Schaden
    private fun commonMegaStrongOpponentAttack(character: Character) {
        val attack = 100
        if (kotlin.random.Random.nextBoolean()) { // 50-prozentige Chance auf einen Angriff ( true or false) (if true damm if blocke wird erfuhlt)
            println(purpleTextCommonOpponent("SUPER MEGA STRONG ATTACK. Current health status ${character.name} is ${character.health}. ${this.name} attacking with an intensified attack"))
            super.commonAttack(character, attack)
        } else {
            println(purpleTextCommonOpponent("${this.name} attempted SUPER MEGA STRONG ATTACK but in failed"))
        }
    }

    // Überprüft den Gesundheitszustand des Gegners und beschwört bei Bedarf einen starken Gegner
    fun enemyHealthStatusNew(commonOpponent: CommonOpponent, opponentList: MutableList<Opponent>) {
        if (health <= 0.5 * originHealthCommon && !isStrongOpponentSummoned) { //Wenn die Gesundheit des Gegners unter 50% liegt und der Boss noch nicht beschworen wurde, dann beschwöre den Boss
//            println(purpleTextCommonOpponent("The enemy's health status is ${opponent.health} and less than 50 percent"))
            summonStrongOpponent(opponentList)
        }
    }

    // Beschwört einen starken Gegner zur Unterstützung
    private fun summonStrongOpponent(opponentList: MutableList<Opponent>) {
        val commonOpponentStrong = StrongOpponent("StrongEnemy", 220.0)
        opponentList.add(commonOpponentStrong)
        isStrongOpponentSummoned = true //Diese Flagge wird benötigt, damit der Boss nur einmal beschworen werden kann.
        println(purpleTextCommonOpponent("Support opponent ${commonOpponentStrong.name} is summoned, his health ${commonOpponentStrong.health} in aid the main opponent!"))
    }

    // Wählt zufällig eine von fünf Angriffsarten des normalen Gegners
    fun randomCommonOpponentAttack(characterList: MutableList<Character>) {
        val attack = kotlin.random.Random.nextInt(5) // Zufällige Zahl von 0 bis 4
        when (attack) {
            0 -> opponentAttackOnAllWarriors(characterList) // Angriff auf alle Krieger
            1 -> commonOpponentAttack(characterList.random()) // Normaler Angriff auf einen zufälligen Charakter
            2 -> commonStrongOpponentAttack(characterList.random()) // Starker Angriff auf einen zufälligen Charakter
            3 -> reduceHealthByHospital(characterList.random()) // Krankenhausangriff auf einen zufälligen Charakter
            4 -> commonMegaStrongOpponentAttack(characterList.random()) // Superstarker Angriff auf einen zufälligen Charakter
        }
    }


}
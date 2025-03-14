import kotlin.random.Random

class OpponentSaboteur (name: String, health: Double): Opponent(name, health ) {

    // Normaler Angriff des Saboteurs, verursacht 50 Schaden an einem einzelnen Charakter
    private fun commonAttack(character: Character) {
        val attack = 50
        println(brownTextOpponentSaboteur("$name attacked and dealt $attack damage.${character.name} has more health ${character.health}"))
        super.commonAttack(character, attack)
    }

    // Sabotage-Angriff mit 20% Chance, verursacht 30 Schaden an allen Charakteren
    private fun saboteurAttack (characters: MutableList<Character>) {
        val chance = Random.nextInt(1, 101) // zhahl von 1 bis 100

        if (chance <= 20) { // 20% möglischkeit
            println(brownTextOpponentSaboteur("$name performs a **Sabotage Attack**!🔥"))
            for (character in characters) {
                val attack = 30
                super.commonAttack(character, attack)
                character.health = roundDouble(character.health)
                println(brownTextOpponentSaboteur("${character.name} loses 50 health. Remaining: ${character.health} HP."))
            }
        } else {
            println(brownTextOpponentSaboteur("$name tried to sabotage, but failed!"))
        }
    }

    // Wählt zufällig zwischen normalem Angriff und Sabotage-Angriff
    fun randomSaboteurOpponentAttack(characterList: MutableList<Character>) {
        val attack = Random.nextInt(2) // Zufällige Wahl: 0 oder 1
        when (attack) {
            0 -> commonAttack(characterList.random()) // Normaler Angriff auf einen zufälligen Charakter
            1 -> saboteurAttack(characterList) // Sabotage-Angriff auf alle Charaktere
        }
    }
}
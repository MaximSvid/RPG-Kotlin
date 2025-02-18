import kotlin.random.Random

class OpponentSaboteur (name: String, health: Double): Opponent(name, health ) {
    private fun commonAttack(character: Character) {
        val attack = 50
        println(brownTextOpponentSaboteur("$name attacked and dealt $attack damage.${character.name} has more health ${character.health}"))
        super.commonAttack(character, attack)
    }

    private fun saboteurAttack (characters: MutableList<Character>) {
        val chance = Random.nextInt(1, 101) // zhahl von 1 bis 100

        if (chance <= 20) { // 20% möglischkeit
            println(brownTextOpponentSaboteur("$name performs a **Sabotage Attack**!🔥"))
            for (character in characters) {
                character.health -= 50
                character.health = roundDouble(character.health)
                println(brownTextOpponentSaboteur("${character.name} loses 50 health. Remaining: ${character.health} HP."))
            }
        } else {
            println(brownTextOpponentSaboteur("$name tried to sabotage, but failed!"))
        }
    }


    fun randomSaboteurOpponentAttack(characterList: MutableList<Character>) {
        val attack = Random.nextInt(2)
        when (attack) {
            0 -> commonAttack(characterList.random())
            1 -> saboteurAttack(characterList)
        }
    }
}
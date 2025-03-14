class StrongOpponent(name: String, health: Double): Opponent (name, health) {

    // Angriff auf alle Krieger gleichzeitig, verursacht 40 Schaden pro Charakter
    private fun strongOpponentAttackOnAllWarriors (warriorList: MutableList<Character>) {
        val attack = 40
        println(redTextStrongOpponent("THE BOSS IS ATTACKING..."))
        super.allAtOnce(warriorList, attack)
    }

    // Normaler Angriff des Bosses, verursacht 35 Schaden an einem einzelnen Charakter
    private fun commonBossOpponentAttack (character: Character) {
        val attack = 35
        println(redTextStrongOpponent("THE BOSS IS ATTACKING. NORMAL ATTACKCurrent health status ${character.name} is ${character.health}. ${this.name} attacked with a normal attack"))
        super.commonAttack(character, attack)
    }

    // Starker Angriff des Bosses, verursacht 70 Schaden an einem einzelnen Charakter
    private fun commonBossStrongOpponentAttack (character: Character) {
        val attack = 70
        println(redTextStrongOpponent("THE BOSS IS ATTACKING. STRONG ATTACK. Current health status ${character.name} is ${character.health}. ${this.name} attacked with a normal attack"))
        super.commonAttack(character, attack)
    }

    // Superstarker Angriff des Bosses mit 50% Erfolgschance, verursacht 180 Schaden
    private fun commonBossSuperStrongOpponentAttack (character: Character) {
        val attack = 180
        if (kotlin.random.Random.nextBoolean()) { // die 50 Prozent Erfolgschance (gibt zurück true oder false)
            println(redTextStrongOpponent("THE BOSS IS ATTACKING. SUPER STRONG ATTACK. Current health status ${character.name} is ${character.health}. ${this.name} attacked with a normal attack"))
//            делай
            super.commonAttack(character, attack)
        } else {
            println(redTextStrongOpponent("${this.name} attempted SUPER MEGA STRONG ATTACK but in failed"))
        }
    }

    // Wählt zufällig eine von vier Angriffsarten des starken Gegners
    fun randomStrongOpponentAttack(characterList: MutableList<Character>) {
        val attack = kotlin.random.Random.nextInt(4) // Zufällige Zahl von 0 bis 3
        when (attack) {
            0 -> strongOpponentAttackOnAllWarriors(characterList) // Angriff auf alle
            1 -> commonBossStrongOpponentAttack(characterList.random()) // Starker Angriff auf einen zufälligen Charakter
            2 -> commonBossOpponentAttack(characterList.random()) // Normaler Angriff auf einen zufälligen Charakter
            3 -> commonBossSuperStrongOpponentAttack(characterList.random()) // Superstarker Angriff auf einen zufälligen Charakter
        }
    }
}
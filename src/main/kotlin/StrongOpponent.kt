class StrongOpponent(name: String, health: Double): Opponent (name, health) {

    private fun strongOpponentAttackOnAllWarriors (warriorList: MutableList<Character>) {
        val attack = 40
        println(redTextStrongOpponent("THE BOSS IS ATTACKING..."))
        super.allAtOnce(warriorList, attack)
    }

    private fun commonBossOpponentAttack (character: Character) {
        val attack = 35
        println(redTextStrongOpponent("THE BOSS IS ATTACKING. NORMAL ATTACKCurrent health status ${character.name} is ${character.health}. ${this.name} attacked with a normal attack"))
        super.commonAttack(character, attack)
    }

    private fun commonBossStrongOpponentAttack (character: Character) {
        val attack = 70
        println(redTextStrongOpponent("THE BOSS IS ATTACKING. STRONG ATTACK. Current health status ${character.name} is ${character.health}. ${this.name} attacked with a normal attack"))
        super.commonAttack(character, attack)
    }

    private fun commonBossSuperStrongOpponentAttack (character: Character) {
        val attack = 180
        if (kotlin.random.Random.nextBoolean()) { // die 50 Prozent Erfolgschance (gibt zurück true oder false)
            println(redTextStrongOpponent("THE BOSS IS ATTACKING. SUPER STRONG ATTACK. Current health status ${character.name} is ${character.health}. ${this.name} attacked with a normal attack"))
            super.commonAttack(character, attack)
        } else {
            println(redTextStrongOpponent("${this.name} attempted SUPER MEGA STRONG ATTACK but in failed"))
        }

    }

    fun randomStrongOpponentAttack(characterList: MutableList<Character>) {
        val attack = kotlin.random.Random.nextInt(4)
        when (attack) {
            0 -> strongOpponentAttackOnAllWarriors(characterList)
            1 -> commonBossStrongOpponentAttack(characterList.random())
            2 -> commonBossOpponentAttack(characterList.random())
            3 -> commonBossSuperStrongOpponentAttack(characterList.random())
        }
    }





}
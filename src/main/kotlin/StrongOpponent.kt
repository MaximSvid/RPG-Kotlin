class StrongOpponent(name: String, health: Double): Opponent (name, health) {
    fun strongOpponentPlusHealth (opponent: Opponent) {
        val points = 50
        println("Health has been increased by $points points.\nThe enemy's health status is equal to ${opponent.health} ")
    }
    private fun strongOpponentAttackOnAllWarriors (warriorList: MutableList<Character>) {
        val attack = 40
        println("THE BOSS IS ATTACKING. The enemy  attacked...")
        super.attackOpponent(warriorList, attack)
    }

    private fun commonBossOpponentAttack (character: Character) {
        var attack = 35
        println("THE BOSS IS ATTACKING. NORMAL ATTACKCurrent health status ${character.name} is ${character.health}. ${this.name} attacked with a normal attack")
        super.attackcOpponent(character, attack)
    }

    private fun commonBossStrongOpponentAttack (character: Character) {
        var attack = 70
        println("THE BOSS IS ATTACKING. STRONG ATTACK. Current health status ${character.name} is ${character.health}. ${this.name} attacked with a normal attack")
        super.attackcOpponent(character, attack)
    }

    fun randomStrongOpponentAttack(characterList: MutableList<Character>) {
        val attack = kotlin.random.Random.nextInt(3)
        when (attack) {
            0 -> strongOpponentAttackOnAllWarriors(characterList)
            1 -> commonBossStrongOpponentAttack(characterList.random())
            2 -> commonBossOpponentAttack(characterList.random())
        }
    }





}
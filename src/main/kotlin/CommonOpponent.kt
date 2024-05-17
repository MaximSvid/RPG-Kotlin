import CommonOpponent

class CommonOpponent(name: String, health: Double): Opponent(name, health) {

    fun attackOnAllWarriors (warriorList: MutableList<Character>) {
        val attack = 20
        println("The enemy attacked...")
        super.attackOpponent(warriorList, attack)
    }

}
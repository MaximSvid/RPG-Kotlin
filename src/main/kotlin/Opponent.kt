

open class Opponent(var name: String, var health: Double) {

    var isDeadOpponent: Boolean = false

    open fun attackOpponent (warriorList: MutableList<Character>, attack: Int) {
        if (warriorList.isNotEmpty()) {
            for (target in warriorList) {
                target.health -= attack
                target.health = roundDouble(target.health)
                println("An opponent ${target.name} has been defeated. Health ${target.name} equals ${target.health} ")
                if (target.health <= 0) {
                    warriorList.remove(target)
                    println("${target.name} dropped out")
                }
            }
            println("------------------------------------------------")

        }
        if (warriorList.isEmpty()) {
            isDeadOpponent = true
            println("Game over, team Rider, Archer, Swordsman wins.")
        }
    }

}

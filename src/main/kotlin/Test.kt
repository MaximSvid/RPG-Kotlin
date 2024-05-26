class Test {

    var warrior1 = Swordsman("Swordsman", 100.0)
    var warrior2 = Rider("Rider", 120.0)
    var warrior3 = Archer("Archer", 70.0)
    var commonOpponent = CommonOpponent("CommonEnemy", 200.0)
//    private var strongOpponent: Opponent = StrongOpponent("StrongEnemy", 180.0)

    var characterList: MutableList<Character> = mutableListOf(warrior1, warrior2, warrior3)
    var opponentList: MutableList<Opponent> = mutableListOf(commonOpponent)

//    var strongOpponent: StrongOpponent? = null// ????
    var bag = Bag()

    fun playRound2() {
        var roundNumber: Int = 1

        while (!endGameCheck1()) {
            println("---Round number $roundNumber---")
            println("Status List")
            println(characterList)
            println(opponentList)
            println("-----------------------------------------------")

            println("""
                ${if (warrior1.health > 0) "Warrior ${warrior1.name} has ${warrior1.health} health" else "Warrior ${warrior1.name} dropped out" }
                ${if (warrior2.health > 0) "Warrior ${warrior2.name} has ${warrior2.health} health" else "Warrior ${warrior2.name} dropped out"}
                ${if (warrior3.health > 0) "Warrior ${warrior3.name} has ${warrior3.health} health" else "Warrior ${warrior3.name} dropped out"}
               -----------------------------------------------
               ${if (commonOpponent.health > 0) "Opponent ${commonOpponent.name} has ${commonOpponent.health} health" else "Opponent ${commonOpponent.name} dropped out"}
            """.trimIndent())

            val strongOpponent = opponentList.find { it is StrongOpponent } as? StrongOpponent
            if (strongOpponent != null) {
                println(
                    if (strongOpponent.health > 0 )
                        "Strong Opponent ${strongOpponent.name} has ${strongOpponent.health} health"
                    else
                        "A Strong Opponent dropped out")
            } else {
                println("A Strong Opponent has yet to emerge")
            }
            println("-----------------------------------------------")

            for (character in characterList) {
                if (character.health > 0.0) {
                    character.selectingAttackType(commonOpponent,bag)
                }
            }
            removeDeadOpponent(opponentList)

            for (opponent in opponentList) {
                if (opponent is CommonOpponent && opponent.health > 0.0 && opponentList.isNotEmpty()) {
                    commonOpponent.randomCommonOpponentAttack(characterList)
                } else if (opponent is CommonOpponent && opponent.health <= 0.0) {
                    continue
                }
            }
            removeDeadHero(characterList)

//            characterList.removeIf { it.health <=0 }// die ausgeknockten Helden auslöschen
//            opponentList.removeIf { it.health <= 0 } // die ausgeknockten Opponenten auslöschen


//            for (opponent in opponentList) {
//                if (opponent is CommonOpponent) {
//                    opponent.enemyHealthStatusNew(opponent, opponentList)
//                }
//            }

            commonOpponent.enemyHealthStatusNew(commonOpponent, opponentList)

//            val iteratorBoss = opponentList.iterator()
//            while (iteratorBoss.hasNext()) {
//                val opponent = iteratorBoss.next()
//                if (opponent is CommonOpponent) {
//                    opponent.enemyHealthStatusNew(opponent, opponentList)
//                }
//            }

            for (opponent in opponentList) {
                if (opponent is StrongOpponent && opponent.health > 0.0 && opponentList.isNotEmpty()) {
                    opponent.randomStrongOpponentAttack(characterList)
                }
            }
            removeDeadHero(characterList)
            removeDeadOpponent(opponentList)

            bag.resetBagUse()
            roundNumber++


        }

        if (characterList.isEmpty() || characterList.all { it.health <= 0.0 }) {
            println("You lost! All heroes were defeated")
        } else if (opponentList.isEmpty() || opponentList.all { it.health <= 0.0 }) {
            println("Congratulations! You won the battle!")
        }


    }

    fun endGameCheck1(): Boolean {
        if (characterList.isEmpty() || opponentList.isEmpty()) {
            return true
        }
        if (characterList.all { it.health <= 0.0 } || opponentList.all { it.health <= 0.0 }) {
            return true
        } else return false
    }
}

fun removeDeadOpponent(opponentList: MutableList<Opponent>) {
    //removeIf - eine Funktion, die jedes Element auf eine bestimmte Bedingung hin überprüft und „true“ zurückgibt, wenn die Bedingung erfüllt ist, und sie ausführt
    opponentList.removeIf { opponent ->
        if (opponent.health <= 0.0) {
            println("---A opponent ${opponent.name} lost---")
            true
        } else {
            false
        }

    }
}

fun removeDeadHero(characterList: MutableList<Character>) {
    characterList.removeIf { character ->
        if (character.health <= 0.0) {
            println("---A character ${character.name} lost---")
            true
        } else {
            false
        }
    }
}
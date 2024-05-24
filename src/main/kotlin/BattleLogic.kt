class BattleLogic {
    private var warrior1 = Swordsman("Swordsman", 100.0)
    private var warrior2 = Rider("Rider", 120.0)
    private var warrior3 = Archer("Archer", 70.0)
    private var commonOpponent: CommonOpponent = CommonOpponent("CommonEnemy", 200.0)
//    private var strongOpponent: Opponent = StrongOpponent("StrongEnemy", 180.0)

    private var characterList: MutableList<Character> = mutableListOf(warrior1, warrior2, warrior3)
    private var opponentList: MutableList<Opponent> = mutableListOf(commonOpponent)

    private var strongOpponent: StrongOpponent? = null
    var bag = Bag()

//    fun playRound() {
//        var roundNumber: Int = 1
//
//        while (!endGameCheck()) {
//            println("---Round number $roundNumber---")
//            println("""
//               Warrior ${warrior1.name} has ${warrior1.health} health
//               Warrior ${warrior2.name} has ${warrior2.health} health
//               Warrior ${warrior3.name} has ${warrior3.health} health
//               -----------------------------------------------
//               Opponent ${commonOpponent.name} has ${commonOpponent.health} health
//               -----------------------------------------------
//
//            """.trimIndent())
//
//            if (commonOpponent.enemyHealthStatusNew()) {
//                for (character in characterList){
//                    character.selectingAttackType(commonOpponent, bag)
//                }
//                removeDeadOpponent(opponentList)
//                println("${commonOpponent.name} has ${commonOpponent.health} more health points ")
//            } else if (!commonOpponent.enemyHealthStatusNew()) {
//                if (strongOpponent == null) {
//                    strongOpponent = commonOpponent.superStrongOpponent()
//                }
//                var noStrongOpponents = true
//                for (opponent in opponentList) {
//                    if (opponent is StrongOpponent) {
//                        noStrongOpponents = false
//                        if (noStrongOpponents == false) {
//                            println("Support opponent ${strongOpponent!!.name} is summoned, his health ${strongOpponent!!.health} in aid the main opponent!")
//                            opponentList.add(strongOpponent!!)
//                            break
//                        }
//
//                    }
//                }
////                if (opponentList.filterIsInstance<StrongOpponent>().isEmpty()) {
////                    println("Support opponent ${strongOpponent!!.name} is summoned, his health ${strongOpponent!!.health} in aid the main opponent!")
////                    opponentList.add(strongOpponent!!)
////                }
//                for (character in characterList){
//                    character.selectingAttackType(opponentList.random(), bag)
//                }
//                removeDeadOpponent(opponentList)
//
//                if (commonOpponent.health > 0) {
//                    commonOpponent.randomCommonOpponentAttack(characterList)
//                    removeDeadHero(characterList)
//                }
//                if (strongOpponent!!.health > 0) {
//                    strongOpponent!!.randomStrongOpponentAttack(characterList)
//                    removeDeadHero(characterList)
//                }
//                println("Opponent health is ${commonOpponent.health}")
//                println("Strong Opponent health is ${strongOpponent!!.health}")
//            }
//            roundNumber++
//            bag.resetBagUse()
//        }
//
//    }


    fun removeDeadHero(characterList: MutableList<Character>) {
        characterList.removeIf { character ->
            if (character.health <= 0) {
                println("A character ${character.name} lost")
                true
            } else {
                false
            }
        }
    }

    fun removeDeadOpponent(opponentList: MutableList<Opponent>) {
        //removeIf - eine Funktion, die jedes Element auf eine bestimmte Bedingung hin überprüft und „true“ zurückgibt, wenn die Bedingung erfüllt ist, und sie ausführt
        opponentList.removeIf { opponent ->
            if (opponent.health <= 0) {
                println("A opponent ${opponent.name} lost")
                true
            } else {
                false
            }

        }
    }

    private fun endGameCheck(): Boolean {
        if (characterList.isEmpty() || opponentList.isEmpty()) {
            return true
        }
        if (characterList.all { it.health <= 0 } || opponentList.all { it.health <= 0 }){
            return true
        }
        else return false
    }


}
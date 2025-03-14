class BattleLogic {

    private var warrior1 = Swordsman("Swordsman", 160.0)
    private var warrior2 = Rider("Rider", 140.0)
    var warrior3 = Archer("Archer", 120.0)

    private var commonOpponent = CommonOpponent("CommonEnemy", 150.0)
    private var opponentSaboteur = OpponentSaboteur("Saboteur", 30.0)

    private var characterList: MutableList<Character> = mutableListOf(warrior1, warrior2, warrior3)
    private var opponentList: MutableList<Opponent> = mutableListOf(commonOpponent, opponentSaboteur)

    private var bag = Bag()


    fun playRound() {
        var roundNumber: Int = 1
//        showIntroduction()
        //In Kotlin ist while eine Schleifenstruktur, die einen Codeblock wiederholt ausführt, solange eine bestimmte Bedingung true ist.
        while (!endGameCheck()) {
            println()
            println(statusColor("----------------ROUND NUMBER $roundNumber-----------------"))
            println()

            println(
                statusColor(
                    """
                ----------------HEROES TEAM-------------------
                ${if (warrior1.health > 0) "Warrior ${warrior1.name} has ${warrior1.health} health" else "Warrior ${warrior1.name} dropped out"}
                ${if (warrior2.health > 0) "Warrior ${warrior2.name} has ${warrior2.health} health" else "Warrior ${warrior2.name} dropped out"}
                ${if (warrior3.health > 0) "Warrior ${warrior3.name} has ${warrior3.health} health" else "Warrior ${warrior3.name} dropped out"}
               ----------------OPPONENTS TEAM----------------- 
               ${if (commonOpponent.health > 0) "Opponent ${commonOpponent.name} has ${commonOpponent.health} health" else "Opponent ${commonOpponent.name} dropped out"}
               ${if (opponentSaboteur.health > 0) "Opponent ${opponentSaboteur.name} has ${opponentSaboteur.health} health" else "Opponent ${opponentSaboteur.name} dropped out"}
            """.trimIndent()
                )
            )

            val strongOpponent = opponentList.find { it is StrongOpponent } //as? StrongOpponent
            /*
            find { it is StrongOpponent } ist eine Find-Methode, die nach einem Element in einer Liste sucht, diese Element ist StrongOpponent.
             */
            if (strongOpponent != null) {
                println(
                    statusColor(
                        if (strongOpponent.health > 0)
                            "Strong Opponent ${strongOpponent.name} has ${strongOpponent.health} health"
                        else
                            "A Strong Opponent dropped out"
                    )
                )
            } else {
                println(statusColor("A Strong Opponent has yet to emerge"))
            }
            println(statusColor("-----------------------------------------------"))

            for (character in characterList) { // Rufe diese Funktion jede Runde auf, wenn jemand im Krankenhaus liegt, bis die Gesundheit >= 20% ist.
                if (character.isHospital) {
                    commonOpponent.reduceHealthByHospital(character)
                }
            }

            for (character in characterList) {
                if (character.health > 0.0) {
                    character.selectingAttackType(opponentList.random(), bag)
                }
            }

            for (opponent in opponentList) {
                if (opponent.health > 0.0 && opponentList.isNotEmpty()) {
                    when (opponent) {
                        is CommonOpponent -> opponent.randomCommonOpponentAttack(characterList)
                        is OpponentSaboteur -> opponent.randomSaboteurOpponentAttack(characterList)
                        is StrongOpponent -> opponent.randomStrongOpponentAttack(characterList)
                    }
                } else if (opponent is CommonOpponent && opponent.health <= 0.0) {
                    continue
                }
            }

            for (opponent in opponentList) {
                if (opponent.health > 0.0) {
                    when (opponent) {
                        is CommonOpponent -> opponent.randomCommonOpponentAttack(characterList)
                        is OpponentSaboteur -> opponent.randomSaboteurOpponentAttack(characterList)
                    }
                }
            }

            commonOpponent.enemyHealthStatusNew(commonOpponent, opponentList)

            removeDeadHero(characterList)
            removeDeadOpponent(opponentList)

            bag.resetBagUse()
            characterList.forEach { it.resetShield() } // // Setzt den Schild für alle Charaktere zurück
            roundNumber++
        }

        if (characterList.isEmpty() || characterList.all { it.health <= 0.0 }) {
            println(
                redTextStrongOpponent(
                    """
        ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
        ┃          ⚔️  The Battle Is Lost!  ⚔️        ┃
        ┃                                             ┃
        ┃  Alas, the valiant efforts of your heroes   ┃
        ┃  were not enough to withstand the might     ┃
        ┃  of the enemy. Despite their courage and    ┃
        ┃  determination, they have fallen in battle. ┃
        ┃                                             ┃
        ┃          🌹 Honor the Fallen 🌹             ┃ 
        ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
        """
                )
            )
        } else if (opponentList.isEmpty() || opponentList.all { it.health <= 0.0 }) {
            println(
                greenTextArcher(
                    """
        ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
        ┃         🎉  Victory Is Yours!  🎉           ┃
        ┃                                             ┃
        ┃  Congratulations! Your indomitable spirit   ┃
        ┃  and unwavering resolve have led your       ┃
        ┃  heroes to triumph over the enemy.          ┃
        ┃                                             ┃
        ┃        🏆  Champions of the Day!  🏆        ┃
        ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
        """
                )
            )
        }


    }

    private fun endGameCheck(): Boolean {
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
            println(statusColor("---A opponent ${opponent.name} lost---"))
            true
        } else {
            false
        }
    }
}

fun removeDeadHero(characterList: MutableList<Character>) {
    characterList.removeIf { character ->
        if (character.health <= 0.0) {
            println(statusColor("---A character ${character.name} lost---"))
            true
        } else {
            false
        }
    }
}
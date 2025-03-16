class Swordsman(name: String, health: Double) : Character(name, health) {

    private var countSuperStrongAttackOfSwordsman: Int = 4 // Anzahl der verfügbaren superstarken Angriffe

    // Normaler Angriff mit dem Schwert, verursacht 20 Schaden
    private fun swordAttack(opponent: Opponent) {
        val attack = 20
        val modifiedAttack = (attack * attackFactor).toInt()
        println(blueTextSwordsman("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with his sword"))
        super.attackCharacter(opponent, modifiedAttack)
    }

    // Superstarker Angriff "Bladestorm" mit 50 Schaden, begrenzt auf 4 Anwendungen
    private fun superStrongSwordAttack(opponent: Opponent) {
        if (countSuperStrongAttackOfSwordsman > 0) {
            val attack = 50
            println(blueTextSwordsman("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with his sword"))
            super.attackCharacter(opponent, attack)
            countSuperStrongAttackOfSwordsman--
        } else {
            println(blueTextSwordsman(""))
        }

    }

    // Aktiviert den Schild, überschreibt die Methode der Oberklasse
    override fun activateShield() {
        super.activateShield()
        println(blueTextSwordsman("Swordsman activated shield..."))
    }

//    Heilung, stellt 15 Gesundheitspunkte wieder her
    private fun swordHealth(character: Character) {
        val points = 15
        println(blueTextSwordsman("The state of health ${character.name} is equal to ${character.health}. A USUALLY treatment was utilized."))
        super.healthCharacter(character, points)
    }


    // Wählt den Angriffstyp aus und zeigt die Optionen in der Konsole an
    override fun selectingAttackType(opponent: Opponent, bag: Bag) {
        println(
            blueTextSwordsman(
                """ SWORDSMAN ATTACKED...
                Swordsman health status: $health HP
                Select the type of attack...
                [1] - Normal Attack 
                ${
                    if (countSuperStrongAttackOfSwordsman <= 0) {
                        "[2] - Bladestorm (No charges left!)"
                    } else {
                        "[2] - Bladestorm (Charges remaining: $countSuperStrongAttackOfSwordsman)"
                    }
                }
                [3] - Activate Shield 
                [4] - Health 
                ${if (!bag.isUsedBag) {"[5] - Bag"
                } else {
                    "The bag has already been used in this round"
                }
                }
            """.trimIndent()
            )
        )
        val choiceAttack = readln()
        when (choiceAttack) {
            "1" -> swordAttack(opponent)
            "2" -> {
                if (countSuperStrongAttackOfSwordsman <= 0) {
                    println(blueTextSwordsman("No Bladestorm charges left! Choose another action."))
                    selectingAttackType(opponent, bag)
                } else {
                    superStrongSwordAttack(opponent)
                }
            }
            "3" -> {
                if (!isShieldActive) {
                    println(blueTextSwordsman("$name raised their shield! Incoming damage will be reduced by 80%."))
                    isShieldActive = true
                } else {
                    println(blueTextSwordsman("$name's shield is already active!"))
                    selectingAttackType(opponent, bag)
                }
            }
            "4" -> swordHealth(this)
            "5" -> {
                if (bag.isUsedBag) {
                    println(pintTextBag("The bag was used in this round"))
                    selectingAttackType(opponent, bag)
                } else {
                    println(
                        pintTextBag(
                            """
                     [1] - Use a bag of medical supplies (The amount of medicine available (${bag.amountOfMedicine})
                     [2] - Use the bag to increase your strength (The amount of power ${bag.amountOfPower})
                """.trimIndent()
                        )
                    )
                    val choiceBag = readln()
                    when (choiceBag) {
                        "1" -> bag.useMedicine(this)
                        "2" -> bag.usePower(this)
                        else -> {
                            println(
                                pintTextBag("Enter a number between 1 and 5")
                            )
                            selectingAttackType(opponent, bag)
                        }
                    }
                }
            }
            else -> {
                println(pintTextBag("Enter a number between 1 and 5"))
                selectingAttackType(opponent, bag)
            }
        }
    }
}
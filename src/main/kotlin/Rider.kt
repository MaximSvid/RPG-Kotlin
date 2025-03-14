class Rider(name: String, health: Double) : Character(name, health) {

    var countSuperStrongAttack: Int = 3 // Anzahl der verfügbaren superstarken Angriffe

    // Normaler Angriff mit dem Reiter, verursacht 30 Schaden
    private fun riderAttack(opponent: Opponent) {
        val attack = 30
        val modifiedAttack = (attack * attackFactor).toInt()
        println(yellowTextRider("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with a rider on horseback"))
        super.attackCharacter(opponent, modifiedAttack)
    }

    // Aktiviert den Schild, überschreibt die Methode der Oberklasse
    override fun activateShield() {
        super.activateShield()
    }

    // Superstarker Angriff mit 60 Schaden, begrenzt auf 3 Anwendungen
    private fun superStrongRiderAttack(opponent: Opponent) {
        if (countSuperStrongAttack > 0) {
            val attack = 60
            println(yellowTextRider("Current health of ${opponent.name} is ${opponent.health}. ${this.name} unleashed a Thunderous Charge!"))
            super.attackCharacter(opponent, attack)
            countSuperStrongAttack --
        } else {
            println(yellowTextRider("No Thunderous Charges left! Use a regular attack instead."))
        }

    }

    // Starke Heilung, stellt 50 Gesundheitspunkte wieder her
    private fun superRiderHealth(character: Character) {
        val points = 50
        println(yellowTextRider("The state of health ${character.name} is equal to ${character.health}. A SUPER treatment was utilized."))
        super.healthCharacter(character, points)
    }

    // Wählt den Angriffstyp aus und zeigt die Optionen in der Konsole an
    override fun selectingAttackType(opponent: Opponent, bag: Bag) {
        println(
            yellowTextRider(
                """ RIDER ATTACKED...
                Rider health status: $health HP
                Select the type of attack...
                [1] - Normal Attack 
                ${
                    if (countSuperStrongAttack <= 0) {
                        "[2] - Thunderous Charge (No charges left!)"
                    } else {
                        "[2] - Thunderous Charge (Charges remaining: $countSuperStrongAttack)"
                    }
                }
                [3] - Activate Shield
                [4] - Enhanced treatment 
                ${if (!bag.isUsedBag) {
                    "[5] - Bag"
                } else {
                    "The bag has already been used in this round"
                }
                }
            """.trimIndent()
            )
        )
        val choiceAttack = readln()
        when (choiceAttack) {
            "1" -> riderAttack(opponent)
            "2" -> {
                if (countSuperStrongAttack <= 0) {
                    println(yellowTextRider("No Thunderous Charges left! Choose another action."))
                    selectingAttackType(opponent, bag)
                } else {
                    superStrongRiderAttack(opponent)
                }
            }
            "3" -> {
                if (!isShieldActive) {
                    println(yellowTextRider("$name raised their shield! Incoming damage will be reduced by 80%."))
                    isShieldActive = true
                } else {
                    println(yellowTextRider("$name's shield is already active!"))
                    selectingAttackType(opponent, bag)
                }
            }
            "4" -> superRiderHealth(this)
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
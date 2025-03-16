class Archer(name: String, health: Double) : Character(name, health) {
    var arrowCount: Int = 3

    // Normaler Angriff, verursacht 10 Schaden (modifiziert durch attackFactor)
    private fun archerAttack(opponent: Opponent) {
        val attack = 10
        val modifiedAttack = (attack * attackFactor).toInt()
        println(greenTextArcher("Current health status ${opponent.name} is ${opponent.health}. ${this.name} attacked with his bow"))
        //In Kotlin wird das Wort super verwendet, um auf Methoden oder Eigenschaften der Elternklasse (Superklasse) zuzugreifen.
        super.attackCharacter(opponent, modifiedAttack)
    }

    // Angriff mit drei Pfeilen, die Anzahl der Pfeile ist begrenzt
    private fun multiShot(opponent: Opponent, arrowsToShot: Int = 3) {
        if (arrowCount < arrowsToShot) {
            println(greenTextArcher("$name doesn't have enough arrows for multi-shot!"))
            return
        }
        repeat(arrowsToShot) {
            if (arrowCount > 0 && opponent.health > 0) {
                archerAttack(opponent)
                arrowCount--
            }
        }
    }

    // Aktiviert den Schild, überschreibt die Methode der Oberklasse
    override fun activateShield() {
        super.activateShield()
        println(greenTextArcher("Archer activated shield..."))
    }


    // Starke Heilung, stellt 35 Gesundheitspunkte wieder her
    private fun superArcherHealth(character: Character) {
        val points = 35
        println(greenTextArcher("The state of health ${character.name} is equal to ${character.health}. A SUPER treatment was utilized."))
        super.healthCharacter(character, points)
    }

    override fun selectingAttackType(opponent: Opponent, bag: Bag) {
        println(
            greenTextArcher(
                """ ARCHER ATTACKED...
                Archer health status: $health HP 
                Select the type of attack...
                [1] - Single Shot 
                ${
                    if (arrowCount < 3) {
                        "[2] - Arrow Barrage (No arrows left! Refill in the bag...)"
                    } else {
                        "[2] - Arrow Barrage (Arrows remaining: $arrowCount)"
                    }
                }
                [3] - Activate Shield 
                [4] - Recovery
                ${
                    if (!bag.isUsedBag) { "[5] - Bag"
                    } else {
                        "The bag has already been used in this round"
                    }
                }
            """.trimIndent()
            )
        )
        val choiceAttack = readln()
        when (choiceAttack) {
            "1" -> archerAttack(opponent)
            //when die anzahl von arrows ist 0 oder weniger Benutzer kann nicht Angreifen machen
            "2" -> {
                if (arrowCount < 3) {
                    println(greenTextArcher("No arrows left! Refill your quiver using the bag."))
                    selectingAttackType(opponent, bag) // rufen die fun selectingAttackType noch mal
                } else {
                    multiShot(opponent)
                }
            }

            "3" ->  {
                if (!isShieldActive) {
                    println(greenTextArcher("$name raised their shield! Incoming damage will be reduced by 80%."))
                    isShieldActive = true
                } else {
                    println(greenTextArcher("$name's shield is already active!"))
                    selectingAttackType(opponent, bag)
                }
            }
            "4" -> superArcherHealth(this)
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
                     [3] - Refill arrows 
                """.trimIndent()
                        )
                    )
                    val choiceBag = readln()
                    when (choiceBag) {
                        "1" -> bag.useMedicine(this)
                        "2" -> bag.usePower(this)
                        "3" -> bag.restockArrowsForArcher(this)
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

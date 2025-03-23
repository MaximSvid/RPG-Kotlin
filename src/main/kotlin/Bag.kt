open class Bag() {

    var isUsedBag: Boolean = false

    var amountOfMedicine: Int = 4
    var amountOfPower: Int = 2
    var amountOfArrows: Int = Int.MAX_VALUE // 2,147,483,647

//  Verwende Medizin für einen Charakter
    fun useMedicine(character: Character) {
        //In Kotlin ist if eine Kontrollstruktur, die verwendet wird, um Bedingungen zu überprüfen und abhängig vom Ergebnis bestimmten Code auszuführen.
        if (!isUsedBag) {
            if (amountOfMedicine > 0) {
                character.health += character.originHP / 2
                amountOfMedicine--
                isUsedBag = true
                println(pintTextBag("${character.name} health has been increased by half and now equals ${character.health} "))
                println(pintTextBag("The amount of drug in the sum is equal to $amountOfMedicine items"))
                println(pintTextBag("-----------------------"))
            } else {
                println(pintTextBag("The Cure bag is empty"))
            }

        } else {
            println(pintTextBag("The bag has already been used this turn"))
        }
    }

    // Verstärke die Kraft eines Charakters
    fun usePower(character: Character) {
        if (!isUsedBag) {
            if (amountOfPower > 0) {
                character.attackFactor *= 1.1
                amountOfPower--
                isUsedBag = true
                println(pintTextBag("${character.name} strength has been increased by 10 percent"))
                println(pintTextBag("-------------------------------------------------"))
            } else {
                println(pintTextBag("The Cure bag is empty"))
            }
        } else {
            println(pintTextBag("The bag has already been used this turn"))
        }

    }

    // Fülle Pfeile für einen Bogenschützen nach
    fun restockArrowsForArcher(archer: Archer, amount: Int = 6) {
        if (!isUsedBag) {
            archer.arrowCount += amount
            isUsedBag = true
            println(pintTextBag("$amount arrows added to ${archer.name}'s quiver. Total arrows: ${archer.arrowCount}"))
            println(pintTextBag("-------------------------------------------------"))
        } else {
            println(pintTextBag("The bag has already been used this turn"))
        }
    }

    // Fülle Klingensturm für einen Schwertkämpfer nach
    fun restockSwordsmanBladestorm (swordsman: Swordsman, amount: Int = 3) {
        if (!isUsedBag) {
            swordsman.countSuperStrongAttackOfSwordsman += amount
            isUsedBag = true
            println(blueTextSwordsman("$amount bladestorm charges added to ${swordsman.name}. Total charges: ${swordsman.countSuperStrongAttackOfSwordsman}"))
            println(blueTextSwordsman("-------------------------------------------------"))
        } else {
            println(blueTextSwordsman("The bag has already been used this turn"))
        }
    }

    // Fülle Donnerschlag für einen Reiter nach
    fun restockRiderThunderousCharge (rider: Rider, amount: Int = 3) {
        if (!isUsedBag) {
            rider.countSuperStrongAttack += amount
            isUsedBag = true
            println(yellowTextRider("$amount thunderous charges added to ${rider.name}. Total charges: ${rider.countSuperStrongAttack}"))
            println(yellowTextRider("-------------------------------------------------"))
        } else {
            println(yellowTextRider("The bag has already been used this turn"))
        }
    }

    fun resetBagUse() {
        isUsedBag = false
    }
}
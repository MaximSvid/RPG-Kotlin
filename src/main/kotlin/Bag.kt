open class Bag() {

    var isUsedBag: Boolean = false

    var amountOfMedicine: Int = 4
    var amountOfPower: Int = 1

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
//
    fun usePower (character: Character) {
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

    fun resetBagUse() {
        isUsedBag = false
    }




}
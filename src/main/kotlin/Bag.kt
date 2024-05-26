open class Bag() {

    var isUsedBag: Boolean = false

    var amountOfMedicine: Int = 4
    var amountOfPower: Int = 1


    fun useMedicine(character: Character) {
        if (!isUsedBag) {
            if (amountOfMedicine > 0) {
                character.health += character.originHP / 2
                amountOfMedicine--
                isUsedBag = true
                var bagMedicineSize = amountOfMedicine
                println("${character.name} health has been increased by half and now equals ${character.health} ")
                println("The amount of drug in the sum is equal to $bagMedicineSize items")
                println("-----------------------")
            } else {
                println("The Cure bag is empty")
            }

        } else {
            println("The bag has already been used this turn")
        }
    }

    fun usePower (character: Character) {
        if (!isUsedBag) {
            if (amountOfPower > 0) {
                character.attackFactor *= 1.1
                amountOfPower--
                isUsedBag = true
                println("${character.name} strength has been increased by 10 percent")
                println("-------------------------------------------------")
            } else {
                println("The Cure bag is empty")
            }
        } else {
            println("The bag has already been used this turn")
        }

    }

    fun resetBagUse() {
        isUsedBag = false
    }




}
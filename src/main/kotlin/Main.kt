fun main() {
    var warrior1 = Swordsman("Swordsman", 100.0)
    var warrior2 = Rider("Rider", 120.0)
    var warrior3 = Archer("Archer", 70.0)
    var warrior4: CommonOpponent = CommonOpponent("CommonEnemy", 200.0)
    var warrior5: Opponent = StrongOpponent("StrongEnemy", 180.0)

    var characterList: MutableList<Character> = mutableListOf(warrior1, warrior2, warrior3)
    var opponentList: MutableList<Opponent> = mutableListOf(warrior4)

    var bag = Bag()


    fun playRound (characterList: MutableList<Character>, opponentList: MutableList<Opponent>, bag: Bag) {
        var roundNumber: Int = 1
        while (characterList.isNotEmpty() || opponentList.isNotEmpty()) {
            println("---Round number $roundNumber---")

            //hero1
            println("Character's turn:")
            start(characterList, opponentList, bag)

            println("-------------------------------")
            println("Opponent's turn:")
            warrior4.randomCommonOpponentAttack(characterList)

            println("-------------------------------")
            //hero2
            println("Character's turn:")
            start(characterList, opponentList, bag)

            println("-------------------------------")
            println("Opponent's turn:")
            warrior4.randomCommonOpponentAttack(characterList)

            println("-------------------------------")
            //hero3
            println("Character's turn:")
            start(characterList, opponentList, bag)

            println("-------------------------------")
            println("Opponent's turn:")
            warrior4.randomCommonOpponentAttack(characterList)

            bag.resetBagUse()

            roundNumber++
        }
    }
    playRound(characterList, opponentList, bag)










}
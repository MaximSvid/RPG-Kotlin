fun main() {
    var warrior1 = Swordsman("Swordsman", 100.0)
    var warrior2 = Rider("Rider", 120.0)
    var warrior3 = Archer("Archer", 70.0)
    var warrior4: CommonOpponent = CommonOpponent("CommonEnemy", 200.0)
    var warrior5: Opponent = StrongOpponent("StrongEnemy", 180.0)

    var characterList: MutableList<Character> = mutableListOf(warrior1, warrior2, warrior3)
    var opponentList: MutableList<Opponent> = mutableListOf(warrior4)

//   warrior1.swordAttack(warrior4)
////
////    warrior1.superSwordHealth(warrior2)
//
//    val bag = Bag ()
//    val commonOpponent: CommonOpponent
//    bag.useMedicine(warrior2)
//    bag.usePower(warrior3)
//    warrior4.attackOnAllWarriors(characterList)
//    warrior4.attackOnAllWarriors(characterList)
//    warrior4.attackOnAllWarriors(characterList)
//    warrior4.attackOnAllWarriors(characterList)
//    warrior4.attackOnAllWarriors(characterList)
//    warrior4.attackOnAllWarriors(characterList)
//    warrior4.attackOnAllWarriors(characterList)
//    warrior4.attackOnAllWarriors(characterList)
//    warrior4.attackOnAllWarriors(characterList)
//    warrior4.attackOnAllWarriors(characterList)
//    warrior4.attackOnAllWarriors(characterList)
//    warrior4.attackOnAllWarriors(characterList)
//    warrior4.attackOnAllWarriors(characterList)
//    warrior4.attackOnAllWarriors(characterList)
    warrior4.attackOnAllWarriors(characterList)
    warrior4.attackOnAllWarriors(characterList)
    warrior4.inTheHospital(warrior1)
    warrior4.reduceHealthByHospital(warrior1)
    warrior4.reduceHealthByHospital(warrior1)
    warrior4.reduceHealthByHospital(warrior1)
    warrior4.reduceHealthByHospital(warrior1)
    warrior4.reduceHealthByHospital(warrior1)
    warrior4.reduceHealthByHospital(warrior1)
    warrior4.reduceHealthByHospital(warrior1)








}
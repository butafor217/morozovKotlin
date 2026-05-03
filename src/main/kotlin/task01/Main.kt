package task01

//
//
//fun printWelcome() {
//    println("Добро пожаловать в систему героев!")
//}
//
//fun printHeroName(name: String) {
//    println("Имя героя: $name")
//}
//
//fun describeHero(name: String, heroClass: String, level: Int) {
//    println("Класс: $heroClass")
//    println("Уровень: $level")
//    println("Описание: Герой $name класса $heroClass на уровне $level")
//}
//
//fun showHeroStats(name: String, heroClass: String = "Воин", level: Int = 1) {
//    println("[$name | $heroClass | Уровень: $level]")
//}
//
//fun quickPower(strength: Int, agility: Int) = strength * 3 + agility * 2
//
//

fun main() {
    printTitle("ДОБРО ПОЖАЛОВАТЬ В ИГРУ")
    print("\n Герой: $heroName | Уровень: $heroLevel | Золото: $heroGold")

// Игровые события
    print(greetHero(heroName))
    attackLog(heroName, 85)
    print("\nКритический удар! Урон: ${calculateDamage(85, 2)}")
    executeEvent(heroName) { name -> println("$name использует Меткий выстрел!") }

// Экраны игры (будут пунктами меню)
    printHeroCard()
    printStats()
    printCombatInfo()
    printInventory()
    printShop()
    printResources()
    printSkills()

// Учебные демонстрации (удалим при переходе на ООР)
    demoLists()
    demoMap()
    demoSet()
    demoGroupBy()

// TODO: следующая практическая – заменить весь этот код на while-меню:
//    while (true) {
//        printTitle("ГЛАВНОЕ МЕНЮ")
//        println("1. Арена")
//        println("2. Инвентарь")
//        println("3. Магазин")
//        println("4. Характеристики")
//        println("5. Выход")
//    }

    println("\nИгра завершена. До встречи!")
}
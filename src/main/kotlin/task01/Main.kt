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
    // Приветствие — один раз при запуске
    println("ДОБРО ПОЖАЛОВАТЬ В ИГРУ")
    println(" Герой: $heroName | Уровень: $heroLevel | Золото: $heroGold")
    println(greetHero(heroName))
    attackLog(heroName, 85)
    pressAnyKey()

    // Главное меню — while-цикл
    var running = true
    while (running) {
        println("ГЛАВНОЕ МЕНЮ")
        printBar("HP ", heroHp, heroMaxHp)
        printBar("Мана", heroMana, heroMaxMana)
        println("Золото: $heroGold | Уровень: $heroLevel | Опыт: $heroExp\n")
        println("1. Карточка героя")
        println("2. Характеристики")
        println("3. Арена")
        println("4. Инвентарь")
        println("5. Магазин")
        println("6. Отдых")
        println("7. Ресурсы")
        println("8. Навыки")
        println("9. Выход")

        when (readChoice(9)) {
            1 -> printHeroCard()
            2 -> printStats()
            3 -> arenaMenu()
            4 -> inventoryMenu()
            5 -> shopMenu()
            6 -> rest()
            7 -> printResources()
            8 -> printSkills()
            9 -> running = false
        }

        if (running) pressAnyKey()
    }

    println("\nДо встречи, $heroName!")
}

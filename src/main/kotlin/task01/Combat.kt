package task01

fun attackByClass(heroClass: String) {
    when (heroClass) {
        "Лучница" -> println("Выпускает град стрел!")
        "Воин" -> println("Наносит мощный удар мечом!")
        "Мар" -> println("Проклинает врага заклинанием!")
        else -> println("Атакует как может!")
    }
}



fun battleOutcome(hp: Int, enemyHp: Int, mana: Int) {
    when {
        hp <= 0 -> println("Поражение: герой пал в бою!")
        enemyHp <= 0 -> println("Победа: враг повержен!")
        hp > 0 && mana >= 30 -> println("Бой продолжается: ультимативная атака доступна!")
        hp > 0 && mana < 30 -> println("Бой продолжается: экономь ману!")
        else -> println("Неизвестный исход...")
    }
}

fun printCombatInfo() {
    println("БОЕВАЯ ИНФОРМАЦИЯ")
    println("Класс: $heroClass")
    printSection("Атака")
    attackByClass(heroClass)
    println("Сила удара: ${heroPower()}")
    println("Урон (85x2): ${calculateDamage(85, 2)}")
    printSection("Звание")
    heroTier(heroLevel)
    println("Звание: ${getHeroTitle(heroLevel)}")
    heroRank(heroLevel)
    printSection("Примеры исхода боя")
    battleOutcome(50, 0, 20)
    battleOutcome(10, 30, 50)
    battleOutcome(0, 80, 100)
}
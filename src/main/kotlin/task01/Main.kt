package task01

val greetHero: (String) -> String = { name -> "Привет, $name! Готов к приключениям?" }

val attackLog: (String, Int) -> Unit = { name, damage ->
    println("$name наносит $damage единиц урона!")
}

val calculateDamage: (Int, Int) -> Int = { power, multiplier -> power * multiplier }

fun printWelcome() {
    println("Добро пожаловать в систему героев!")
}

fun printHeroName(name: String) {
    println("Имя героя: $name")
}

fun describeHero(name: String, heroClass: String, level: Int) {
    println("Класс: $heroClass")
    println("Уровень: $level")
    println("Описание: Герой $name класса $heroClass на уровне $level")
}

fun showHeroStats(name: String, heroClass: String = "Воин", level: Int = 1) {
    println("[$name | $heroClass | Уровень: $level]")
}

fun calculatePower(strength: Int, agility: Int): Int {
    return strength * 3 + agility * 2
}

fun quickPower(strength: Int, agility: Int) = strength * 3 + agility * 2

fun executeEvent(heroName: String, event: (String) -> Unit) {
    println("--- Событие для $heroName ---")
    event(heroName)
}

fun checkLevel(level: Int) {
    if (level >= 10) {
        println("Герой опытный — уровень $level")
    }
}

fun checkHealth(hp: Int) {
    if (hp > 0) {
        println("Герой жив — HP: $hp")
    } else {
        println("Герой повержен!")
    }
}

fun heroRank(level: Int) {
    if (level >= 20) {
        println("Ранг: Легенда")
    } else if (level >= 10) {
        println("Ранг: Ветеран")
    } else if (level >= 5) {
        println("Ранг: Боец")
    } else {
        println("Ранг: Новичок")
    }
}

fun canUseSkill(hp: Int, mana: Int) {
    if (hp > 0 && mana >= 20) {
        println("Умение доступно — HP: $hp, Мана: $mana")
    } else {
        println("Умение недоступно — HP: $hp, Мана: $mana")
    }
}

fun attackByClass(heroClass: String) {
    when (heroClass) {
        "Лучница" -> println("Выпускает град стрел!")
        "Воин" -> println("Наносит мощный удар мечом!")
        "Мар" -> println("Проклинает врага заклинанием!")
        else -> println("Атакует как может!")
    }
}

fun heroTier(level: Int) {
    when (level) {
        in 1..4 -> println("Тир: Новичок")
        in 5..9 -> println("Тир: Обычный")
        in 10..19 -> println("Тир: Редкий")
        in 20..29 -> println("Тир: Эпический")
        else -> println("Тир: Мифический")
    }
}

fun getHeroTitle(level: Int): String {
    return when {
        level >= 25 -> "Владыка рун"
        level >= 15 -> "Страж порядка"
        level >= 10 -> "Опытный следопыт"
        else -> "Юный искатель"
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

fun main() {
    println("== КАРТОЧКА ГЕРОЯ ==")
    printWelcome()
    printHeroName("Артемида")
    describeHero("Артемида", "Лучница", 15)
    describeHero(level = 20, heroClass = "Воин", name = "Top")
    showHeroStats("Новичок")
    showHeroStats("Артемида", "Лучница", 15)
    val power = calculatePower(10, 15)
    println("Сила удара: $power")
    val qp = quickPower(10, 15)
    println("Краткий расчёт: $qp")
    println(greetHero("Артемида"))
    val skills = listOf("Меткий выстрел", "Уклонение", "Охота в темноте")
    println("Навыки героя:")
    skills.forEach { println("- $it") }
    attackLog("Артемида", 85)
    val result = calculateDamage(85, 2)
    println("Критический удар! Итоговый урон: $result")
    executeEvent("Артемида", { name -> println("$name использует Меткий выстрел!") })
    executeEvent("Top", { name -> println("$name использует Удар молнии!") })
    executeEvent("Артемида") { name ->
        println("$name принимает защитную стойку!")
    }
    checkLevel(15)
    checkLevel(5)
    checkHealth(75)
    checkHealth(0)
    heroRank(25)
    heroRank(12)
    heroRank(6)
    heroRank(2)
    canUseSkill(80, 30)
    canUseSkill(80, 5)
    canUseSkill(0, 50)
    attackByClass("Лучница")
    attackByClass("Mar")
    attackByClass("Воин")
    heroTier(3)
    heroTier(12)
    heroTier(25)
    val title = getHeroTitle(15)
    println("Звание: $title")
    battleOutcome(50, 0, 20)
    battleOutcome(10, 30, 50)
    battleOutcome(0, 80, 100)
    println("== КОНЕЦ КАРТОЧКИ ==")
}
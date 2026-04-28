package task01

fun printWelcome() {
    println("Добро пожаловать в систему героев!")
}

fun printHeroName(name: String) {
    println("Имя героя: $name")
}

fun describeHero(name: String, heroClass: String, level: Int) {
    println("Класс: $heroClass")
    println("Уровень: $heroClass")
    println("Описание: Герой $name класса $heroClass на уровне $level")
}

fun showHeroStats(name: String, heroClass: String = "Воин", level: Int = 1) {
    println("[$name | $heroClass | Уровень: $level]")
}

fun calculatePower(strength: Int, agility: Int): Int {
    return strength * 3 + agility * 2
}

fun quickPower(strength: Int, agility: Int) = strength * 3 + agility * 2

fun main() {
    println("===Карточка героя===")
    printWelcome()
    printHeroName("Артемида")
    describeHero("Артемида", "Лучница", 15)
    describeHero(level = 20, heroClass = "Воин", name = "Top")
    showHeroStats("Новичок")
    showHeroStats("Артемида", "Лучница", 15)
    val power = calculatePower(10, 15)
    println("Сила удара: $power")
    val qp = quickPower(10, 15)
    println("Краткий расчет: $qp")
    println("=== Конец карточки ===")
}


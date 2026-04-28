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

val greetHero: (String) -> String = {name -> "Привет, $name! Готов к приключениям?" }

val attackLog: (String, Int) -> Unit = {name, damage ->
    println("$name наносит $damage единиц урона!")
}

val calculateDamage: (Int, Int) -> Int = {power, multiplier -> power * multiplier}

fun executeEvent(heroName: String, event: (String) -> Unit) {
    println("--- Событие для $heroName ---")
    event(heroName)
}

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
    println(greetHero("Артемида"))
    val skills = listOf("Меткий выстрел", "Уклонение", "Охота в темноте")
    println("Навыки героя:")
    skills.forEach { println("- $it") }
    attackLog("Артемида", 85)
    var result = calculateDamage(85, 2)
    executeEvent("Артемида", {name -> println("$name использует Меткий выстрел!")})
    executeEvent("Тор", {name -> println("$name исполользует Удар молнии!") })
    executeEvent("Артемида") { name ->
        println("$name принимает защитную стойку!")
    }
    println("Критический удар! Итоговый урон: $result")
    println("=== Конец карточки ===")
}


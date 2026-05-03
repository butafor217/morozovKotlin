package task01

val heroName = "Артемида"
val heroClass = "Лучница"
var heroLevel = 15
var heroHp = 100
var heroMaxHp = 100
var heroMana = 50
var heroGold = 200

var heroMaxMana = 50
var heroExp = 0
val isAlive: Boolean get() = heroHp > 0

val greetHero: (String) -> String = { name -> "Привет, $name! Готов к приключениям?" }

val attackLog: (String, Int) -> Unit = { name, damage ->
    println("$name наносит $damage единиц урона!")
}

val calculateDamage: (Int, Int) -> Int = { power, multiplier -> power * multiplier }


val heroStats = mutableMapOf(
    "сила" to 10,
    "ловкость" to 15,
    "интеллект" to 8,
    "выносливость" to 20,
    "удача" to 5
)

fun calculatePower(strength: Int, agility: Int): Int {
    return strength * 3 + agility * 2
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

fun heroPower(): Int {
    val strength = heroStats["сила"] ?: 0
    val agility = heroStats["ловкость"] ?: 0
    return calculatePower(strength, agility)
}

fun heal(amount: Int) {
    heroHp = minOf(heroHp + amount, heroMaxHp)
    println(" Исцеление +$amount HP")
}

fun printHeroCard() {
    println("КАРТОЧКА ГЕРОЯ")
    println("Имя: $heroName")
    println("Класс: $heroClass")
    println("Уровень: $heroLevel")
    println("HP: $heroHp / $heroMaxHp")
    println("Мана: $heroMana")
    println("Золото: $heroGold")
    printSection("Характеристики")
    heroStats.forEach { (stat, value) ->
        println(" $stat: $value")
    }
}

fun printStats() {
    println("ХАРАКТЕРИСТИКИ")
    println("Уровень: $heroLevel")
    checkLevel(heroLevel)
    heroTier(heroLevel)
    println("Звание: ${getHeroTitle(heroLevel)}")
    heroRank(heroLevel)
    checkHealth(heroHp)
    canUseSkill(heroHp, heroMana)
    println("Сила удара: ${heroPower()}")
    println("Золото: $heroGold")
}

fun takeDamage(amount: Int) {
    heroHp = maxOf(heroHp - amount, 0)
}

fun restoreMana(amount: Int) {
    heroMana = minOf(heroMana + amount, heroMaxMana)
    println(" Мана +$amount")
}

fun rest() {
    println("Отдых")
    printBar("HP", heroHp, heroMaxHp)
    printBar("Мана", heroMana, heroMaxMana)
    println("Опыт:    $heroExp")

    if (heroHp == heroMaxHp && heroMana == heroMaxMana) {
        println("Ты полностью отдохнул. Нечего восстанавливать.")
        return
    }

    println("\nОтдыхаешь у костра...")
    var ticks = 0
    while (heroHp < heroMaxHp || heroMana < heroMaxMana) {
        ticks++
        if (heroHp < heroMaxHp) heroHp = minOf(heroHp + 10, heroMaxHp)
        if (heroMana < heroMaxMana) heroMana = minOf(heroMana + 8, heroMaxMana)
        print(" Тик $ticks: ")
        printBar("#", heroHp, heroMaxHp, 8)
    }
    println("Полностью восстановлен за $ticks тиков!")
}

fun gainExp(amount: Int) {
    heroExp += amount
    println(" Получено $amount опыта (всего: $heroExp)")


    val newLevel = 1 + heroExp / 100
    if (newLevel > heroLevel) {
        for (lvl in (heroLevel + 1)..newLevel) {
            println(" ★ уровень $lvl!")
            heroLevel = lvl
            heroMaxHp += 10
            heroMaxMana += 5
            heroHp = heroMaxHp
            heroMana = heroMaxMana
        }
    }
}

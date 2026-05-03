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

fun arenaBattle() {
    // — Выбор случайного врага из Set —
    val enemyList = uniqueEnemies.toList()
    val enemyIndex = rand(0, enemyList.size - 1)
    var enemyName = ""
    for ((i, name) in enemyList.withIndex()) {
        if (i == enemyIndex) {
            enemyName = name
            break
        }
    }

    var enemyHp = rand(30 + heroLevel * 3, 50 + heroLevel * 5)
    val enemyMaxHp = enemyHp
    val enemyPower = rand(5 + heroLevel, 10 + heroLevel * 2)
    val enemyReward = rand(15 + heroLevel * 2, 30 + heroLevel * 4)

    println("АРЕНА: БОЙ")
    println("Противник: $enemyName")
    printBar("Враг ", enemyHp, enemyMaxHp)
    println("Сила врага: ~$enemyPower | Награда: ~$enemyReward золота")

    val battleLog = mutableListOf<String>()
    battleLog.add("Начался бой с $enemyName")

    // — Основной боевой цикл while —
    var round = 0
    while (heroHp > 0 && enemyHp > 0) {
        round++
        printSection("Раунд $round")
        printBar("$heroName ", heroHp, heroMaxHp)
        printBar("$enemyName ", enemyHp, enemyMaxHp)
        println("Мана: $heroMana/$heroMaxMana | Золото: $heroGold")
        println("\n1. Атака    2. Навык (-30 маны)")
        println("3. Исцеление    0. Отступить")
        val action = readChoice(3)

        when (action) {
            1 -> {
                val damage = rand(heroPower(), heroPower() * 2)
                enemyHp = maxOf(enemyHp - damage, 0)
                val msg = "$heroName атакует! → $damage урона"
                println(" $msg")
                battleLog.add("P$round: $msg")
            }
            2 -> {
                if (heroMana < 30) {
                    println(" Мало маны! Ход пропущен.")
                    battleLog.add("P$round: не хватило маны")
                    continue
                }
                heroMana -= 30
                val damage = heroPower() * 2 + rand(0, heroLevel)
                enemyHp = maxOf(enemyHp - damage, 0)
                val msg = "$heroName применяет навык! → $damage урона!"
                println(" $msg")
                battleLog.add("P$round: $msg")
            }
            3 -> {
                val healAamt = rand(15, 30)
                heal(healAamt)
                battleLog.add("p$round: исцеление +$healAamt HP")
            }
            0 -> {
                println(" Отступление!")
                battleLog.add("p$round: отступление")
                break
            }
        }

        if (enemyHp <= 0) {
            println("\n ★ $enemyName повержен! ★")
            heroGold += enemyReward
            val expGain = rand(20, 40 + heroLevel * 2)
            gainExp(expGain)
            battleLog.add("победа! +$enemyReward золота, +$expGain опыта")
            break
        }

        val enemyDmg = rand(enemyPower / 2, enemyPower)
        takeDamage(enemyDmg)
        battleLog.add("p$round: $enemyName атакует → $enemyDmg урона")

        if (heroHp <= 0) {
            println("\n X $heroName пал в бою...")
            val lostGold = heroGold / 4
            heroGold -= lostGold
            battleLog.add("Поражение. Потеряно $lostGold золота")
            break
        }
    }

    // — Журнал боя: for с индексами
    printSection("Журнал боя")
    for ((i, entry) in battleLog.withIndex()) {
        println(" ${i + 1}. $entry")
    }

    heroHp = minOf(heroHp + 10, heroMaxHp)
    heroMana = minOf(heroMana + 5, heroMaxMana)
    println("\nПосле боя: HP +10, Мана +5")
}

fun arenaMenu() {
    var fighting = true
    while (fighting) {
        printTitle("АРЕНА")
        printBar("HP ", heroHp, heroMaxHp)
        printBar("Мана", heroMana, heroMaxMana)
        println("Золото: $heroGold")
        println("\n1. В бой!    0. Назад")
        when (readChoice(1)) {
            1 -> {
                if (!isAlive) println("Сначала нужно отдохнуть — HP = 0!")
                else arenaBattle()
            }
            0 -> fighting = false
        }
    }
}
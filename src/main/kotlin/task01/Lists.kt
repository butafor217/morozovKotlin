package task01

fun main() {
    println("=== Инвентарь героя ===")
    val inventory = listOf("Меч", "Щит", "Лук", "Зелье здоровья", "Факел")
    val skills: List<String> = listOf("Меткий выстрел", "Уклонение", "Охота в темноте")
    val statValues: List<Int> = listOf(10, 15, 8, 20)
    val heroInfo: List<Any> = listOf("Артемида", 15, true, 9.81)

    println("--- Типизированные списки ---")
    println("Навыков: ${skills.size}, первый: ${skills[0]}")
    println("Характеристик: ${statValues.size}, макс: ${statValues.max()}")

    println("--- Any-список ---")
    println("Элемент 0: ${heroInfo[0]}")
    println("Элемент 1: ${heroInfo[1]}")

    val first = heroInfo[0]
    if (first is String) {
        println("Имя в верхнем регистре: ${first.uppercase()}")
    }
    val second = heroInfo[1]
    if (second is Int) {
        println("Уровень плюс десять: ${second + 10}")
    }
    println("--- Инвентарь ---")
    println("Всего предметов: ${inventory.size}")
    println("Первый: ${inventory[0]}")
    println("Последний: ${inventory.last()}")
    println("Третий (индекс 2): ${inventory[2]}")
    println("Через get: ${inventory.get(1)}")

    val bag = mutableListOf("Хлеб", "Верёвка", "Фонарь")

    println("--- Сумка (начало) ---")
    println(bag)

    bag.add("Зелье силы")    // добавить в конец
    bag.add(0, "Меч")    // вставить в начало по индексу 0

    println("--- После добавления ---")
    println(bag)

    bag[2] = "Щит"    // заменить третий элемент (индекс 2)
    bag.set(3, "Зелье здоровья")   // заменить через метод

    println("--- После замены ---")
    println(bag)

    bag.remove("Фонарь")    // удалить по значению
    bag.removeAt(0)    // удалить первый элемент

    println("--- После удаления ---")
    println(bag)
    println("Предметов: ${bag.size}")

    val loot = listOf("Золото", "Рубин", "Золото", "Сапфир", "Золото")

    println("--- Работа с индексами ---")
    println("Элемент [1]: ${loot[1]}")
    println("Элемент [3]: ${loot.get(3)}")
    println("Индекс 'Рубин': ${loot.indexOf("Рубин")}")
    println("Первый 'Золото': ${loot.indexOf("Золото")}")
    println("Последний 'Золото': ${loot.lastIndexOf("Золото")}")
    println("Диапазон: ${loot.indices}")

    println("Элемент [10]: ${loot.getOrNull(10)}")
    println("С дефолтом: ${loot.getOrNull(10) ?: "нет такого"}")

    println("--- Добыча с номерами ---")
    loot.withIndex().forEach { (index, item) ->
        println("[${index}] $item")
    }

    val required = listOf("Ключ от подземелья", "Факел", "Верёвка")
    val heroInv = listOf("Ключ от подземелья", "Факел", "Зелье", "Меч")

    println("--- Проверка снаряжения ---")
    println("Ключ есть: ${"Ключ от подземелья" in heroInv}")  // двойные кавычки
    println("Верёвка есть: ${"Верёвка" in heroInv}")
    println("Щит отсутствует: ${"Щит" !in heroInv}")
    println("Все нужные предметы: ${heroInv.containsAll(required)}")

    println("--- Чек-лист ---")
    required.forEach { item ->
        val status = if (item in heroInv) "✔" else "❌ нет"
        println("$item: $status")
    }

    val power = 75
    println("--- Уровень мощи ---")
    println("Мощь в норме (50-100): ${power in 50..100}")
    println("Мощь критична (<50): ${power !in 50..200}")

    val readiness = when {
        heroInv.containsAll(required) -> "Полностью готов"
        "Ключ от подземелья" in heroInv -> "Нужно ещё кое-что"
        else -> "Не готов"
    }
    println("Статус: $readiness")

    val potions = listOf("Зелье здоровья", "Зелье силы", "Зелье невидимости", "Зелье скорости")
    val power2 = listOf(50, 30, 0, 20)

    println("--- forEach: список зелий ---")
    potions.forEach { println("• $it") }

    println("--- forEachIndexed: с номерами ---")
    potions.forEachIndexed { index, potion ->
        println("${index + 1}. $potion (сила: ${power2[index]})")
    }

    println("--- foreach с условием ---")
    potions.forEach { potion ->
        if ("здоровья" in potion) {
            println("Целебное: $potion")
        } else {
            println("Прочее: $potion")
        }
    }

    val allItems = listOf("Меч", "Яблоко", "Щит", "Хлеб", "Зелье", "Лук", "Мясо", "Кинжал")
    val itemPrices = listOf(100, 5, 80, 3, 50, 60, 8, 90)

    println("--- filter ---")
    val expensive = itemPrices.filter { it > 50 }
    println("Цены дороже 50: $expensive")

    val longNames = allItems.filter { it.length > 4 }
    println("Длинные названия: $longNames")

    val notShort = allItems.filterNot { it.length <= 4 }
    println("Не короткие: $notShort")

    val evenItems = allItems.filterIndexed { index, _ -> index % 2 == 0 }
    println("Чётные позиции: $evenItems")

    val midRange = itemPrices.filter { it > 20 }.filter { it <= 80 }
    println("Средняя цена (21-80): $midRange")

    println("Дорогих предметов: ${expensive.size}")

    val heroLevels = listOf(5, 12, 3, 20, 8, 15)
    val heroNames = listOf("Артемида", "Top", "Гвен", "Рэй", "Лира")

    println("--- map: трансформация ---")
    val bonuses = heroLevels.map { it * 10 }
    println("Бонусы опыта: $bonuses")

    val labels = heroLevels.map { "ур. $it" }
    println("Метки уровней: $labels")

    println("--- mapIndexed ---")
    val ranked = heroNames.mapIndexed { i, name -> "${i + 1}. $name" }
    ranked.forEach { println(it) }

    println("--- filter + map (пайплайн) ---")
    val topBonuses = heroLevels
        .filter { it >= 10 }
        .map { it * 10 }
    println("Бонусы топ-героев: $topBonuses")

    val uppercaseTop = heroNames
        .filter { it.length > 3 }
        .map { it.uppercase() }
    println("Имена длиннее 3: $uppercaseTop")

    val scores = listOf(85, 42, 97, 13, 76, 55, 30, 91)
    val weapons = listOf("Меч", "Кинжал", "Лук со стрелами", "Посох", "Малый кинжал")

    println("--- Агрегаты ---")
    println("Сумма очков: ${scores.sum()}")
    println("Среднее: ${scores.average()}")
    println("Максимум: ${scores.maxOrNull()}")
    println("Минимум: ${scores.minOrNull()}")
    println("Всего: ${scores.count()}")

    println("Выше 50: ${scores.count { it > 50 }}")
    println("Суммарная длина названий: ${weapons.sumOf { it.length }}")

    println("--- Поиск ---")
    val firstHigh = scores.find { it > 80 }
    println("Первый выше 80: $firstHigh")

    val lastLow = scores.findLast { it < 50 }
    println("Последний ниже 50: $lastLow")

    val longWeapon = weapons.find { it.length > 8 }
    println("Длинное название: $longWeapon")

    println("--- any / all / none ---")
    println("Есть выше 90: ${scores.any { it > 90 }}")
    println("Все выше 10: ${scores.all { it > 10 }}")
    println("Все выше 100: ${scores.all { it > 100 }}")
    println("Нет отрицательных: ${scores.none { it < 0 }}")

    val levels = listOf(5, 12, 3, 20, 8, 15, 1, 20, 8)
    val names = listOf("Артемида", "Top", "Гвен", "Рэй", "Ли")

    println("--- Сортировка ---")
    println("По возрастанию: ${levels.sorted()}")
    println("По убыванию: ${levels.sortedDescending()}")
    println("Перевёрнутый: ${levels.reversed()}")
    println("Имена по длине: ${names.sortedBy { it.length }}")

    println("--- Выборка ---")
    println("Первые 3: ${names.take(3)}")
    println("Без первых 2: ${names.drop(2)}")
    println("Последние 2: ${names.takeLast(2)}")

    println("--- Дубликаты ---")
    println("С дублями: $levels")
    println("Без дублей: ${levels.distinct()}")
    println("Было: ${levels.size}, стало: ${levels.distinct().size}")

    println("--- joinToString ---")
    println("Через запятую: ${names.joinToString(", ")}")
    println("В скобках: ${names.joinToString("[ ", "[", "]")}")
    println("Закрытые: ${names.joinToString { it.uppercase() }}")

    val base = listOf("Меч", "Щит", "Лук")
    val bonus = listOf("Зелье", "Факел")

    println("--- Операции + / - ---")
    val full = base + bonus
    println("Объединение: $full")

    val noShield = full - "Щит"
    println("Без щита: $noShield")

    val noWeapons = full - listOf("Меч", "Лук")
    println("Без оружия: $noWeapons")

    println("--- Конвертации ---")
    val editable = base.toMutableList()
    editable.add("Кинжал")
    editable.removeAt(0)
    println("После правок: $editable")

    val finalList: List<String> = editable.toList()
    println("Финальный (read-only): $finalList")

    val withDupes = listOf("Ключ", "Зелье", "Ключ", "Меч", "Зелье", "Ключ")
    println("С дублями: $withDupes")
    val noDupes = withDupes.distinct()
    println("Без дублей: $noDupes")
    println("Было ${withDupes.size}, стало ${noDupes.size}")

    println("=== Конец ===")
}
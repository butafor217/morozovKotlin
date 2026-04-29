package task01

fun main() {
    println("=== Система коллекций ===")

    val heroStats = mapOf(
        "сила" to 10,
        "ловкость" to 15,
        "интеллект" to 8,
        "выносливость" to 20,
        "удача" to 5
    )

    println("--- Характеристики героя ---")
    println("Всего характеристик: ${heroStats.size}")
    println("Сила: ${heroStats["сила"]}")
    println("Ловкость: ${heroStats.get("ловкость")}")
    println("Мудрость: ${heroStats["мудрость"] ?: "нет характеристики"}")
    println("Мудрость (getOrDefault): ${heroStats.getOrDefault("мудрость", 0)}")

    println("Все ключи: ${heroStats.keys}")
    println("Все значения: ${heroStats.values}")

    println("Есть 'сила': ${heroStats.containsKey("сила")}")
    println("Есть 'магия': ${heroStats.containsKey("магия")}")
    println("Значение 8 есть: ${heroStats.containsValue(8)}")

    val resources = mutableMapOf(
        "золото" to 100,
        "дерево" to 50,
        "камень" to 30
    )

    println("--- Ресурсы (начало) ---")
    println(resources)

// Добавляем новые ресурсы
    resources["железо"] = 20
    resources.put("уголь", 15)

    println("--- После добавления ---")
    println(resources)

// Обновляем существующие
    resources["золото"] = resources["золото"]!! + 50 // добыли ещё золото
    resources["дерево"] = 0 // потратили всё дерево

    println("--- После обновления ---")
    println(resources)

// Удаляем
    resources.remove("уголь")

    println("--- После удаления ---")
    println(resources)
    println("Ресурсов: ${resources.size}")

    val heroStats2 = mapOf(
        "сила" to 10, "ловкость" to 15,
        "интеллект" to 8, "выносливость" to 20, "удача" to 5
    )

    println("--- forEach no Map ---")
    heroStats2.forEach { (stat, value) ->
        println("$stat: $value")
    }

    println("--- Только значения ---")
    heroStats2.values.forEach { println(it) }

    println("--- filter no Map ---")
    val highStats = heroStats2.filter { (_ , value) -> value >= 10 }
    println("Характеристики >= 10: $highStats")

    println("--- map no Map ---")
    val statLabels = heroStats2.map { (key, value) -> "$key = $value очков" }
    statLabels.forEach { println(it) }

    println("--- any / all ---")
    println("Есть характеристики > 18: ${heroStats2.any { (_ , v) -> v > 18 }}")
    println("Все > 0: ${heroStats2.all { (_ , v) -> v > 0 }}")

    println("Сумма всех характеристик: ${heroStats2.values.sum()}")

    // Set автоматически убирает дубликаты
    val achievedSkills = setOf(
        "Меткий выстрел", "Уклонение",
        "Меткий выстрел", // дубликат – будет проигнорирован
        "Охота в темноте", "Уклонение" // тоже дубликат
    )

    println("--- Set навыков ---")
    println("Уникальных навыков: ${achievedSkills.size}")
    println(achievedSkills)
    println("Есть 'Уклонение': ${"Уклонение" in achievedSkills}")
    println("Есть 'Магия': ${"Магия" in achievedSkills}")

// Операции над множествами
    val classSkills = setOf("Меткий выстрел", "Охота в темноте", "Засада")
    val legendSkills = setOf("Охота в темноте", "Критический удар", "Невидимость")

    println("--- Операции Set ---")
    println("Объединение: ${classSkills.union(legendSkills)}")
    println("Пересечение: ${classSkills.intersect(legendSkills)}")
    println("Только в class: ${classSkills.subtract(legendSkills)}")
    println("Только в legend: ${legendSkills.subtract(classSkills)}")

    val unlockedAbilities = mutableSetOf("Базовая атака", "Блок")

    println("--- Способности (начало) ---")
    println(unlockedAbilities)

// Разблокируем новые
    unlockedAbilities.add("Уклонение")
    unlockedAbilities.add("Критический удар")
    unlockedAbilities.add("Базовая атака")  // дубликат — проигнорируется

    println("--- После добавления ---")
    println("Количество: ${unlockedAbilities.size}")
    println(unlockedAbilities)

// Удаляем
    unlockedAbilities.remove("Блок")
    println("--- После удаления ---")
    println(unlockedAbilities)

// Добавляем группу
    unlockedAbilities.addAll(setOf("Магический щит", "Огненный шар"))
    println("--- После addAll ---")
    println(unlockedAbilities)

// Проверки
    println("Уклонение открыто: ${"Уклонение" in unlockedAbilities}")
    println("Полёт открыт: ${"Полёт" in unlockedAbilities}")

// Конвертация в отсортированный список
    val sortedAbilities = unlockedAbilities.toList().sorted()
    println("Отсортированные: $sortedAbilities")

    val shopPrices = mapOf(
        "Меч" to 100,
        "Щит" to 80,
        "Зелье" to 25,
        "Лук" to 60,
        "Кинжал" to 45
    )

    println("--- filter на Map ---")
    val affordable = shopPrices.filter { (_ , price) -> price <= 60 }
    println("Доступные товары (до 60): $affordable")

    val expensive = shopPrices.filter { (_ , price) -> price > 60 }
    println("Дорогие товары: ${expensive.keys}")

    println("--- map на Map ---")
    val discounted = shopPrices.map { (item, price) ->
        "$item: ${(price * 0.8).toInt()} (со скидкой 20%)"
    }

    discounted.forEach { println(it) }

    println("--- Агрегаты на Map ---")
    println("Самый дорогой: ${shopPrices.maxByOrNull { (_ , p) -> p }}")
    println("Самый дешёвый: ${shopPrices.minByOrNull { (_ , p) -> p }}")
    println("Сумма всех цен: ${shopPrices.values.sum()}")

    println("Дорогих товаров: ${shopPrices.count { (_ , p) -> p > 60 }}")

    println("--- forEach на Set ---")
    val uniqueEnemies = setOf("Гоблин", "Тролль", "Дракон", "Скелет")
    uniqueEnemies.forEach { println("• $it") }

    val strongEnemies = uniqueEnemies.filter { it.length > 5 }
    println("Длинные названия: $strongEnemies")

    val allLoot = listOf(
        "Золотая монета", "Рубин", "Золотой слиток",
        "Рубиновый кристалл", "Сапфир", "Золотое кольцо",
        "Изумруд", "Рубиновый амулет"
    )

    println("--- groupBy: группировка добычи ---")

// Группировка по первому слову (в оригинале split("") - так будет по буквам, скорее всего нужно split(" "))
    val byMaterial = allLoot.groupBy { it.split(" ").first() }
    byMaterial.forEach { (material, items) ->
        println("$material (${items.size} шт.): ${items.joinToString(", ")}")
    }

    println("--- Статистика по группам ---")
    byMaterial.forEach { (material, items) ->
        println("$material -> ${items.size} предметов")
    }

// Самая большая группа
    val biggestGroup = byMaterial.maxByOrNull { (_, items) -> items.size }
    println("Больше всего: ${biggestGroup?.key ?: "нет"} - ${biggestGroup?.value?.size ?: 0} шт.")

// Группировка по длине строки
    println("--- По длине названия ---")
    val byLength = allLoot.groupBy { it.length }
    byLength.forEach { (len, items) ->
        println("Длина $len: $items")
    }

    // — List из Map
    println("--- Map → List ---")
    val stats = mapOf("сила" to 10, "ловкость" to 15, "интеллект" to 8)

    val statList = stats.entries.map { "${it.key}: ${it.value}" }
    statList.forEach { println(it) }

// Отсортировать Map по значению
    val sorted = stats.entries.sortedByDescending { it.value }
    println("По убыванию: ${sorted.map { "${it.key}=${it.value}" }}")

    println("=== Конец ===")
}
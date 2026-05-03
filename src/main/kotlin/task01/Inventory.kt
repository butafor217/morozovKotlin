package task01

val inventory = mutableListOf(
    "Меч",
    "Щит",
    "Зелье здоровья"
)

val resources = mutableMapOf(
    "золото" to 100,
    "дерево" to 50,
    "камень" to 30
)

val achievedSkills = setOf(
    "Меткий выстрел", "Уклонение",
    "Меткий выстрел", // дубликат – будет проигнорирован
    "Охота в темноте", "Уклонение" // тоже дубликат
)

val classSkills = setOf("Меткий выстрел", "Охота в темноте", "Засада")
val legendSkills = setOf("Охота в темноте", "Критический удар", "Невидимость")
val unlockedAbilities = mutableSetOf("Базовая атака", "Блок")
val uniqueEnemies = setOf("Гоблин", "Тролль", "Дракон", "Скелет")

fun printInventory() {
    println("ИНВЕНТАРЬ")
    if (inventory.isEmpty()) {
        println("   ИНВЕНТАРЬ ПУСТ")
        return
    }
    inventory.forEachIndexed { i, item ->
        println("${i + 1}. $item")
    }
    println("ПРЕДМЕТОВ: ${inventory.size}")
}

fun addItem(item: String) {
    inventory.add(item)
}

fun removeItem(item: String): Boolean {
    return if (item in inventory) {
        inventory.remove(item)
        true
    } else {
        false
    }
}

fun hasItem(item: String) = item in inventory

fun printResources() {
    println("РЕСУРСЫ")
    resources.forEach { (res, amount) -> println(" $res: $amount" )}
    println("Всего видов: ${resources.size}")
}

fun printSkills() {
    println("НАВЫКИ И СПОСОБНОСТИ")
    printSection("Достижения")
    println("Уникальных: ${achievedSkills.size}")
    achievedSkills.forEach { println(" • $it" )}
    printSection("Операции над множествами")
    println("Объединение: ${classSkills.union(legendSkills)}")
    println("Пересечение: ${classSkills.intersect(legendSkills)}")
    printSection("Разблокированные способности")
    unlockedAbilities.forEach { println(" × $it" )}
}

fun useItem(itemName: String): Boolean {
    when {
        "здоровья" in itemName.lowercase() -> {
            if (!removeItem(itemName)) return false
            val healAmt = rand(20, 40)
            heal(healAmt)
            println(" Использовано: $itemName (+$healAmt HP)")
            return true
        }
        "силы" in itemName.lowercase() -> {
            if (!removeItem(itemName)) return false
            heroStats["сила"] = (heroStats["сила"] ?: 0) + 3
            println(" Использовано: $itemName (+3 сила)")
            return true
        }
        "невидимости" in itemName.lowercase() -> {
            if (!removeItem(itemName)) return false
            println(" Ты стал невидимым на время!")
            return true
        }
        else -> {
            println(" Нельзя использовать: $itemName")
            return false
        }
    }
}

fun findFirstPotion(): String? {
    for (item in inventory) {
        if ("зелье" !in item.lowercase()) continue
        return item
    }
    return null
}

fun inventoryMenu() {
    var inInventory = true
    while (inInventory) {
        println("ИНВЕНТАРЬ")

        if (inventory.isEmpty()) {
            println("Пусто. Загляни в магазин!")
        } else {
            for ((index, item) in inventory.withIndex()) {
                val canUse = if ("Зелье" in item) "[использовать]" else ""
                println("${index + 1}. $item $canUse")
            }
        }

        println("\n1. Использовать зелье  2. Выбросить предмет  0. Назад")
        when (readChoice(2)) {
            1 -> {
                val potion = findFirstPotion()
                if (potion != null) useItem(potion)
                else println("Нет зелий для использования!")
            }
            2 -> {
                if (inventory.isEmpty()) {
                    println("Нечего выбрасывать!")
                    continue
                }
                for ((index, item) in inventory.withIndex()) {
                    println("${index + 1}. $item")
                }
                println("Номер: ")
                val num = readLine()?.trim()?.toIntOrNull()
                if (num != null && num in 1..inventory.size) {
                    val removed = inventory.removeAt(num - 1)
                    println("Выброшено: $removed")
                } else println("Неверный номер")
            }
            0 -> inInventory = false
        }
    }
}
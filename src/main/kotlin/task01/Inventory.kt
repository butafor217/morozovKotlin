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
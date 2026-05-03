package task01

val shopItems = mapOf(
    "Меч" to 100,
    "Щит" to 80,
    "Зелье здоровья" to 25,
    "Лук" to 60,
    "Кинжал" to 45,
    "Зелье силы" to 40
)

fun printShop() {
    println("МАГАЗИН")
    println("Твоё золото: $heroGold")
    printSection("Товары")
    for ((item, price) in shopItems) {
        val owned = if (hasItem(item)) " √" else ""
        val canBuy = if (heroGold < price) " (мало золота)" else ""
        println("$item - $price золота$owned$canBuy")
    }
}

fun buyItem(itemName: String): Boolean {
    val price = shopItems[itemName]
    if (price == null) {
        println("Нет такого товара: $itemName")
        return false
    }
    if (heroGold < price) {
        println("Недостаточно золота. Нужно: $price, есть: $heroGold")
        return false
    }
    heroGold -= price
    addItem(itemName)
    println("Куплено: $itemName за $price золота. Осталось: $heroGold")
    return true
}

fun sellItem(itemName: String): Boolean {
    if (!removeItem(itemName)) {
        println("Нет предмета: $itemName")
        return false
    }
    val price = shopItems[itemName] ?: 10 / 2
    heroGold += price
    println("Продано: $itemName за $price золота. Теперь: $heroGold")
    return true
}

fun printDiscounted(discountPercent: Int = 20) {
    printSection("Скидки $discountPercent%")
    val multiplier = (100 - discountPercent) / 100.0
    shopItems.map { (item, price) ->
        "$item: ${(price * multiplier).toInt()} золота"
    }.forEach { println(" $it" )}
}

fun printAffordable(maxPrice: Int = 60) {
    printSection("Доступные до $maxPrice золота")
    shopItems.filter { (_, price) -> price <= maxPrice }
        .forEach { (item, price) -> println(" $item - $price" )}
}

fun shopMenu() {
    var inShop = true
    while (inShop) {
        println("МАГАЗИН")
        println("ЗОЛОТО: $heroGold\n")

        val itemList = shopItems.entries.toList()
        for ((index, entry) in itemList.withIndex()) {
            val (item, price) = entry
            val owned = if (hasItem(item)) " √" else ""
            val canBuy = if (heroGold < price) " ×" else ""
            println("${index + 1}. $item - $price$owned$canBuy")
        }

        println("\n1. Купить    2. Продать    3. Скидки    0. Назад")
        when (readChoice(3)) {
            1 -> {
                printSection("ПОКУПКА")
                for ((index, entry) in itemList.withIndex()) {
                    val (item, price) = entry
                    if (hasItem(item)) continue
                    val canBuy = if (heroGold >= price) "" else " (мало золота)"
                    println(" ${index + 1}. $item - $price$canBuy")
                }
                println(" 0. Отмена")
                print("Номер товара: ")
                val num = readLine()?.trim()?.toIntOrNull()
                if (num != null && num in 1..itemList.size) {
                    val (item, _) = itemList[num - 1]
                    buyItem(item)
                }
            }
            2 -> {
                if (inventory.isEmpty()) {
                    println("   Инвентарь пуст — нечего продавать!")
                    continue
                }
                printSection("ПРОДАЖА")
                for ((index, item) in inventory.withIndex()) {
                    val sellPrice = (shopItems[item] ?: 10) / 2
                    println(" ${index + 1}. $item - продажа: $sellPrice золота")
                }
                println(" 0. Отмена")
                print("Номер предмета: ")
                val num = readLine()?.trim()?.toIntOrNull()
                if (num != null && num in 1..inventory.size) {
                    sellItem(inventory[num - 1])
                }
            }
            3 -> { printDiscounted(); printAffordable() }
            0 -> inShop = false
        }
    }
}
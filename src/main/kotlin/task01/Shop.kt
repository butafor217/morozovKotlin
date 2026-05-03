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
    shopItems.forEach { (item, price) ->
        val owned = if (hasItem(item)) "√" else ""
        val canBuy = if (heroGold < price) "(мало золота)" else ""
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
package task01

fun craftItem(name: String, material: String, durability: Int = 100) =
    "$name из $material, прочность: $durability"

fun enchantDamage(baseDamage: Int, enchantLevel: Int) =
    baseDamage + (enchantLevel * 5)

fun orderSummary(customerName: String, itemName: String, material: String, price: Int = 50) {
    println("Заказ от $customerName: $itemName из $material, цена: $price золота")
}

fun main() {
    val sword = craftItem("Меч", "сталь")
    val shield = craftItem("Щит", "мифрил", 250)

    val damage1 = enchantDamage(10, 3)
    val damage2 = enchantDamage(25, 0)

    println(sword)
    println(shield)
    println("Урон с зачарованием (10 + 3*5) = $damage1")
    println("Урон с зачарованием (25 + 0) = $damage2")
    println()

    orderSummary("Лютик", "Кинжал", "серебро")

    orderSummary(
        material = "драконья чешуя",
        price = 300,
        customerName = "Геральт",
        itemName = "Серебряный меч"
    )
}
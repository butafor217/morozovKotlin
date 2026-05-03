package task01
import kotlin.random.Random

fun printSeparator(width: Int = 32) {
    println("—".repeat(width))
}

fun printTitle(title: String) {
    printSeparator()
    println(" $title")
    printSeparator()
}

fun printSection(name: String) {
    println("\n--- $name ---")
}

fun pressAnyKey() {
    print("\nНажми Enter для продолжения ...")
    readLine()
}


fun executeEvent(heroName: String, event: (String) -> Unit) {
    println("--- Событие для $heroName ---")
    event(heroName)
}

fun rand(min: Int, max: Int): Int = Random.nextInt(min, max + 1)

fun printBar(label: String, current: Int, max: Int, width: Int = 10) {
    val filled = if (max > 0) current * width / max else 0
    println("$label")
    repeat(filled) { print("■") }
    repeat(width - filled) { print("■") }
    println(" $current/$max")
}

fun readChoice(max: Int): Int {
    var choice: Int?
    do {
        print("Выбор: ")
        choice = readLine()?.trim()?.toIntOrNull()
        if (choice == null || choice !in 0..max) {
            println(" Веди число от 0 до $max")
            choice = null
        }
    } while (choice == null)
    return choice
}
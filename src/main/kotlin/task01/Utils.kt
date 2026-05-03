package task01

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
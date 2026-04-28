package task01

fun checkAccess(level: Int, hasPass: Boolean) {
    if (level >= 20 && hasPass) {
        println("Доступ разрешён — проходи")
    } else if (level >= 20 && !hasPass) {
        println("Показать командиру")
    } else if (level < 20 && hasPass) {
        println("Пропуск недостаточен — нужен уровень 20")
    } else {
        println("Доступ запрещён")
    }
}

fun inspectCargo(weight: Int, hasWeapon: Boolean, hasContraband: Boolean) {
    if (hasContraband) {
        println("Задержать! Обнаружены запрещённые предметы")
    } else if (hasWeapon && weight > 50) {
        println("Пройти досмотр — груз подозрительный")
    } else {
        println("Пропуск разрешён")
    }
}

fun main() {
    println("=== Проверка доступа в цитадель ===")
    checkAccess(25, true)
    checkAccess(25, false)
    checkAccess(15, true)
    checkAccess(15, false)

    println("\n=== Досмотр груза ===")
    inspectCargo(30, false, false)
    inspectCargo(60, true, false)
    inspectCargo(40, true, false)
    inspectCargo(70, true, true)
}
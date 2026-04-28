package task01

fun main() {
    val formatParticipant: (String, Int) -> String = { name, level ->
        "🏆 $name (Уровень: $level) — допущен к турниру"
    }

    println("=== Демонстрация formatParticipant ===")
    val formatted = formatParticipant("Тормунд", 7)
    println(formatted)
    println()

    val participants = listOf(
        "Арагорн",
        "Леголас",
        "Гимли",
        "Гэндальф",
        "Фродо",
        "Эовин"
    )

    println("=== Список зарегистрированных участников ===")
    participants.forEach { participant ->
        println("• $participant")
    }
    println()

    val announceResult: (String) -> Unit = { name ->
        println("⚔️ $name завершил выступление! Результат: ${(1..10).random()} очков")
    }

    println("=== Объявление результатов ===")
    announceResult("Арагорн")
    announceResult("Леголас")
    announceResult("Гимли")
    println()

    fun prepareForBattle(heroName: String, action: (String) -> Unit) {
        println("🔧 Подготовка к бою: $heroName")
        action(heroName)
    }

    println("=== Подготовка героев к битве ===")

    prepareForBattle("Гэндальф", { name ->
        println("   $name точит посох и проверяет заклинания")
    })

    prepareForBattle("Арагорн") { name ->
        println("   $name чистит меч Андурил и надевает доспехи")
    }

    prepareForBattle("Леголас") { name ->
        println("   $name натягивает тетиву луна и проверяет стрелы")
    }
    println()

    val calculateScore: (Int, Int) -> Int = { level, wins ->
        level * 50 + wins * 30
    }

    println("=== Расчёт турнирных очков ===")
    val playerScore = calculateScore(8, 5)
    println("Итоговый счёт участника (уровень 8, побед 5): $playerScore очков")

    val anotherScore = calculateScore(3, 2)
    println("Итоговый счёт участника (уровень 3, побед 2): $anotherScore очков")
}
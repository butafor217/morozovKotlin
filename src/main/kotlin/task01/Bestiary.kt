package task01

fun classifyCreature(type: String) {
    when (type) {
        "дракон" -> println("Огнедышащий летающий ящер, покрытый чешуёй. Опасен на любой дистанции.")
        "гоблин" -> println("Маленькое злобное существо, обычно обитает в пещерах. Опасно в стае.")
        "феникс" -> println("Бессмертная огненная птица, возрождается из пепла. Почитаема у магов.")
        "тролль" -> println("Огромное медлительное существо с регенерацией. Уязвим для огня.")
        "волк" -> println("Лесной хищник, охотится стаей. Очень быстр и вынослив.")
        else -> println("Неизвестное существо. Требуется дополнительное изучение.")
    }
}

fun threatLevel(power: Int) {
    when (power) {
        in 0..30 -> println("Уровень угрозы: Низкий (мирный житель)")
        in 31..60 -> println("Уровень угрозы: Средний (тренированный воин)")
        in 61..90 -> println("Уровень угрозы: Высокий (легендарное существо)")
        in 91..150 -> println("Уровень угрозы: Критический (уничтожить немедленно)")
        else -> println("Уровень угрозы: Неопределённый (нужна разведка)")
    }
}

fun getElement(element: String): String {
    return when (element) {
        "огонь" -> "Огонь — стихия разрушения и жизни, дарует тепло и испепеляет врагов."
        "вода" -> "Вода — стихия течения и исцеления, смывает всё на своём пути."
        "земля" -> "Земля — стихия стойкости и плодородия, дарует защиту и силу."
        "воздух" -> "Воздух — стихия свободы и мысли, быстр и неуловим."
        else -> "Неизвестная стихия. Похоже на магический выброс."
    }
}

fun encounterAssessment(power: Int, hasGold: Boolean, companions: Int) {
    when {
        power > 90 && companions < 2 -> println("КРИТИЧЕСКАЯ ОПАСНОСТЬ! Немедленно бегите или призывайте армию!")
        power > 70 && hasGold -> println("Существо чует золото. Вы можете договориться, отдав часть сокровищ.")
        companions >= 3 && power < 50 -> println("Ваш отряд легко справится. Охота на существо начинается!")
        power in 30..70 && companions == 1 -> println("Будьте осторожны. Один на один с этим существом — большой риск.")
        power <= 20 && !hasGold -> println("Существо не опасно и не заинтересовано. Можете пройти мимо.")
        else -> println("Ситуация неоднозначна. Лучше обойти стороной.")
    }
}

fun main() {
    println("=== Бестиарий: классификация существ ===")
    classifyCreature("дракон")
    classifyCreature("гоблин")
    classifyCreature("феникс")
    classifyCreature("эльф")

    println("\n=== Оценка уровня угрозы ===")
    threatLevel(25)
    threatLevel(55)
    threatLevel(88)
    threatLevel(120)
    threatLevel(200)

    println("\n=== Определение стихии ===")
    val fireDesc = getElement("огонь")
    val waterDesc = getElement("вода")
    val voidDesc = getElement("пустота")
    println(fireDesc)
    println(waterDesc)
    println(voidDesc)

    println("\n=== Оценка случайной встречи ===")
    encounterAssessment(95, true, 1)
    encounterAssessment(75, true, 3)
    encounterAssessment(40, false, 1)
}
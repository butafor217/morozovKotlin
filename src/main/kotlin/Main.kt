fun main() {
    val developerName: String = "Artem"
    val nameInitial: Char = 'A'
    val ageYears: Int = 25
    val cityPopulation: Long = 1200000L
    val heightMeters: Double = 1.785
    val gpaScore: Float = 4.75f
    val isEmployed: Boolean = false
    val osCount: Byte = 3
    val studentId: Short = 1024

    println("Досье разработчика: ${developerName} (инициал ${nameInitial}).")
    println("Ему ${ageYears} лет, и он проживает в городе с населением ${cityPopulation} человек.")
    println("Рост составляет ${heightMeters} м, а средний балл зачётки — ${gpaScore}.")
    println("Официально трудоустроен: ${isEmployed}.")
    println("На личном ноутбуке установлено ${osCount} операционные системы, а его студенческий билет имеет номер ${studentId}.")
}
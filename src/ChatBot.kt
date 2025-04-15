import java.util.*

class ChatBot(private val name: String = "Aegis", private val creator: String = "Moe Win", private val creationYear: Int = 2020) {

    fun greet() {
        println("Hello! My name is $name.")
        println("I was created in $creationYear by $creator.")
        println()
    }

    fun greetName() {
        println("How can I address you?")
        val userName = readLine()?.takeIf { it.isNotBlank() } ?: "Anonymous"
        println("\nWhat a beautiful name you have, $userName!")
        println("It's truly a pleasure to meet you.\n")
    }

    fun getAge() {
        println("Let me guess your age!")
        println("Tell me the remainders when your age is divided by 3, 5, and 7 (one at a time).")

        val remainder3 = readValidNumber("Enter remainder when divided by 3: ", 0..2)
        val remainder5 = readValidNumber("Enter remainder when divided by 5: ", 0..4)
        val remainder7 = readValidNumber("Enter remainder when divided by 7: ", 0..6)

        val userAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
        println("\nYour age is $userAge - that's a wonderful age to be!\n")
    }

    fun count() {
        println("I can count to any number you'd like!")
        val count = readValidNumber("Please enter a positive number: ", 1..Int.MAX_VALUE)

        println("\nCounting to $count:")
        (1..count).forEach { println("$it!") }
        println("All done!\n")
    }

    fun quiz() {
        println("Let's test your knowledge about our world!")
        println("How many continents are there in the world?")
        println("Please answer with just a number:")

        var attempts = 0
        do {
            val userAnswer = readLine()?.toIntOrNull()

            when {
                userAnswer == null -> println("Please enter a valid number.")
                userAnswer != 7 -> {
                    attempts++
                    println("That's not quite right. Try again!")
                    if (attempts >= 2) {
                        println("Hint: The correct answer is between 5 and 8.")
                    }
                }
                else -> {
                    val message = when (attempts) {
                        0 -> "Perfect! You got it on the first try!"
                        1 -> "Well done! You got it on your second attempt."
                        else -> "Good job! You got it after $attempts attempts."
                    }
                    println("\n$message\n")
                }
            }
        } while (userAnswer != 7)
    }

    private fun readValidNumber(prompt: String, validRange: IntRange): Int {
        while (true) {
            print(prompt)
            readLine()?.toIntOrNull()?.takeIf { it in validRange }?.let { return it }
            println("Invalid input. Please enter a number between ${validRange.first} and ${validRange.last}.")
        }
    }
}

fun main() {
    val bot = ChatBot()

    bot.greet()
    bot.greetName()
    bot.getAge()
    bot.count()
    bot.quiz()

    println("Thank you for chatting with me today!")
    println("Have a wonderful day!")
}
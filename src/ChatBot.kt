
class ChatBot {

    fun greet() {
        println("Hello, My name is Aegis.")
        println("I was created in 2020 by Moe Win.")

    }

    fun greetName() {
        println("How can I address you?")
        val usrName = readLine().toString()
        println("What a great name you have. $usrName!!")
        println("It's nice to see you.")
    }

    fun getAge() {
        println("I can guess your age.")
        println("Tell me remainders of dividing your age by 3, 5 and 7.")
        val remainder3 = readLine()!!.toInt()
        val remainder5:Int = readLine()!!.toInt()
        val remainder7:Int = readLine()!!.toInt()
        val userAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
        println("Your age is $userAge.")
    }

    fun count() {
        println("I can count to any number you want.")
        println("Tell me a number: ")

        val count: Int = readLine()!!.toInt()
        for (i in 1..count){
            println("$i!")
        }
    }

    fun test() {
        println("Let's test your knowledge about our world.")
        println("How many continents in the world?")
        println("Please answer just number: ")

        do {
            val userAns: Int = readLine()!!.toInt()
            if (userAns != 7) {
                println("Please, try again")
            } else {
                println("Congratulation!! You are correct.")
            }
        } while (userAns !=7)
    }
}

fun main() {
    val aegis = ChatBot()
    aegis.greet()
    aegis.greetName()
    aegis.getAge()
    aegis.count()
    aegis.test()
}
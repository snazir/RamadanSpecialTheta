package theta.ramadan.android

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)


        variableInKotlin()
        ValAndVar()
        concatinationInKotlin()
        dataTypesInKotlin()
        convertDataTypesInKotlin()
        mathOperatersInKotlin()
        incrementDecrementInKotlin()
        whenStatementInKotlin()
        loopsInKotlin()


    }

    private fun loopsInKotlin() {
        // ArrayList
        val coursesList = arrayListOf<String>()
        coursesList.add("Android")
        coursesList.add("IOS")
        coursesList.add("Design")
        coursesList.add("SEO")
        coursesList.add("C#")


        //Foreach Loop
        coursesList.forEach {
            // Iterations
        }

        // for Loop
        for (course in coursesList) {
            // Iterations
        }

        // Loop with Range
        for (courseCount in 5..10) {
            //iterations
        }




    }

    private fun whenStatementInKotlin() {
        // Switch

        val result = 100

        if (result == 50) {
            //
        } else if (result == 60) {
            //
        } else if (result == 100) {
            //

        }

        when (result) {
            50 -> {
                // run for 50
            }

            60 -> {

            }

            100 -> {

            }
            else -> {
                //
            }

        }

    }

    private fun incrementDecrementInKotlin() {

        var firstNumber = 5
        var lastNumber = 6

        var result = 0

        result = firstNumber++ + lastNumber   //12

        result = firstNumber++ + lastNumber  //  13

        result = firstNumber-- - lastNumber   // 0
        result = firstNumber-- - lastNumber   // -1

        result = firstNumber++ - lastNumber   //

    }

    private fun mathOperatersInKotlin() {
        val number = 4
        val number2 = 10
        val number3 = 12

        var result = 0

        result = number * number2    // 40
        result = number3 / number // 3
        result = number + number2   // 14
        result = number2 - number    // 6
    }

    private fun convertDataTypesInKotlin() {
        val ageInString = "30"
        // String to Integer Conversion
        val myAgeInInt = Integer.valueOf(ageInString)
        print(myAgeInInt) // 30


        val phone = 3141341
        val phoneString = phone.toString() //  "3141341"
    }

    private fun dataTypesInKotlin() {
        val name: String = "ThetaSolutions"
        val age: Int = 10
        val height: Double = 5.5
        val depth: Float = 5.5f
        val isPractical: Boolean = true
    }

    private fun concatinationInKotlin() {
        val firstName = "Theta"
        val lastName = "Solutions"

        //    val companyName = firstName + lastName    // ThetaSolutions
        val companyName = "$firstName$lastName"     // ThetaSolutions
    }

    private fun ValAndVar() {

    }

    private fun variableInKotlin() {

        // var and val

        var age = 5   //Auto DataType
        val age1 = 5   // Auto.....

        age = 6 // Possible
        //     age1 = 6 //Not Possible -> Val can't be reassigned

        val name: String   // Explicitly declaration
        //   public String name = "Theta"   in Java
        name = "Theta"

        val lastName: String = "Solutions"   //Koltin will offer you to remove explicit declaration

        //   age = "Theta" //Type Mismatch
        val isTrue = false


        //Nullables
        var height: Float = 5.5f
        //   height = null     // Not Possible


        var depth: Float? = 5.5f
        depth = null     // Possible

        var signupButton: Button

        var userNameEditText: EditText?


    }
}

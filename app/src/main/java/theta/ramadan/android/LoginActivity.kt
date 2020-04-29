package theta.ramadan.android

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_login)
        signInButton.setOnClickListener {

            if (checkUserNameValidity(userNameEditText.text.toString())) {
                // showMessageWithUserName()
                // Password Validation
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show()
                moveToHomeActivity()

            } else {
                userNameEditText.error = "UserName invalid"
            }
        }

        office365Button.setOnClickListener {
            Toast.makeText(
                this, "Office 365",
                Toast.LENGTH_SHORT
            ).show()
        }

        googleButton.setOnClickListener {
            Toast.makeText(
                this, "Google Button",
                Toast.LENGTH_SHORT
            ).show()
        }

        forgotPasswordText.setOnClickListener {
            moveToForgotPasswordActivity()
        }


    }

    private fun moveToForgotPasswordActivity() {
        val forgotPasswordIntent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(forgotPasswordIntent)
    }

    private fun moveToHomeActivity() {
        // Explicit Intent.
        val homeActivityIntent = Intent(this, HomeActivity::class.java)
        homeActivityIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        this.finish()
        //   homeActivityIntent.putExtra("email", userNameEditText.text.toString())
        startActivity(homeActivityIntent)

    }

    private fun checkUserNameValidity(userEmail: String): Boolean {
        if (userEmail.isBlank()) {
            return false
        }
        return !TextUtils.isEmpty(userEmail) && android.util.Patterns.EMAIL_ADDRESS.matcher(
            userEmail
        ).matches();
    }

    private fun showMessageWithUserName() {
        Toast.makeText(
            this, userNameEditText.text.toString(),
            Toast.LENGTH_SHORT
        ).show()
    }
}

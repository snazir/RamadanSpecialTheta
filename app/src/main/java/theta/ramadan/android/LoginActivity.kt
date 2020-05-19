package theta.ramadan.android

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.login.LoginResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import theta.ramadan.android.network.ThetaApiInterface
import theta.ramadan.responses.UserResponse


class LoginActivity : AppCompatActivity() {


    lateinit var callbackManager: CallbackManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FacebookSdk.sdkInitialize(this)
//        AppEventsLogger.activateApp(this)

        setContentView(R.layout.activity_login)
        callbackManager = CallbackManager.Factory.create();

        val EMAIL = "email"

        login_button.setReadPermissions(listOf(EMAIL))
        // If you are using in a fragment, call loginButton.setFragment(this)

        // Callback registration
        // If you are using in a fragment, call loginButton.setFragment(this)
        // Callback registration
        login_button.registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
            override fun onSuccess(loginResult: LoginResult?) { // App code
                val token = loginResult?.accessToken?.token
            }

            override fun onCancel() { // App code
                Log.d("Facebook", "Cancel")
            }

            override fun onError(exception: FacebookException) { // App code

            }
        })


//        loadLoginFragment()
        signInButton.setOnClickListener {

            if (checkUserNameValidity(userNameEditText.text.toString())) {
                // showMessageWithUserName()
                // Password Validation
         //       callLoginUserApi(userNameEditText.text.toString(), passwordEditText.text.toString())
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

        loadLogoFromInternet()

    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun callLoginUserApi(email: String, password: String) {

        ThetaApiInterface.getRetrofitInstance()?.loginUser(email, password)
            ?.enqueue(object : Callback<UserResponse> {
                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    // Toast    t.localizedMessage

                }

                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.isSuccessful) {
                        val userResponse = response.body() as UserResponse
                        saveLoginInformationToSharedPreference(userNameEditText.text.toString())


                        // pass this list to the adapter
                        // hide progress
                    }
                }


            })

    }

    private fun saveLoginInformationToSharedPreference(userEmail: String) {
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("theta", MODE_PRIVATE)
        sharedPreferences.edit().putString("USER_EMAIL", userEmail).apply()
    }

    private fun loadLogoFromInternet() {
        Picasso.with(this)
            .load("https://media-exp1.licdn.com/dms/image/C4D0BAQESOZlBHeuyEw/company-logo_200_200/0?e=2159024400&v=beta&t=AFpaVFRyGyqQY94LLeqXjHmDdxY72OSCokWJIocOeVE")
            .placeholder(R.mipmap.ic_launcher)
            .into(company_logo)
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

package theta.ramadan.android

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
//            val sharedPreferences: SharedPreferences =
//                this.getSharedPreferences("theta", MODE_PRIVATE)
//            if (sharedPreferences.contains("USER_EMAIL")) {
//                moveToHomeActivity()
//            } else {
//                gotToLoginActivity()
//
//            }
            goToRoomActivity()

        }, 3000)
    }

    private fun goToRoomActivity() {
        val intent = Intent(this, RoomActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun gotToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun moveToHomeActivity() {
        // Explicit Intent.
        val homeActivityIntent = Intent(this, HomeActivity::class.java)
        homeActivityIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        this.finish()
        //   homeActivityIntent.putExtra("email", userNameEditText.text.toString())
        startActivity(homeActivityIntent)

    }
}

package theta.ramadan.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_home.*
import theta.ramadan.android.network.ThetaApiInterface
import theta.ramadan.android.ui.main.SectionsPagerAdapter

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setting UI Design
        setContentView(R.layout.activity_home)


        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)


        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            showSnackBar(view, "Logout Successfully")
            showLogoutConfirmationDialog()

        }


        // Toast.makeText(this, "OnCreate", Toast.LENGTH_LONG).show()
        Log.d("HomeActivity", "OnCreate")
    }


    private fun showSnackBar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }

    private fun showLogoutConfirmationDialog() {
        // On Logout, Move to Login Activity
        val builder = AlertDialog.Builder(this@HomeActivity)

        builder.setTitle(resources.getString(R.string.logout_confirmation_title))
        builder.setMessage(resources.getString(R.string.logout_confirmation_message))
        builder.setPositiveButton(resources.getString(R.string.logout_confirmation_positive_Button)) { dialog, which ->
            dialog.dismiss()
            logoutUser()

        }
        builder.setNegativeButton(resources.getString(R.string.logout_confirmation_Negative_Button)) { dialog, which ->
            dialog.dismiss()
        }

        //       builder.setView(R.layout.activity_login)

        builder.setNeutralButton("CANCEL") { dialog, which -> }

        // Neutral button

        val logoutDialog: AlertDialog = builder.create()
        logoutDialog.show()
    }

    private fun logoutUser() {

        ThetaApiInterface.getRetrofitInstance()?.userLogout()





        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
        this.finish()
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        // Attached UI Design come to the screen
        // User can see the design on the screen
        // User can't interact with the screen
        // activity comes to Foreground
//        Toast.makeText(this, "OnStart", Toast.LENGTH_LONG).show()
        Log.d("HomeActivity", "onStart")


    }

    override fun onResume() {
        super.onResume()
//        Toast.makeText(this, "OnResume", Toast.LENGTH_LONG).show()
        Log.d("HomeActivity", "OnResume")

        // UI on the screen now able to interact by user
        // i.e. button click, scroll etc
    }

    override fun onPause() {
        super.onPause()
//        Toast.makeText(this, "OnPause", Toast.LENGTH_LONG).show()
        Log.d("HomeActivity", "OnPause")

        // partially out of screen
        // No more interaction

        //    if(someVoiceMessage.isPlaying())
        // voiceMessage.pause()
        //OR
        //song.keepPlaying()
    }

    override fun onStop() {
        super.onStop()
        Log.d("HomeActivity", "onStop")

        // COmpletly out of screen
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeActivity", "onDestroy")


    }
}

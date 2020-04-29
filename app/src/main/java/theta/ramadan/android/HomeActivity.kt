package theta.ramadan.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import theta.ramadan.android.ui.main.SectionsPagerAdapter

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setting UI Design
        setContentView(R.layout.activity_home)


        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Logout Successfully", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            // On Logout, Move to Login Activity

            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            this.finish()
            startActivity(intent)
        }


        // Toast.makeText(this, "OnCreate", Toast.LENGTH_LONG).show()
        Log.d("HomeActivity", "OnCreate")
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

package lifecycle.example.home

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import android.view.Menu
import android.view.MenuItem
import dagger.android.support.DaggerAppCompatActivity

import kotlinx.android.synthetic.main.activity_home.*
import lifecycle.example.R
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity(), HomeView {

    @Inject
    lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        Log.i("Lifecycle Test", "Lifecycle Test Activity onCreate")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        Log.i("Lifecycle Test", "Lifecycle Test Activity onCreateOptionsMenu")
        return true
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle Test", "Lifecycle Test Activity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle Test", "Lifecycle Test Activity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle Test", "Lifecycle Test Activity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle Test", "Lifecycle Test Activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle Test", "Lifecycle Test Activity onDestroy")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

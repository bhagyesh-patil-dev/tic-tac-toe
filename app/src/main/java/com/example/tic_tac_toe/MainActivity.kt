package com.example.tic_tac_toe

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tic_tac_toe.utils.SystemBarUtil

class MainActivity : AppCompatActivity() {

    private var hasLaunched = false
    private val handler = Handler(Looper.getMainLooper())

    private val startActivityRunnable = Runnable {
        if (!hasLaunched) {
            hasLaunched = true
            startActivity(Intent(this, MainMenuActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        SystemBarUtil.setTransparentSystemBars(
            window, isStatusBarTransparent = true, isNavigationBarTransparent = true
        )
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(startActivityRunnable)
    }

    override fun onResume() {
        super.onResume()
        if (!hasLaunched) {
            handler.postDelayed(startActivityRunnable, 1000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(startActivityRunnable)
    }
}
package kh.edu.rupp.ite.elec_app.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.elec_app.R
import kh.edu.rupp.ite.elec_app.databinding.ActivitySplashBinding
import kh.edu.rupp.ite.elec_app.view.fragment.HomeFragment

class SplashActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val zoomInAnimation = ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)
        zoomInAnimation.duration = 1000

        val zoomOutAnimation = ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)
        zoomOutAnimation.duration = 800


        zoomInAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                binding.splashImageView.startAnimation(zoomOutAnimation)
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        zoomOutAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                // Navigate to the next activity (e.g., main activity)
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }

            override fun onAnimationEnd(animation: Animation?) {}

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        binding.splashImageView.startAnimation(zoomInAnimation)
    }
}
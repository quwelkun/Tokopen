package com.example.tokopen.ui.lottie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import com.example.tokopen.R

class LottieSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottie_success)

        val lottie: LottieAnimationView = findViewById(R.id.animationView)
        lottie.progress = 0.0F
        lottie.pauseAnimation()
        lottie.playAnimation()
    }
}
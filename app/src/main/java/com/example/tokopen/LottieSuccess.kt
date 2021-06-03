package com.example.tokopen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView

class LottieSuccess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottie_success)

        var lottie: LottieAnimationView = findViewById(R.id.animationView)
        lottie.progress = 0.0F
        lottie.pauseAnimation()
        lottie.playAnimation()
    }
}
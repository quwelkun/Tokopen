package com.example.tokopen.ui.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tokopen.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private val binding: ActivityAboutBinding by lazy {
        ActivityAboutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
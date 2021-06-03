package com.example.tokopen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class DetailPen : AppCompatActivity() {
    companion object{
        private var NAME = "name"
        private var PRICE = "price"
        private var DETAIL = "detail"
        private var SRC = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pen)

        NAME = intent.getStringExtra("NAME").toString()
        PRICE = intent.getStringExtra("PRICE").toString()
        DETAIL = intent.getStringExtra("DETAIL").toString()
        SRC = intent.getIntExtra("SRC",0)

        var tvPenName:TextView = findViewById(R.id.tv_pen_name)
        tvPenName.text = NAME
        var tvPenPrice:TextView = findViewById(R.id.tv_pen_price)
        tvPenPrice.text = "Rp.$PRICE"
        var tvDetailPen:TextView = findViewById(R.id.tv_pen_detail)
        tvDetailPen.text = DETAIL
        var imgPen: ImageView = findViewById(R.id.img_pen)
        Glide.with(this)
                .load(SRC)
                .into(imgPen)

        var btnBuy: Button = findViewById(R.id.btn_buy)
        btnBuy.setOnClickListener {
            Toast.makeText(this, "Beli $NAME", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@DetailPen, LottieSuccess::class.java))
        }
    }
}
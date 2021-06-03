package com.example.tokopen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPens: RecyclerView
    private var cardList: ArrayList<Pen> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPens = findViewById(R.id.rv_pens)
        rvPens.setHasFixedSize(true)

        cardList.addAll(PenObj.listPen)

        showRecycler()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun showRecycler() {
        rvPens.layoutManager = LinearLayoutManager(this)
        val cardPenAdater = CardViewPenAdapter(cardList)
        rvPens.adapter = cardPenAdater

        cardPenAdater.setOnItemClickCallback(object : CardViewPenAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Pen) {
                showSelectedHero(data)
            }
        })
    }

    private fun setMode(itemId: Int) {
        when(itemId) {
            R.id.item_about -> {
                startActivity(Intent(this@MainActivity,About::class.java))
            }
        }
    }

    private fun showSelectedHero(pen: Pen) {
        var intent = Intent(this@MainActivity, DetailPen::class.java)
        intent.putExtra("NAME", pen.name)
        intent.putExtra("PRICE", pen.price)
        intent.putExtra("DETAIL", pen.detail)
        intent.putExtra("SRC", pen.src)
        startActivity(intent)
    }

}
package com.example.tokopen.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.tokopen.ui.lottie.LottieSuccessActivity
import com.example.tokopen.R
import com.example.tokopen.databinding.ActivityDetailPenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPenActivity : AppCompatActivity() {


    private val binding: ActivityDetailPenBinding by lazy {
        ActivityDetailPenBinding.inflate(layoutInflater)
    }

    private val viewModel: DetailViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        fetchPenDetail()
        setPenDetail()
        onActionButton()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onItemMenuSelected(item)
        return super.onOptionsItemSelected(item)
    }

    private fun onItemMenuSelected(item: MenuItem) {
        when (item.itemId) {
            R.id.action_share -> {
                Toast.makeText(this, "Berhasil membagikan ${viewModel.name}", Toast.LENGTH_SHORT)
                    .show()

            }
            R.id.action_add_cart -> {
                Toast.makeText(
                    this,
                    "Berhasil menambahkan ${viewModel.name} ke keranjang",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun onActionButton() {
        binding.btnBuy.setOnClickListener {
            Toast.makeText(this, "Beli ${viewModel.name}", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@DetailPenActivity, LottieSuccessActivity::class.java))
        }
    }

    private fun setPenDetail() {
        with(binding) {
            tvPenName.text = viewModel.name
            tvPenPrice.text = "Rp.${viewModel.price}"
            tvPenDetail.text = viewModel.desc
            Glide.with(this@DetailPenActivity).load(viewModel.src).into(imgPen)
        }
    }

    private fun fetchPenDetail() {
        viewModel.processIntent(intent)
    }

    companion object {
        const val NAME = "name"
        const val PRICE = "price"
        const val DETAIL = "detail"
        const val SRC = "src"
    }
}
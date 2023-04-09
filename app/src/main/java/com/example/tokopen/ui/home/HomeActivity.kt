package com.example.tokopen.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tokopen.R
import com.example.tokopen.databinding.ActivityHomeBinding
import com.example.tokopen.domain.model.Pen
import com.example.tokopen.ui.about.AboutActivity
import com.example.tokopen.ui.detail.DetailPenActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private val viewModel: HomeViewModel by viewModels()

    private val pensAdapter: CardViewPenAdapter by lazy {
        CardViewPenAdapter().apply {
            setOnItemClickCallback(object : CardViewPenAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Pen) {
                    showSelectedPen(data)
                }
            })
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        fetchPens()
        observe()
    }

    private fun fetchPens() {
        viewModel.fetchAllPens()
    }

    private fun observe() {
        observeState()
        observePens()
    }

    private fun observePens() {
        viewModel.mPens.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach {pens ->
                handlePens(pens)
            }
            .launchIn(lifecycleScope)
    }

    private fun handlePens(pens: List<Pen>) {
        pensAdapter.setList(pens)
    }

    private fun observeState() {
        viewModel.mState.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { state ->
                handleState(state)
            }
            .launchIn(lifecycleScope)
    }

    private fun handleState(state: HomeUiState) {
        when(state) {
            HomeUiState.Init -> Unit
            is HomeUiState.IsLoading -> handleLoading(state.isLoading)
            is HomeUiState.ShowToast -> showToast(state.message)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun handleLoading(loading: Boolean) {
        if(loading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun setupRecyclerView() {
        binding.rvPens.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = pensAdapter
            setHasFixedSize(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onItemMenuSelected(item.itemId)
        return super.onOptionsItemSelected(item)
    }


    private fun onItemMenuSelected(itemId: Int) {
        when (itemId) {
            R.id.item_about -> {
                startActivity(Intent(this@HomeActivity, AboutActivity::class.java))
            }
        }
    }

    private fun showSelectedPen(pen: Pen) {
        Intent(this@HomeActivity, DetailPenActivity::class.java).also {
            it.apply {
                putExtra(DetailPenActivity.NAME, pen.name)
                putExtra(DetailPenActivity.PRICE, pen.price)
                putExtra(DetailPenActivity.DETAIL, pen.detail)
                putExtra(DetailPenActivity.SRC, pen.src)
            }
            startActivity(it)
        }


    }

}
package com.test.marvelapptest.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.test.marvelapptest.R
import com.test.marvelapptest.ui.common.calculateColumsForGridLayout
import com.test.marvelapptest.ui.common.startActivity
import com.test.marvelapptest.databinding.ActivityHomeBinding
import com.test.marvelapptest.network.ManageNetworkManager
import com.test.marvelapptest.ui.paging.ResultsLoadStateAdapter
import com.test.marvelapptest.ui.common.ServiceLocator
import com.test.marvelapptest.ui.common.isOnline
import com.test.marvelapptest.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val networkRepository by lazy {
        ServiceLocator.provideNetworkRepository(
            applicationContext
        )
    }

    private lateinit var binding: ActivityHomeBinding
    private val adapter = CharacterListAdapter {
            if(isOnline()) startActivity<DetailActivity>(DetailActivity.CHARACTER_ID to it.id)
    }



    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manageNetworkManager()

        adapterPreference()
        initList()
        getListeners()

    }

    fun getListeners() {
        binding.btnRefresh.setOnClickListener {
            initList()
        }
    }

    private fun adapterPreference() {

        val columns = calculateColumsForGridLayout(resources.getDimension(R.dimen.avatar_width))
        val layoutManager = GridLayoutManager(this@HomeActivity, columns)
        val footerAdapter = ResultsLoadStateAdapter(adapter::retry)

        binding.apply {
            mainHeroList.layoutManager = layoutManager
            mainHeroList.adapter = adapter.withLoadStateFooter(footerAdapter)
        }

            // This helps to centre the ProgressBar by using the number of columns from the main list
            layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (position == adapter.itemCount && footerAdapter.itemCount > 0) {
                        columns
                    } else {
                        1
                    }
                }
            }
    }

    fun initList() {
        val footerAdapter = ResultsLoadStateAdapter { adapter.retry() }
        binding.mainHeroList.adapter = adapter.withLoadStateFooter(footerAdapter)
        lifecycleScope.launchWhenStarted {
            viewModel.apiData().collectLatest {
                it.let {
                    adapter.submitData(it)
                }
            }
        }

        adapter.addLoadStateListener {
            binding.pb.isVisible = it.refresh is LoadState.Loading
        }
    }
    //  Internet Connection
    private fun manageNetworkManager() {
        lifecycleScope.launchWhenStarted {
            ManageNetworkManager(networkRepository).invoke(lifecycle, ::shouldShowOfflineIcon)
        }
    }

    /**
     * If the visibility suddenly changes when we had already changed it a few seconds ago,
     * we need to wait to avoid race conditions.
     */
    private fun shouldShowOfflineIcon(internetAvailable: Boolean) {
        lifecycleScope.launchWhenStarted {
            delay(200)
            binding.icInternet.isVisible = !internetAvailable

        }
    }


}
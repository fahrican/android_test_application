package com.revolut.androidtestapplication.ui.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import com.revolut.androidtestapplication.R
import com.revolut.androidtestapplication.di.DaggerAppComponent
import com.revolut.androidtestapplication.ui.adapter.CurrencyAdapter
import com.revolut.androidtestapplication.viewmodel.CurrencyViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var currencyAdapter: CurrencyAdapter

    private val viewModel: CurrencyViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerAppComponent.create().inject(this)

        Observable.interval(0,1, TimeUnit.SECONDS)
            .timeInterval()
            .observeOn(AndroidSchedulers.mainThread()) //todo: maybe remove that
            .subscribe { viewModel.repository.fetchCurrencies() }

        setUpRecyclerView()

        observeLiveData()
    }

    override fun onPause() {
        super.onPause()
        viewModel.compositeDisposable.clear()
    }

    private fun setUpRecyclerView() {
        recycler_view.apply {
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = currencyAdapter
        }
    }

    private fun observeLiveData() {
        observeInProgress()
        observeIsError()
        observeCurrencies()
    }

    private fun observeInProgress() {
        viewModel.repository.isInProgress.observe(this, Observer { isLoading ->
            isLoading.let {
                if (it) {
                    error_text.visibility = View.GONE
                    recycler_view.visibility = View.GONE
                    fetch_progress.visibility = View.VISIBLE
                } else {
                    fetch_progress.visibility = View.GONE
                }
            }
        })
    }

    private fun observeIsError() {
        viewModel.repository.isError.observe(this, Observer { isError ->
            isError.let {
                if (it) {
                    disableViewsOnError()
                } else {
                    error_text.visibility = View.GONE
                    fetch_progress.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun disableViewsOnError() {
        fetch_progress.visibility = View.VISIBLE
        error_text.visibility = View.VISIBLE
        recycler_view.visibility = View.GONE
        currencyAdapter.setUpCurrencies(emptyList())
        fetch_progress.visibility = View.GONE
    }

    private fun observeCurrencies() {
        viewModel.repository.currencies.observe(this, Observer { currencies ->
            currencies.let {
                if (it != null && it.isNotEmpty()) {
                    fetch_progress.visibility = View.VISIBLE
                    recycler_view.visibility = View.VISIBLE
                    currencyAdapter.setUpCurrencies(it)
                    error_text.visibility = View.GONE
                    fetch_progress.visibility = View.GONE
                } else {
                    disableViewsOnError()
                }
            }
        })
    }

}

package com.samiroispov.cbrcurrency.ui.main.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.samiroispov.cbrcurrency.R
import com.samiroispov.cbrcurrency.data.model.ValuteProperties
import com.samiroispov.cbrcurrency.ui.main.presenter.MainPresenterMvp
import com.samiroispov.cbrcurrency.ui.main.view.adapter.MainActivityAdapter
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: MainPresenterMvp

    private var mainAdapter: MainActivityAdapter = MainActivityAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
    }

    private fun initRecycler() {

        rv_currencies.apply {
            presenter.loadData(mainAdapter)
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mainAdapter
        }
    }
}

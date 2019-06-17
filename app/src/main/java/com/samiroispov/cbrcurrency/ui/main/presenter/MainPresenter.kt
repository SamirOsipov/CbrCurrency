package com.samiroispov.cbrcurrency.ui.main.presenter

import android.view.View
import android.widget.Adapter
import com.samiroispov.cbrcurrency.data.network.ApiClient
import com.samiroispov.cbrcurrency.ui.main.view.adapter.MainActivityAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by samirosipov on 17/06/2019
 */
class MainPresenter @Inject constructor(
    private val apiClient: ApiClient,
    private val compositeDisposable: CompositeDisposable
) : MainPresenterMvp {

    override fun loadData(mainAdapter: MainActivityAdapter) {
        compositeDisposable.add(
            apiClient.getCurrencies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { mainAdapter.setData(it.valutes!!) }

        )
    }

}
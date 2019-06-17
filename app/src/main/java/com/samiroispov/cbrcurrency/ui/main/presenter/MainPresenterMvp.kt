package com.samiroispov.cbrcurrency.ui.main.presenter

import android.view.View
import com.samiroispov.cbrcurrency.ui.main.view.adapter.MainActivityAdapter

/**
 * Created by samirosipov on 17/06/2019
 */
interface MainPresenterMvp {

    fun loadData(mainAdapter: MainActivityAdapter)
}
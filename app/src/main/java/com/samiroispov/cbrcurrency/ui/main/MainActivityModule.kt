package com.samiroispov.cbrcurrency.ui.main

import com.samiroispov.cbrcurrency.ui.main.presenter.MainPresenter
import com.samiroispov.cbrcurrency.ui.main.presenter.MainPresenterMvp
import dagger.Module
import dagger.Provides

/**
 * Created by samirosipov on 17/06/2019
 */
@Module
class MainActivityModule {
    @Provides
    fun providesPresenter(presenter: MainPresenter): MainPresenterMvp = presenter
}
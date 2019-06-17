package com.samiroispov.cbrcurrency.di

import com.samiroispov.cbrcurrency.ui.main.MainActivityModule
import com.samiroispov.cbrcurrency.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by samirosipov on 17/06/2019
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}
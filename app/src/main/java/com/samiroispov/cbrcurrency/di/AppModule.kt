package com.samiroispov.cbrcurrency.di

import android.app.Application
import android.content.Context
import com.samiroispov.cbrcurrency.data.network.ApiClient
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by samirosipov on 17/06/2019
 */
@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    internal fun provideApiHelper(): ApiClient = ApiClient()

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()


}

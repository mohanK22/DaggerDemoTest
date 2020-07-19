package com.example.android.daggerdemo.di

import androidx.lifecycle.ViewModelProvider
import com.example.android.daggerdemo.viewmodels.ViewModelProvidersFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindsViewModelFactory(modelProvidersFactory: ViewModelProvidersFactory): ViewModelProvider.Factory
}
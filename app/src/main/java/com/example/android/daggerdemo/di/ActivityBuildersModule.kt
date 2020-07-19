package com.example.android.daggerdemo.di

import com.example.android.daggerdemo.ui.auth.AuthActivity
import com.example.android.daggerdemo.ui.auth.AuthViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(
        modules = [
            AuthViewModelModule::class
        ]
    )
    abstract fun contributeAuthActivity(): AuthActivity
}
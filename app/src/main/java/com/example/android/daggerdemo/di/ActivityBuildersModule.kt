package com.example.android.daggerdemo.di

import com.example.android.daggerdemo.AuthActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeAuthActivity(): AuthActivity

    companion object{
        @Provides
        fun someString(): String {
            return "Some String Test"
        }
    }
}
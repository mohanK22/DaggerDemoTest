package com.example.android.daggerdemo.di

import dagger.Module
import dagger.Provides

@Module
class AppModule {

    companion object {
        @Provides
        fun someString(): String {
            return "Some String Test"
        }
    }
}
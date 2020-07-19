package com.example.android.daggerdemo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelProvidersFactory @Inject constructor(private val viewModelsMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        // if the viewModel has not been created
        // loop through the allowable keys (aka allowed classes with the @ViewModelKey)
        val creator = viewModelsMap[modelClass] ?: viewModelsMap.asIterable().firstOrNull { entry ->
            // if it's allowed, set the Provider<ViewModel>
            modelClass.isAssignableFrom(entry.key)
            // if this is not one of the allowed keys, throw exception
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        // return the Provider
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
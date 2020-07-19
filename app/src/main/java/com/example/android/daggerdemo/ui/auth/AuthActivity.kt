package com.example.android.daggerdemo.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.example.android.daggerdemo.R
import com.example.android.daggerdemo.viewmodels.ViewModelProvidersFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var someString: String

    @Inject
    lateinit var appLogo: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    lateinit var viewModelProvidersFactory: ViewModelProvidersFactory

    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel =
            ViewModelProviders.of(this, this.viewModelProvidersFactory)[AuthViewModel::class.java]

        Log.i("AuthActivity:onCreate()", someString)
        setLogo()
    }

    private fun setLogo() {
        requestManager
            .load(appLogo)
            .into(imgLoginLogo)
    }
}
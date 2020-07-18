package com.example.android.daggerdemo

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var someString: String

    @Inject
    lateinit var appLogo: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        Log.i("AuthActivity:onCreate()", someString)
        setLogo()
    }

    private fun setLogo() {
        requestManager
            .load(appLogo)
            .into(imgLoginLogo)
    }
}
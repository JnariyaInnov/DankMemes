package com.gelostech.dankmemes.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.gelostech.dankmemes.R
import com.gelostech.dankmemes.commoners.BaseActivity
import com.gelostech.dankmemes.fragments.LoginFragment
import com.gelostech.dankmemes.utils.addFragment
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity() {
    private var doubleBackToExit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        addFragment(LoginFragment(), loginHolder.id)

    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
        } else {
            if (doubleBackToExit) {
                super.onBackPressed()
            } else {
                toast("Tap back again to exit")

                doubleBackToExit = true

                Handler().postDelayed({doubleBackToExit = false}, 1500)
            }
        }
    }
}
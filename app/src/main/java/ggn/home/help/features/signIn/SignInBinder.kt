package ggn.home.help.features.signIn

import android.databinding.ObservableField
import android.view.View

interface SignInBinder {

    /**
     * @return username string bind with username edit text.
     */
    val username: ObservableField<String>

    /**
     * @return password string bind with password edit text.
     */
    val password: ObservableField<String>

    /**
     * login clicked

     * @param view
     */
    fun signInClicked(view: View)
}

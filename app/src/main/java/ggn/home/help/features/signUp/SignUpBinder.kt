package ggn.home.help.features.signUp

import android.databinding.ObservableField
import android.view.View

interface SignUpBinder {

    val username: ObservableField<String>
    val mobile: ObservableField<String>
    val password: ObservableField<String>
    val confirmPassword: ObservableField<String>

    fun signUpClicked(view: View)
}

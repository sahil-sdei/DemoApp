package ggn.home.help.features.signUp

import android.view.View
import ggn.home.help.features.base.Viewable
import ggn.home.help.features.signIn.SignUpPresenter
import ggn.home.help.web.models.User

interface SignUpView : Viewable<SignUpPresenter> {
    fun hideKeyboard(view: View)
    fun saveDataLocally(output: User)
}
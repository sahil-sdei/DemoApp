package ggn.home.help.features.signIn

import android.view.View
import ggn.home.help.features.base.Viewable
import ggn.home.help.web.models.User

interface SignInView : Viewable<SignInPresenter> {
    fun hideKeyboard(view: View)
    fun saveDataLocally(output: User)
}
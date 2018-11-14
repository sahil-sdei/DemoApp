package ggn.home.help.features.splash

import android.os.Handler
import ggn.home.help.features.base.BasePresenter

/**
 * Created by sahilsa on 14/11/18.
 */
class SplashPresenter : BasePresenter<SplashView>() , Runnable{
    private var isNotLoggedIn: Boolean = false

    fun splashCheck() {
        isNotLoggedIn = view.localData.userId.isEmpty()
        Handler().postDelayed(this, view.splashTimer())
    }

    override fun run() {
        if (isNotLoggedIn)
            view.openDashBoard()
        else
            view.showOptions()
    }
}
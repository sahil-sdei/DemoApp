package ggn.home.help.features.splash

import ggn.home.help.features.base.Viewable

/**
 * Created by sahilsa on 14/11/18.
 */
interface SplashView : Viewable<SplashPresenter> {
    fun splashTimer(): Long
    fun showOptions()
    fun openDashBoard()
}
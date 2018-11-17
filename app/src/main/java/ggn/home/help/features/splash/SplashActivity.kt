package ggn.home.help.features.splash

import android.content.Context
import ggn.home.help.R
import ggn.home.help.features.base.BaseActivityNoBinding
import ggn.home.help.features.signIn.SignInActivity

/**
 * Created by sahilsa on 14/11/18.
 */
class SplashActivity : BaseActivityNoBinding<SplashPresenter>(), SplashView {

    val SPLASH_TIMER = 3000

    override fun getActivityG(): Context {
        return this@SplashActivity
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun onCreateActivityG() {
        injectPresenter(SplashPresenter())
        getPresenter().attachView(this)
        presenter.splashCheck()
    }

    override fun initViews() {
    }

    override fun splashTimer(): Long {
        return SPLASH_TIMER.toLong()
    }

    override fun showOptions() {
        SignInActivity.start(activityG)
        finish()
    }

    override fun openDashBoard() {
        SignInActivity.start(activityG)
        finish()
    }
}
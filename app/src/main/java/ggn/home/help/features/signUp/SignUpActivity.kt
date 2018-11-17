package ggn.home.help.features.signUp

import android.content.Context
import android.content.Intent
import android.text.method.PasswordTransformationMethod
import android.view.MenuItem
import android.view.View
import ggn.home.help.R
import ggn.home.help.databinding.ActivitySignUpBinding
import ggn.home.help.features.base.BaseActivity
import ggn.home.help.features.signIn.SignInActivity
import ggn.home.help.features.signIn.SignUpPresenter
import ggn.home.help.utils.UtillsG
import ggn.home.help.web.models.User


class SignUpActivity : BaseActivity<ActivitySignUpBinding, SignUpPresenter>(), SignUpView, View.OnClickListener {

    override fun setLayoutId(): Int {
        return R.layout.activity_sign_up
    }

    override fun onCreateActivityG() {
        injectPresenter(SignUpPresenter())
        getPresenter().attachView(this)
    }

    override fun getActivityG(): Context {
        return this@SignUpActivity
    }

    override fun initViews() {
        setupToolbarTransparent()

        dataBinder.binder = getPresenter()

        dataBinder.editTextPassword.transformationMethod = PasswordTransformationMethod()
        dataBinder.textViewLogin.setOnClickListener(this)
    }

    override fun hideKeyboard(view: View) {
        UtillsG.hideKeyboard(activityG, view)
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, SignUpActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.textViewLogin-> {
                signIn(view)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun signIn(view: View) {
        SignInActivity.start(activityG)
        finish()
    }

    override fun saveDataLocally(output: User) {
        localData.setUserData(output)
        this.finish()
    }
}

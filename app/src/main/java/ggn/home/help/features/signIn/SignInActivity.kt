package ggn.home.help.features.signIn

import android.content.Context
import android.content.Intent
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.facebook.CallbackManager
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.DEFAULT_SIGN_IN
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import ggn.home.help.R
import ggn.home.help.databinding.ActivitySignInBinding
import ggn.home.help.features.base.BaseActivity
import ggn.home.help.utils.UtillsG
import ggn.home.help.web.models.User
import java.util.*


class SignInActivity : BaseActivity<ActivitySignInBinding, SignInPresenter>(), SignInView, View.OnClickListener {

    var callbackManager: CallbackManager? = null
    var mGoogleSignInClient: GoogleSignInClient? = null
    var RC_SIGN_IN = 100

    override fun setLayoutId(): Int {
        return R.layout.activity_sign_in
    }

    override fun onCreateActivityG() {
        injectPresenter(SignInPresenter())
        getPresenter().attachView(this)

        buildGoogleAPIClient()
    }

    override fun getActivityG(): Context {
        return this@SignInActivity
    }

    override fun initViews() {
        setupToolbarTransparent()
        callbackManager = CallbackManager.Factory.create()
        dataBinder.loginButton.setReadPermissions(Arrays.asList("public_profile", "email", "user_birthday"))
        dataBinder.loginButton.registerCallback(callbackManager, getPresenter().getFbCallback())
        LoginManager.getInstance().logOut()

        dataBinder.binder = getPresenter()

        dataBinder.editTextPassword.transformationMethod = PasswordTransformationMethod()
        dataBinder.textViewRegister.setOnClickListener(this)
        dataBinder.textViewForgotPassword.setOnClickListener(this)
        dataBinder.buttonFacebook.setOnClickListener(this)
    }

    fun buildGoogleAPIClient() {
        val gso = Builder(DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(activityG, gso)
    }

    fun googleSignIn(view: View) {
        val signInIntent = mGoogleSignInClient?.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun hideKeyboard(view: View) {
        UtillsG.hideKeyboard(activityG, view)
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, SignInActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.textViewRegister -> {
                signUp(view)
            }
            R.id.textViewForgotPassword -> {
//                ForgotPasswordActivity.Companion.start(activityG)
            }
            R.id.buttonFacebook -> {
                dataBinder.loginButton.performClick()
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

    fun signUp(view: View) {
//        SignUpActivity.Companion.start(activityG)
        finish()
    }

    override fun onStart() {
        super.onStart()
//        val account = GoogleSignIn.getLastSignedInAccount(activityG)
//        Toast.makeText(activityG, account?.displayName, Toast.LENGTH_SHORT).show()
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }else{
            callbackManager?.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            getPresenter().signInGoogle(account)
        } catch (e: ApiException) {
            Log.w(SignInActivity.javaClass.name, "signInResult:failed code=" + e.statusCode)
        }

    }

    override fun saveDataLocally(output: User) {
        localData.setUserData(output)
        this.finish()
    }
}

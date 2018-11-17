package ggn.home.help.features.signIn

import android.databinding.ObservableField
import android.os.Bundle
import android.view.View
import com.facebook.*
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import ggn.home.help.R
import ggn.home.help.features.base.BasePresenter

class SignInPresenter : BasePresenter<SignInView>(), SignInBinder {
    override val username = ObservableField<String>()
    override var password = ObservableField<String>()

    init {
        username.set("")
        password.set("")
    }

    override fun signInClicked(view: View) {
        if (username.get().isEmpty()) {
            getView().displayError(getView().activityG.getString(R.string.please_enter_email))
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(username.get()).matches()) {
            getView().displayError(getView().activityG.getString(R.string.please_enter_valid_email))
        } else if (password.get().isEmpty()) {
            getView().displayError(getView().activityG.getString(R.string.please_enter_password))
        } else {
            getView().hideKeyboard(view)
//            getView().showLoading(getView().activityG.getString(R.string.validating_user), getView().activityG.getString(R.string.please_wait))
//            createApiRequest(getRetrofitInstance(LoginSignUpAPI::class.java)
//                    .signIn(username.get(), password.get(), FirebaseInstanceId.getInstance().token, "ANDROID", "mobile", getView().activityG.getString(R.string.client_id)), object : CallBackG<BasicApiDataModel<User>> {
//                override fun callBack(output: BasicApiDataModel<User>) {
//                    getView().hideLoading()
//                    if (output.error == null)
//                        getView().saveDataLocally(output.data as User)
//                    else
//                        getView().displayError((output.error as Error).message)
//                }
//            })
        }
    }

    fun signInGoogle(account: GoogleSignInAccount?) {
//        view.showLoading(view.activityG.getString(R.string.loading), view.activityG.getString(R.string.please_wait))
//        createApiRequest(getRetrofitInstance(LoginSignUpAPI::class.java)
//                .signInGoogle(account?.givenName, account?.familyName, account?.id, account?.email, "google", "mobile", "0", "0", view.activityG.getString(R.string.client_id)), object : CallBackG<BasicApiDataModel<User>> {
//            override fun callBack(output: BasicApiDataModel<User>) {
//                view.hideLoading()
//                if (output.error == null)
//                    view.saveDataLocally(output.data as User)
//                else
//                    view.displayError((output.error as Error).message)
//            }
//        })
    }

    fun getFbCallback(): FacebookCallback<LoginResult> {
        return object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                view.showLoading(view.activityG.getString(R.string.fetching_facebook_information), view.activityG.getString(R.string.please_wait))
                val request = GraphRequest.newMeRequest(
                        loginResult.accessToken
                ) { `object`, response ->
                    try {
                        view.hideLoading()
                        val token = AccessToken.getCurrentAccessToken()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                val parameters = Bundle()
                parameters.putString("fields", "id,name,email")
                request.parameters = parameters
                request.executeAsync()

            }

            override fun onCancel() {

            }

            override fun onError(error: FacebookException) {
                view.displayError(error.message)
            }
        }
    }
}

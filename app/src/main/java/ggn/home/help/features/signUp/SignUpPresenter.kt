package ggn.home.help.features.signIn

import android.databinding.ObservableField
import android.view.View
import ggn.home.help.R
import ggn.home.help.features.base.BasePresenter
import ggn.home.help.features.signUp.SignUpBinder
import ggn.home.help.features.signUp.SignUpView

class SignUpPresenter : BasePresenter<SignUpView>(), SignUpBinder {
    override val username = ObservableField<String>()
    override val mobile = ObservableField<String>()
    override var password = ObservableField<String>()
    override val confirmPassword = ObservableField<String>()

    init {
        username.set("")
        mobile.set("")
        password.set("")
        confirmPassword.set("")
    }

    override fun signUpClicked(view: View) {
        if (username.get().isEmpty()) {
            getView().displayError(getView().activityG.getString(R.string.please_enter_email))
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(username.get()).matches()) {
            getView().displayError(getView().activityG.getString(R.string.please_enter_valid_email))
        } else if (mobile.get().length < 10) {
            getView().displayError(getView().activityG.getString(R.string.please_enter_valid_mobile_number))
        } else if (!android.util.Patterns.PHONE.matcher(mobile.get()).matches()) {
            getView().displayError(getView().activityG.getString(R.string.please_enter_valid_mobile_number))
        } else if (password.get().isEmpty()) {
            getView().displayError(getView().activityG.getString(R.string.please_enter_password))
        } else if (confirmPassword.get().isEmpty()) {
            getView().displayError(getView().activityG.getString(R.string.password_does_not_match_the_confirm_password))
        } else if (!confirmPassword.get().equals(password.get(), true)) {
            getView().displayError(getView().activityG.getString(R.string.password_does_not_match_the_confirm_password))
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
}

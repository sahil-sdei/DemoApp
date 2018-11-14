package ggn.home.help.utils

import android.content.Context
import android.support.v7.app.AlertDialog
import android.text.TextUtils
import com.efarmx.app.utils.CallBackG
import ggn.home.help.R

class DialogHelper private constructor() {

    fun showInformation(context: Context, title: String, message: String, callBackG: CallBackG<String>) {
        val builder = AlertDialog.Builder(context, R.style.AppCompatAlertDialogStyle)
        if (!TextUtils.isEmpty(title))
            builder.setTitle(title)
        builder.setMessage(message)
        builder.setCancelable(false)
        builder.setPositiveButton("Ok") { dialogInterface, i -> callBackG.callBack("") }
        builder.show()
    }

    fun showWithAction(context: Context, title: String, message: String, callBackG: CallBackG<String>) {
        val builder = AlertDialog.Builder(context, R.style.AppCompatAlertDialogStyle)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setCancelable(false)
        builder.setPositiveButton("Ok") { dialogInterface, i -> callBackG.callBack("") }
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }

    fun noInternet(context: Context, callBackG: CallBackG<String>) {
        val builder = AlertDialog.Builder(context, R.style.AppCompatAlertDialogStyle)
//        builder.setTitle(context.getString(R.string.no_internet_connection))
//        builder.setMessage(context.getString(R.string.no_internet_message))
        builder.setCancelable(false)
        builder.setPositiveButton("Ok") { dialogInterface, i -> callBackG.callBack("") }
        builder.show()
    }

    companion object {
        val instance = DialogHelper()
    }
}

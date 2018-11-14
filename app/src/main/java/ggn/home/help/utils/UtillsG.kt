package ggn.home.help.utils

import android.app.Activity
import android.app.ActivityManager
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.net.ConnectivityManager
import android.os.Build
import android.util.DisplayMetrics
import android.util.Pair
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ListView
import android.widget.Toast
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class UtillsG {
    private var toastG: Toast? = null

    /**
     * @param msg    -message to be displayed
     * *
     * @param center - true ,if toast is to be displayed in center,otherwise false.
     */
    fun showToast(msg: String, context: Context, center: Boolean) {
        if (toastG != null) {
            toastG!!.cancel()
        }
        toastG = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
        if (center) {
            toastG!!.setGravity(Gravity.CENTER, 0, 0)
        }
        toastG!!.show()
    }

    /**
     * finish all the activities from stack.(works only in higher versions).
     */
    fun finishAll(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            (context as Activity).finishAffinity()
        } else {
            (context as Activity).finish()
        }
    }

    companion object {
        fun finishAll(context: Context) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                (context as Activity).finishAffinity()
            } else {
                (context as Activity).finish()
            }
        }

        fun hideKeyboard(context: Context, view: View?) {
            if (view != null) {
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }

        fun dpToPx(dp: Float): Int {
            return Math.round(dp * (Resources.getSystem().displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
        }

        fun setListViewHeightBasedOnChildren(listView: ListView) {
            val listAdapter = listView.adapter ?: // pre-condition
                    return

            var totalHeight = 0
            for (i in 0..listAdapter.count - 1) {
                val listItem = listAdapter.getView(i, null, listView)
                listItem.measure(0, 0)
                totalHeight += listItem.measuredHeight
            }

            val params = listView.layoutParams
            params.height = totalHeight + listView.dividerHeight * (listAdapter.count - 1)
            listView.layoutParams = params
            listView.requestLayout()
        }
    }

    /**
     * @param i    -intent to be fired.
     * *
     * @param logo --shareable view. (used shared object for transitions ).
     */
    fun startTransition(activity: Activity, i: Intent, logo: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val options = ActivityOptions.makeSceneTransitionAnimation(activity,
                    Pair.create(logo, Constants.Extras.TRANSITION_NAME_1))
            activity.startActivity(i, options.toBundle())
        } else {
            activity.startActivity(i)
        }
    }

    /**
     * @param i     -intent to be fired.
     * *
     * @param view1 --1st shareable view. (used shared object for transitions ).
     * *
     * @param view2 --2nd shareable view. (used shared object for transitions ).
     */
    fun startTransition(activity: Activity, i: Intent, view1: View, view2: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val p1 = Pair.create(view1, Constants.Extras.TRANSITION_NAME_1)
            val p2 = Pair.create(view2, Constants.Extras.TRANSITION_NAME_2)

            val options = ActivityOptions.makeSceneTransitionAnimation(activity, p1, p2)
            activity.startActivity(i, options.toBundle())
        } else {
            activity.startActivity(i)
        }
    }

    /**
     * @return true, if app is running in foreground.
     */
    fun isAppOnForeground(context: Context): Boolean {
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val appProcesses = activityManager.runningAppProcesses ?: return false
        val packageName = "com.package.name"
        for (appProcess in appProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName == packageName) {
                return true
            }
        }
        return false
    }

    fun getTimeAgo(dateTime: String): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        var dateFromServer: Date? = null
        try {
            dateFromServer = sdf.parse(dateTime)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val dateNow = Date()
        var different = dateNow.time - dateFromServer!!.time

        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24
        val elapsedDays = different / daysInMilli
        different %= daysInMilli
        val elapsedHours = different / hoursInMilli
        different %= hoursInMilli
        val elapsedMinutes = different / minutesInMilli

        val strTimeDifference: String
        if (elapsedDays > 0) {
            strTimeDifference = elapsedDays.toString() + "d"
        } else if (elapsedHours > 0) {
            strTimeDifference = elapsedHours.toString() + "h"
        } else {
            strTimeDifference = elapsedMinutes.toString() + "m"
        }
        return strTimeDifference
    }

    fun dpToPx(dp: Float): Int {
        return Math.round(dp * (Resources.getSystem().displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}

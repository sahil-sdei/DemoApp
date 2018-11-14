package ggn.home.help.utils

import android.content.Context
import android.util.DisplayMetrics

/**
 * Util class for converting between dp, px and other magical pixel units
 */
object PixelUtil {

    fun dpToPx(context: Context, dp: Int): Int {
        val px = Math.round(dp * getPixelScaleFactor(context))
        return px
    }

    fun pxToDp(context: Context, px: Int): Int {
        val dp = Math.round(px / getPixelScaleFactor(context))
        return dp
    }

    private fun getPixelScaleFactor(context: Context): Float {
        val displayMetrics = context.resources.displayMetrics
        return displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT
    }

}
package com.efarmx.app.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateHelper private constructor() {

    fun getFormattedDateOfBirth(date: Date): String {
        return DOB.format(date)
    }

    fun getDateString(date: String, simeSimpleDateFormat: SimpleDateFormat): String {
        try {
            val date1 = serverDate.parse(date)
            return simeSimpleDateFormat.format(date1)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return date
    }

    val currentDateString: String
        get() {
            try {
                return serverDate.format(Date(System.currentTimeMillis()))
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return ""
        }

    val currentDateBasicString: String
        get() {
            try {
                return BasicFormat.format(Date(System.currentTimeMillis()))
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return ""
        }

    fun getFormattedDate(dob: String): Date {
        try {
            return serverDate.parse(dob)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return Date(System.currentTimeMillis())
    }

    fun getFormattedDate(date: String, sdf: SimpleDateFormat): Date {
        try {
            return sdf.parse(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return Date(System.currentTimeMillis())
    }

    fun getFormattedDateOfBirthString(dob: String): Date {
        try {
            return DOB.parse(dob)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return Date(System.currentTimeMillis())
    }

    val currentDateForChat: String
        get() {
            try {
                return serverDate.format(Date(System.currentTimeMillis()))
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return ""
        }

    fun getDateForComment(date: String): String {
        try {
            return COMMENT.format(serverDate.parse(date))
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ""
    }

    fun getDateForNotification(date: String): String {
        try {
            return COMMENT.format(serverDate.parse(date))
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ""
    }

    fun getDateForChat(date: String): String {
        try {
            return CHAT.format(serverDate.parse(date))
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ""
    }

    fun getMyDateFormat(date: String, currentFormat: SimpleDateFormat, postFormater: SimpleDateFormat): String {
        val finalDate: String
        var dateObj: Date? = null
        try {
            dateObj = currentFormat.parse(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        if (dateObj != null)
            finalDate = postFormater.format(dateObj)
        else
            finalDate = ""
        return finalDate
    }

    fun getMyDateFormatTimeZone(date: String, currentFormat: SimpleDateFormat, postFormater: SimpleDateFormat): String {
        currentFormat.timeZone = TimeZone.getTimeZone("UTC")
        val parsed = currentFormat.parse(date)
        val tz = TimeZone.getDefault()
        postFormater.timeZone = tz
        return postFormater.format(parsed)
    }

    companion object {
        var serverDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        var onlyHoursFormat = SimpleDateFormat("hh:mm a")
        var DOB = SimpleDateFormat("dd MMM, yyyy")
        var DOBHR = SimpleDateFormat("dd MMM, yyyy HH:mm")
        var DOBHMA = SimpleDateFormat("dd MMM, yyyy hh:mm a")
        var COMMENT = SimpleDateFormat("MMMM dd, hh:mm a")
        var CHAT = SimpleDateFormat("MMMM dd, hh:mm a")
        var HoursFormat24 = SimpleDateFormat("HH:mm")
        var BasicFormat = SimpleDateFormat("dd/MM/yyyy")
        var BasicFormatHyphen = SimpleDateFormat("yyyy-MM-dd")

        val instance = DateHelper()
    }
}

package com.efarmx.app.web

class BasicApiDataModel<T> {

    var data: T? = null

    var message: String? = null

    var code: Int? = 0

    val success: Boolean = false

    var error: Error? = null
}

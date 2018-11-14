package com.efarmx.app.web

class BasicApiListModel<T> {

    var data: List<T>? = null

    var message: String? = null

    var code: Int? = 0

    val success: Boolean = false

    var error: Error? = null
}

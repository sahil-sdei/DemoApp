package com.efarmx.app.web

import java.io.Serializable

class Error : Serializable{
    var code: Int = 0
    var message: String? = null
    var key: String? = null
}

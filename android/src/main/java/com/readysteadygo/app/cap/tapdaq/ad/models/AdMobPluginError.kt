/*
package com.readysteadygo.app.cap.tapdaq.ad.models;

import com.facebook.ads.AdError
import com.getcapacitor.JSObject
import com.google.android.gms.ads.AdError

data class AdMobPluginError(val code: Int, val message: String) : JSObject() {
    override fun put(key: String, value: Int): JSObject {
        throw Exception("Do not put elements directly here use the constructor")
    }
    init {
        super.put("code", this.code)
        super.put("message", this.message)
    }
    constructor(adError: AdError): this(adError.code, adError.message)
}
*/

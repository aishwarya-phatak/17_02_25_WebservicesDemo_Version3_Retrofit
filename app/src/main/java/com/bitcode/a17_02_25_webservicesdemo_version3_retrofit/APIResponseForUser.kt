package com.bitcode.a17_02_25_webservicesdemo_version3_retrofit

import com.google.gson.annotations.SerializedName

data class APIResponseForUser(
    @SerializedName("data")
    var user : User,

    var support: Support
)

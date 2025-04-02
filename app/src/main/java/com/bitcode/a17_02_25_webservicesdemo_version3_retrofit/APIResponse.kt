package com.bitcode.a17_02_25_webservicesdemo_version3_retrofit

import com.google.gson.annotations.SerializedName

data class APIResponse(
    var page : Int,

    @SerializedName("per_page")
    var perPage : Int,

    var total : Int,

    @SerializedName("total_pages")
    var totalPages : Int,

    @SerializedName("data")
    var users : ArrayList<User>,

    var support : Support

)

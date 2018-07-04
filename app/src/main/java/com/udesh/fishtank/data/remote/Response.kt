package com.udesh.fishtank.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Response(
        @SerializedName("channel") @Expose val channel: Channel,
        @SerializedName("feeds") @Expose val feeds: List<Feed>? = null
)
package com.udesh.fishtank.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Feed(
        @SerializedName("created_at") @Expose val createdAt: String,
        @SerializedName("entry_id") @Expose val entryId: Int,
        @SerializedName("field1") @Expose val waterLevel: String? = null,
        @SerializedName("field2") @Expose val pressure: String? = null,
        @SerializedName("field3") @Expose val ph: String? = null,
        @SerializedName("field4") @Expose val o2: String? = null,
        @SerializedName("field5") @Expose val temperature: String? = null,
        @SerializedName("field6") @Expose val foodLeft: String? = null
)
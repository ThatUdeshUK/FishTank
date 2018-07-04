package com.udesh.fishtank.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Channel (
        @SerializedName("id") @Expose val id: Int,
        @SerializedName("name") @Expose val name: String,
        @SerializedName("updated_at") @Expose val updatedAt: String,
        @SerializedName("last_entry_id") @Expose val lastEntryId: Int
)
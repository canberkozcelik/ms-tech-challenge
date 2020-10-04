package com.marleyspoon.techchallenge.data.model
import com.google.gson.annotations.SerializedName

data class SingleEntryResponse(
    @SerializedName("fields")
    val fields: Fields?,
    @SerializedName("sys")
    val sys: Sys?
) {
    data class Fields(
        @SerializedName("name")
        val name: String?
    )

    data class Sys(
        @SerializedName("contentType")
        val contentType: ContentType?,
        @SerializedName("createdAt")
        val createdAt: String?,
        @SerializedName("environment")
        val environment: Environment?,
        @SerializedName("id")
        val id: String?,
        @SerializedName("locale")
        val locale: String?,
        @SerializedName("revision")
        val revision: Int?,
        @SerializedName("space")
        val space: Space?,
        @SerializedName("type")
        val type: String?,
        @SerializedName("updatedAt")
        val updatedAt: String?
    ) {
        data class ContentType(
            @SerializedName("sys")
            val sys: Sys?
        ) {
            data class Sys(
                @SerializedName("id")
                val id: String?,
                @SerializedName("linkType")
                val linkType: String?,
                @SerializedName("type")
                val type: String?
            )
        }

        data class Environment(
            @SerializedName("sys")
            val sys: Sys?
        ) {
            data class Sys(
                @SerializedName("id")
                val id: String?,
                @SerializedName("linkType")
                val linkType: String?,
                @SerializedName("type")
                val type: String?
            )
        }

        data class Space(
            @SerializedName("sys")
            val sys: Sys?
        ) {
            data class Sys(
                @SerializedName("id")
                val id: String?,
                @SerializedName("linkType")
                val linkType: String?,
                @SerializedName("type")
                val type: String?
            )
        }
    }
}
package com.marleyspoon.techchallenge.data.model
import com.google.gson.annotations.SerializedName


data class SingleAssetResponse(
    @SerializedName("fields")
    val fields: Fields?,
    @SerializedName("sys")
    val sys: Sys?
) {
    data class Fields(
        @SerializedName("file")
        val `file`: File?,
        @SerializedName("title")
        val title: String?
    ) {
        data class File(
            @SerializedName("contentType")
            val contentType: String?,
            @SerializedName("details")
            val details: Details?,
            @SerializedName("fileName")
            val fileName: String?,
            @SerializedName("url")
            val url: String?
        ) {
            data class Details(
                @SerializedName("image")
                val image: Image?,
                @SerializedName("size")
                val size: Int?
            ) {
                data class Image(
                    @SerializedName("height")
                    val height: Int?,
                    @SerializedName("width")
                    val width: Int?
                )
            }
        }
    }

    data class Sys(
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
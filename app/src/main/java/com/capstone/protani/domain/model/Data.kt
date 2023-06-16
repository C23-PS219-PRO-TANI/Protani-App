package com.capstone.protani.domain.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("current_page")
    val currentPage: Int, // 1
    @SerializedName("data")
    val data: List<DataX>,
    @SerializedName("first_page_url")
    val firstPageUrl: String, // http://ajakan.xyz/api/user-loc/all?page=1
    @SerializedName("from")
    val from: Int, // 1
    @SerializedName("last_page")
    val lastPage: Int, // 7
    @SerializedName("last_page_url")
    val lastPageUrl: String, // http://ajakan.xyz/api/user-loc/all?page=7
    @SerializedName("links")
    val links: List<Link>,
    @SerializedName("next_page_url")
    val nextPageUrl: String, // http://ajakan.xyz/api/user-loc/all?page=2
    @SerializedName("path")
    val path: String, // http://ajakan.xyz/api/user-loc/all
    @SerializedName("per_page")
    val perPage: String, // 10
    @SerializedName("prev_page_url")
    val prevPageUrl: Any, // null
    @SerializedName("to")
    val to: Int, // 10
    @SerializedName("total")
    val total: Int // 63
)
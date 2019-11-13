package com.example.contactsapp
import com.google.gson.annotations.SerializedName

data class ContactModel(
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("picture")
    val picture: String? = null
)
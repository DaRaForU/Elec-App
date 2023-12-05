package kh.edu.rupp.ite.elec_app.model.model

import com.google.gson.annotations.SerializedName

data class ListProducts1(
    val name:String,
    val image: String,
    val price: String,
    val description: String,
    @SerializedName("image_detail")
    val imageDetail: String
)

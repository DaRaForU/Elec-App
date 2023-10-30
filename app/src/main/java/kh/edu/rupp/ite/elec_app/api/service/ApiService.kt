package kh.edu.rupp.ite.elec_app.api.service

import kh.edu.rupp.ite.elec_app.api.model.ListProducts1
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/98J3VH/data")
    fun loadListProducts1(): Call<List<ListProducts1>>;
}
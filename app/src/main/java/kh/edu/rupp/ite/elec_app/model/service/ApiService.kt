package kh.edu.rupp.ite.elec_app.model.service

import kh.edu.rupp.ite.elec_app.model.model.ListProducts1
import kh.edu.rupp.ite.elec_app.model.model.ListProducts2
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/98J3VH/data")
    suspend fun loadListProducts1(): List<ListProducts1>;

    @GET("/wUJZyi/data")
    suspend fun loadListProducts2(): List<ListProducts2>;
}
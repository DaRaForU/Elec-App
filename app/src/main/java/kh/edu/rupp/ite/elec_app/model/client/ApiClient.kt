package kh.edu.rupp.ite.elec_app.model.client

import kh.edu.rupp.ite.elec_app.model.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient private constructor() {
    companion object{
        private var instant: ApiClient? = null;
        fun get(): ApiClient{
            if(instant == null){
                instant = ApiClient();
            }
            return instant!!;
        }
    }

    //Create retrofit client
    private val httpClient = Retrofit.Builder()
        .baseUrl("https://retoolapi.dev")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    //Create Service Object
    val apiService = httpClient.create(ApiService::class.java);

}
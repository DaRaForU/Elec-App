package kh.edu.rupp.ite.elec_app.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kh.edu.rupp.ite.elec_app.model.model.ApiData
import kh.edu.rupp.ite.elec_app.model.model.ListProducts1
import kh.edu.rupp.ite.elec_app.model.model.ListProducts2
import kh.edu.rupp.ite.elec_app.model.model.Status
import kh.edu.rupp.ite.elec_app.model.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductsViewModel: ViewModel() {

//    For Products1
    private val _products1Data = MutableLiveData<ApiData<List<ListProducts1>>>();
    val products1Data: LiveData<ApiData<List<ListProducts1>>>
        get() = _products1Data
    fun showProducts1(){
        val apiData = ApiData<List<ListProducts1>>(Status.PROCESSING, null);
        _products1Data.postValue(apiData);
        //Create retrofit client
        val httpClient = Retrofit.Builder()
            .baseUrl("https://retoolapi.dev")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        //Create Service Object
        val apiService = httpClient.create(ApiService::class.java);

        //Load ListProduct1 from server
        val task: Call<List<ListProducts1>> = apiService.loadListProducts1();
        task.enqueue(object : Callback<List<ListProducts1>> {
            override fun onResponse(
                call: Call<List<ListProducts1>>,
                response: Response<List<ListProducts1>>
            ) {
                //                Toast.makeText(context, "Provinces list received", Toast.LENGTH_LONG).show();
                if(response.isSuccessful){
                    val apiData = ApiData<List<ListProducts1>>(Status.SUCCESS, response.body());
                    _products1Data.postValue(apiData);
                }else{
                    val apiData = ApiData<List<ListProducts1>>(Status.ERROR, null);
                    _products1Data.postValue(apiData);
                }
            }

            override fun onFailure(call: Call<List<ListProducts1>>, t: Throwable) {
                //                Toast.makeText(context, "Provinces list received", Toast.LENGTH_LONG).show();
                val apiData = ApiData<List<ListProducts1>>(Status.ERROR, null);
                _products1Data.postValue(apiData);
            }

        })
    }


//    For Products2
    private val _products2Data = MutableLiveData<ApiData<List<ListProducts2>>>();
    val products2Data: LiveData<ApiData<List<ListProducts2>>>
        get() = _products2Data
    fun showProducts2(){
        //Create retrofit Client
        val httpClient = Retrofit.Builder()
            .baseUrl("https://retoolapi.dev")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        //Create Service Object
        val apiService = httpClient.create(ApiService::class.java);

        //Load ListProduct1 from server
        val task: Call<List<ListProducts2>> = apiService.loadListProducts2();
        task.enqueue(object : Callback<List<ListProducts2>>{
            override fun onResponse(
                call: Call<List<ListProducts2>>,
                response: Response<List<ListProducts2>>
            ) {
                if(response.isSuccessful){
                    val apiData = ApiData<List<ListProducts2>>(Status.SUCCESS, response.body());
                    _products2Data.postValue(apiData);
                }else{
                    val apiData = ApiData<List<ListProducts2>>(Status.ERROR, null);
                    _products2Data.postValue(apiData);
                }
            }

            override fun onFailure(call: Call<List<ListProducts2>>, t: Throwable) {
                val apiData = ApiData<List<ListProducts2>>(Status.ERROR, null);
                _products2Data.postValue(apiData);
            }

        })
    }
}
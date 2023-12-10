package kh.edu.rupp.ite.elec_app.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kh.edu.rupp.ite.elec_app.model.client.ApiClient
import kh.edu.rupp.ite.elec_app.model.model.ApiData
import kh.edu.rupp.ite.elec_app.model.model.ListProducts1
import kh.edu.rupp.ite.elec_app.model.model.ListProducts2
import kh.edu.rupp.ite.elec_app.model.model.Status
import kh.edu.rupp.ite.elec_app.model.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    val apiClient = ApiClient.get();

    fun showProducts1(){
        var apiData = ApiData<List<ListProducts1>>(Status.PROCESSING, null);
        _products1Data.postValue(apiData);


        //Create api Service
        val apiService = apiClient.apiService;

        //Load ListProduct1 from server
        viewModelScope.launch(Dispatchers.IO) {
            //Processing in the background
            apiData = try {
                val response = apiService.loadListProducts1();
                ApiData<List<ListProducts1>>(Status.SUCCESS, response);
            }catch (ex: Exception){
                Log.e("ited", "Loading Products1 failed!: ${ex.message}");
                ApiData<List<ListProducts1>>(Status.ERROR, null);
            }

            //Processing out the background
            withContext(Dispatchers.Main.immediate){
                _products1Data.postValue(apiData);
            }
        }

        /*val task: Call<List<ListProducts1>> = apiService.loadListProducts1();
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
         */
    }


//    For Products2
    private val _products2Data = MutableLiveData<ApiData<List<ListProducts2>>>();
    val products2Data: LiveData<ApiData<List<ListProducts2>>>
        get() = _products2Data
    fun showProducts2(){
        var apiData = ApiData<List<ListProducts2>>(Status.PROCESSING, null);
        _products2Data.postValue(apiData);

        //Create api Service
        val apiService = apiClient.apiService;

        //Load ListProduct1 from server
        viewModelScope.launch(Dispatchers.IO) {
            //Processing in the background
            apiData = try {
                val response = apiService.loadListProducts2();
                ApiData<List<ListProducts2>>(Status.SUCCESS, response);
            }catch (ex: Exception){
                Log.e("ited", "Loading Products2 failed!: ${ex.message}");
                ApiData<List<ListProducts2>>(Status.ERROR, null);
            }

            //Processing out the background
            withContext(Dispatchers.Main.immediate){
                _products2Data.postValue(apiData);
            }
        }
    }
}
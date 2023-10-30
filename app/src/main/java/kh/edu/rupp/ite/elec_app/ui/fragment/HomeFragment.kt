package kh.edu.rupp.ite.elec_app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kh.edu.rupp.ite.elec_app.R
import kh.edu.rupp.ite.elec_app.api.model.ListProducts1
import kh.edu.rupp.ite.elec_app.api.service.ApiService
import kh.edu.rupp.ite.elec_app.databinding.FragmentHomeBinding
import kh.edu.rupp.ite.elec_app.ui.adapter.ListProducts1Adapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment: Fragment() {
    private lateinit var binding: FragmentHomeBinding;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater);
        return binding.root;
    }

//    Round card view body
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardView = binding.cardBody;
        cardView.setBackgroundResource(R.drawable.bg_card_body);

        loadListProduct1FromServer();
    }


    private fun loadListProduct1FromServer(){
        //Create retrofit client
        val httpClient = Retrofit.Builder()
            .baseUrl("https://retoolapi.dev")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        //Create Service Object
        val apiService = httpClient.create(ApiService::class.java);

        //Load ListProduct1 from server
        val task: Call<List<ListProducts1>> = apiService.loadListProducts1();
        task.enqueue(object : Callback<List<ListProducts1>>{
            override fun onResponse(
                call: Call<List<ListProducts1>>,
                response: Response<List<ListProducts1>>
            ) {
                Toast.makeText(context, "Provinces list received", Toast.LENGTH_LONG).show();
                if(response.isSuccessful){
                    showProductList1(response.body());
                }
            }

            override fun onFailure(call: Call<List<ListProducts1>>, t: Throwable) {
                Toast.makeText(context, "Provinces list received", Toast.LENGTH_LONG).show();
            }

        })
    }

    private fun showProductList1(productList1: List<ListProducts1>?){
        binding.recyclerview1.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        val adapter = ListProducts1Adapter();
        adapter.submitList(productList1);
        binding.recyclerview1.adapter = adapter;
    }

}
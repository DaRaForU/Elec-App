package kh.edu.rupp.ite.elec_app.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kh.edu.rupp.ite.elec_app.R
import kh.edu.rupp.ite.elec_app.model.model.ListProducts1
import kh.edu.rupp.ite.elec_app.model.model.ListProducts2
import kh.edu.rupp.ite.elec_app.model.service.ApiService
import kh.edu.rupp.ite.elec_app.databinding.FragmentHomeBinding
import kh.edu.rupp.ite.elec_app.adapter.ListProducts1Adapter
import kh.edu.rupp.ite.elec_app.adapter.ListProducts2Adapter
import kh.edu.rupp.ite.elec_app.model.model.Status
import kh.edu.rupp.ite.elec_app.viewmodel.ProductsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment: Fragment() {
    private lateinit var binding: FragmentHomeBinding;
    private lateinit var viewModel: ProductsViewModel;
    private val adapter1 = ListProducts1Adapter();
    private val adapter2 = ListProducts2Adapter();

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

        viewModel = ProductsViewModel();

        val cardView = binding.cardBody;
        cardView.setBackgroundResource(R.drawable.bg_card_body);

        //SETUP Recyclerview
        //====================================================================================================================================================================
            //Create layout manager1
        binding.recyclerview1.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            //Create adapter1
        binding.recyclerview1.adapter = adapter1;
        viewModel.showProducts1();
        viewModel.products1Data.observe(viewLifecycleOwner){
            when(it.status){
                Status.PROCESSING -> Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show();
                Status.SUCCESS -> adapter1.submitList(it.data);
                Status.ERROR -> Toast.makeText(context, "Error while load data from server!", Toast.LENGTH_SHORT).show();
            }
        }

        //====================================================================================================================================================================
            //Create layout manager2
        binding.recyclerview2.layoutManager = GridLayoutManager(context, 2);
            //Create adapter2
        binding.recyclerview2.adapter = adapter2;
        viewModel.showProducts2();
        viewModel.products2Data.observe(viewLifecycleOwner){
            when(it.status){
                Status.PROCESSING -> Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
                Status.SUCCESS -> adapter2.submitList(it.data);
                Status.ERROR -> Toast.makeText(context, "Error while load data from server!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
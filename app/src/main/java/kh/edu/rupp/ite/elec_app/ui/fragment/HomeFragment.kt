package kh.edu.rupp.ite.elec_app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kh.edu.rupp.ite.elec_app.databinding.FragmentHomeBinding

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
}
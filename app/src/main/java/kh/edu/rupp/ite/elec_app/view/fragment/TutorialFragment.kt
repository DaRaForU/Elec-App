package kh.edu.rupp.ite.elec_app.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kh.edu.rupp.ite.elec_app.databinding.FragmentTutorialBinding

class TutorialFragment: Fragment() {
    private lateinit var binding: FragmentTutorialBinding;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTutorialBinding.inflate(layoutInflater);
        return binding.root;
    }
}
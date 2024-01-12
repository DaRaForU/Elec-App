package kh.edu.rupp.ite.elec_app.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import kh.edu.rupp.ite.elec_app.databinding.FragmentProfileBinding
import kh.edu.rupp.ite.elec_app.view.activity.SignInActivity

class ProfileFragment: Fragment() {
    private lateinit var binding: FragmentProfileBinding;
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogOut.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(context, SignInActivity::class.java))
        }
    }
}
package kh.edu.rupp.ite.elec_app.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.elec_app.R
import kh.edu.rupp.ite.elec_app.databinding.ActivitySignUpBinding

class SignUpActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val cardView = binding.cardBodySignIn;
        cardView.setBackgroundResource(R.drawable.bg_card_body_sign_in);
    }
}
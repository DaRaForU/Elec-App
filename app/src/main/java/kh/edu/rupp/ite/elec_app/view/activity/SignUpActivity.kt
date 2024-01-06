package kh.edu.rupp.ite.elec_app.view.activity

import android.content.Intent
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

        setUpListener()
    }

    private fun setUpListener(){
        binding.signIn.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}
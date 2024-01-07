package kh.edu.rupp.ite.elec_app.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kh.edu.rupp.ite.elec_app.R
import kh.edu.rupp.ite.elec_app.databinding.ActivitySignInBinding

class SignInActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding;
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater);
        setContentView(binding.root);
        firebaseAuth = FirebaseAuth.getInstance()

        val cardView = binding.cardBodySignIn;
        cardView.setBackgroundResource(R.drawable.bg_card_body_sign_in);

        setUpListener()

    }

    private fun setUpListener(){
        binding.joinNow.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        binding.buttonSignIn.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful){
                        startActivity(Intent(this, MainActivity::class.java))
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "Empty Fields Are not Allowed!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
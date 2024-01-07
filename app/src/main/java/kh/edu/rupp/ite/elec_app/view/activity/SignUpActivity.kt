package kh.edu.rupp.ite.elec_app.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kh.edu.rupp.ite.elec_app.R
import kh.edu.rupp.ite.elec_app.databinding.ActivitySignUpBinding

class SignUpActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding;
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater);
        setContentView(binding.root);
        firebaseAuth = FirebaseAuth.getInstance()


        val cardView = binding.cardBodySignIn;
        cardView.setBackgroundResource(R.drawable.bg_card_body_sign_in);

        setUpListener()
    }

    private fun setUpListener(){
        binding.signIn.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
        binding.buttonSignUp.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            val password2 = binding.editPassword2.text.toString()

            if(username.isNotEmpty()
                && email.isNotEmpty()
                && password.isNotEmpty()
                && password2.isNotEmpty()){
                if(password == password2){
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if(it.isSuccessful){
                            startActivity(Intent(this, SignInActivity::class.java))
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Password is not matching.", Toast.LENGTH_SHORT).show()

                }
            }else{
                Toast.makeText(this, "Empty Fields Are not Allowed!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
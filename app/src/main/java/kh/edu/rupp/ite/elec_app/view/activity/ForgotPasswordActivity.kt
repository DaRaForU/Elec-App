package kh.edu.rupp.ite.elec_app.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kh.edu.rupp.ite.elec_app.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity: AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        setupListener()
    }

    private fun setupListener() {
        binding.icBackForgotPassword.setOnClickListener { finish() }
        binding.buttonSent.setOnClickListener {
            val email = binding.editEmail.text.toString()
            if(email.isNotEmpty()){
                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener {
                    if(it.isSuccessful){
                        startActivity(Intent(this, SignInActivity::class.java))
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
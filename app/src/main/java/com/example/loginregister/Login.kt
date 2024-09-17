package com.example.loginregister

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginregister.databinding.ActivityLoginBinding
import com.example.loginregister.databinding.ActivityMainBinding

class Login : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val name = intent.getStringExtra("extra_name")
        val email = intent.getStringExtra("extra_email")
        val telp = intent.getStringExtra("extra_telp")
        val gender = intent.getStringExtra("extra_gender")
        val psw = intent.getStringExtra("extra_psw")
        with(binding){
            btnLogin.setOnClickListener{
                if(editEmail.text.toString() == email && editPsw.text.toString() == psw){
                    val intentToProfile = Intent(this@Login, Profile::class.java)
                    intentToProfile.putExtra("extra_name", name)
                    intentToProfile.putExtra("extra_email", email)
                    intentToProfile.putExtra("extra_telp", telp)
                    intentToProfile.putExtra("extra_gender", gender)
                    startActivity(intentToProfile)
                } else {
                    Toast.makeText(this@Login,"Email atau password salah", Toast.LENGTH_SHORT).show()
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
package com.example.loginregister

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginregister.databinding.ActivityLoginBinding
import com.example.loginregister.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra("extra_name")
        val email = intent.getStringExtra("extra_email")
        val telp = intent.getStringExtra("extra_telp")
        val gender = intent.getStringExtra("extra_gender")
        with(binding){
            txtVname.text = name
            txtVemail.text = email
            txtVtelp.text = telp
            txtVgender.text = gender
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
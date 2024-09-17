package com.example.loginregister

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginregister.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        with(binding){
            btnRegister.setOnClickListener{
                val intentToLogin = Intent(this@MainActivity, Login::class.java)
                intentToLogin.putExtra("extra_name", editName.text.toString())
                intentToLogin.putExtra("extra_email", editEmail.text.toString())
                intentToLogin.putExtra("extra_telp", editTelp.text.toString())
                intentToLogin.putExtra("extra_gender", editGender.text.toString())
                intentToLogin.putExtra("extra_psw", editPsw.text.toString())
                startActivity(intentToLogin)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
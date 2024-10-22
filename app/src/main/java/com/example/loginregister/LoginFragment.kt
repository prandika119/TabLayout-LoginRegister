package com.example.loginregister

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.loginregister.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.btnLogin.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editPsw.text.toString()
            val sharedPref = requireActivity().getSharedPreferences("DataPengguna", Context.MODE_PRIVATE)
            val savedEmail = sharedPref.getString("email", "")
            val savedPassword = sharedPref.getString("password", "")

            if (email == savedEmail && password == savedPassword) {
                val intent = Intent(context, DashboardActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(context, "Email atau password salah!", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root    }
}
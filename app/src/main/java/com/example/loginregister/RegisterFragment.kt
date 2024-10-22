package com.example.loginregister

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.loginregister.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        with(binding){
            btnRegister.setOnClickListener{
                val name = editName.text.toString()
                val email = editEmail.text.toString()
                val telp = editTelp.text.toString()
                val gender = editGender.text.toString()
                val psw = editPsw.text.toString()
                val sharedPref = requireActivity().getSharedPreferences("DataPengguna", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("name", name)
                    putString("email", email)
                    putString("telp", telp)
                    putString("gender", gender)
                    putString("password", psw)
                    apply()
                }
                val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPager)
                viewPager.currentItem = 0
            }
        }
        return binding.root
    }

}
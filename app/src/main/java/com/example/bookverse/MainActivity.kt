package com.example.bookverse

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.bookverse.databinding.ActivityMainBinding
import com.example.bookverse.fragment.BooksFragment
import com.example.bookverse.fragment.HomeFragment
import com.example.bookverse.fragment.SavedFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        gotoFragment(HomeFragment())

        binding.btnBook.setOnClickListener {
            gotoFragment(BooksFragment())
        }

        binding.btnHome.setOnClickListener {
            gotoFragment(HomeFragment())
        }

        binding.btnSaved.setOnClickListener {
            gotoFragment(SavedFragment())
        }

    }

    private fun gotoFragment(fragment: Fragment){
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.containerFragment, fragment).commit()
    }
}
package com.example.mydashboard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mydashboard.databinding.ActivityFragmentBinding
import com.example.mydashboard.fragments.ChatFragment
import com.example.mydashboard.fragments.HomeFragment
import com.example.mydashboard.fragments.LogoutFragment
import com.example.mydashboard.fragments.ProfileFragment
import com.example.mydashboard.fragments.SettingsFragment
import com.example.mydashboard.fragments.WidgetsFragment

class FragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentTag = intent.getStringExtra("fragmentTag")
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, getFragment(fragmentTag!!))
            .commit()
    }

    private fun getFragment(tag: String): Fragment {
        return when (tag) {
            "HomeFragment" -> HomeFragment()
            "ChatFragment" -> ChatFragment()
            "ProfileFragment" -> ProfileFragment()
            "WidgetsFragment" -> WidgetsFragment()
            "SettingsFragment" -> SettingsFragment()
            "LogoutFragment" -> LogoutFragment()
            else -> HomeFragment()
        }
    }
}
package com.example.mydashboard

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mydashboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var list = mutableListOf(
        GridViewModal(R.drawable.ic_home, "Home"),
        GridViewModal(R.drawable.ic_chat, "Chat"),
        GridViewModal(R.drawable.ic_profile, "Profile"),
        GridViewModal(R.drawable.ic_widgets, "Widgets"),
        GridViewModal(R.drawable.ic_settings, "Settings"),
        GridViewModal(R.drawable.ic_logout, "Logout")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain)
        val adapter = GridViewAdapter(list = list, this@MainActivity)
        binding.gridViewGV.adapter = adapter
        binding.gridViewGV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, FragmentActivity::class.java)
            val fragmentTag = when (list[position].text) {
                "Home" -> "HomeFragment"
                "Chat" -> "ChatFragment"
                "Profile" -> "ProfileFragment"
                "Widgets" -> "WidgetsFragment"
                "Settings" -> "SettingsFragment"
                "Logout" -> "LogoutFragment"
                else -> "HomeFragment"
            }
            intent.putExtra("fragmentTag", fragmentTag)
            startActivity(intent)
        }
    }
}
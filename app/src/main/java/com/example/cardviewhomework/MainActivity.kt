package com.example.cardviewhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardviewhomework.adapter.UserAdapter
import com.example.cardviewhomework.databinding.ActivityMainBinding
import com.example.cardviewhomework.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = UserAdapter(getInfo())
    }

    private fun getInfo(): List<User> {
        var users: List<User> = mutableListOf(
            User(getDrawable(R.drawable.madara)!!, "Madara", "Uchiha"),
            User(getDrawable(R.drawable.minato)!!, "Minato", "Namikaze"),
            User(getDrawable(R.drawable.obito)!!, "Obito", "Uchiha"),
            User(getDrawable(R.drawable.tobirama)!!, "Tobirama", "Senju")
        )
        return users
    }
}

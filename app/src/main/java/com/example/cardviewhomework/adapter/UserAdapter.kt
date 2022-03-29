package com.example.cardviewhomework.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cardviewhomework.databinding.UserInfoBinding
import com.example.cardviewhomework.model.User
import com.google.android.material.snackbar.Snackbar


class UserAdapter(private val users: List<User>) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: UserInfoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.name.text = user.name
            binding.surname.text = user.surname
            binding.image.setImageDrawable(user.image)

            var isGray = false

            binding.fab.setOnClickListener {
                Snackbar.make(
                    binding.root,
                    "Do you want change card color?",
                    Snackbar.LENGTH_LONG
                ).setAction(
                    "OK",
                    object : View.OnClickListener {
                        override fun onClick(p0: View?) {
                            if (!isGray) {
                                binding.cardView.setCardBackgroundColor(Color.MAGENTA)
                                isGray = true
                            } else {
                                binding.cardView.setCardBackgroundColor(Color.parseColor("#FF018786"))
                                isGray = false
                            }
                        }
                    }
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserInfoBinding.inflate(inflater)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}

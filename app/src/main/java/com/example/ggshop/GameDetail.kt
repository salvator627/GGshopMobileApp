package com.example.ggshop


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.ggshop.databinding.ActivityGameDetailBinding

class GameDetail : AppCompatActivity() {

    companion object{
        const val EXTRA_GAME = "extra_game"
    }

    private lateinit var binding: ActivityGameDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.getParcelableExtra<Game>(EXTRA_GAME)
        binding.textView.text = intent?.tittle
        binding.textView2.text = intent?.price
        Glide.with(this)
            .load(intent?.image)
            .circleCrop()
            .into(binding.imageView2)


        binding.button.setOnClickListener {
            Toast.makeText(this@GameDetail,"Unavailable",Toast.LENGTH_SHORT).show()
        }
    }
}
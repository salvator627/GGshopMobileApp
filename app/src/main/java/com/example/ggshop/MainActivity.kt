package com.example.ggshop

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ggshop.GameDetail.Companion.EXTRA_GAME
import com.example.ggshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Game>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvGame.setHasFixedSize(true)
        list.addAll(getlistgame())
        binding.rvGame.layoutManager = GridLayoutManager(applicationContext,2)

        val adapter = Adapter(list)
        binding.rvGame.adapter = adapter


        adapter.setOnItemClickListener(object : Adapter.onItemClickListener{
            override fun onItemClick(data: Game) {
                val gameparcel = Game(
                    data.tittle,
                    data.price,
                    data.image
                )
                val intent = Intent(this@MainActivity, GameDetail::class.java)
                intent.putExtra(EXTRA_GAME,gameparcel)
                startActivity(intent)
            }

        })
    }
    @SuppressLint("Recycle")
    private fun getlistgame(): ArrayList<Game>{
        val tittle = resources.getStringArray(R.array.tittle)
        val price = resources.getStringArray(R.array.price)
        val image = resources.obtainTypedArray(R.array.phto)

        val listgame = ArrayList<Game>()
        for (i in tittle.indices){
            val game = Game(
                tittle[i],
                price[i],
                image.getResourceId(i,-1)
            )
            listgame.add(game)
        }
        return listgame
    }
}
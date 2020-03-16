package com.example.startup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.animal.*

class AnimalInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        val bundle: Bundle? = intent.extras
        val name = bundle!!.getString("name")
        val des = bundle.getString("Des")
        val image = bundle.getInt("image")
        tvAnimalImage.setImageResource(image)
        tvName.text=name
        tvDes.text=des

    }
}

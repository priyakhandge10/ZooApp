package com.example.startup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal.view.*

class MainActivity : AppCompatActivity() {

    var ListOfAnimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ListOfAnimals.add(
            Animal("Baboon","Baboons are some of the world's largest monkeys, and males of different species average from 33 to 82 pounds",R.drawable.baboon,false))

        ListOfAnimals.add(
            Animal("Bulldog","Sometimes called the English Bulldog or the British Bulldog, the breed originated in England and has a bloody past",R.drawable.bulldog,false))


        ListOfAnimals.add(
            Animal("Panda","Though it belongs to the order Carnivora, the giant panda is a folivore, with bamboo shoots and leaves making up more than 99% of its diet.",R.drawable.panda,true))

        ListOfAnimals.add(
            Animal("Swallow_Bird","The swallows, martins and saw-wings, or Hirundinidae, are a family of passerine birds found around the world on all continents, including occasionally in Antarctica.",R.drawable.swallow_bird, false))

        ListOfAnimals.add(
            Animal("White_tiger"," White tigers are scientifically known as Panthera tigris tigris, born because of a rare genetic mutation.",R.drawable.white_tiger,true))

        ListOfAnimals.add(
            Animal("Zebra","Zebras are African horses. They are in the same genus as the common horse, Equus caballus, and donkeys. Zebras are known for having many black and white stripes.",R.drawable.zebra, false))

        adapter= AnimalsAdapter(this,ListOfAnimals)
        tvListAnimal.adapter = adapter
    }

    class AnimalsAdapter:BaseAdapter{
        var ListOfAnimals= ArrayList<Animal>()
        var context:Context?=null
        constructor(context: Context, ListOfAnimals: ArrayList<Animal>):super(){
        this.ListOfAnimals=ListOfAnimals
        this.context=context
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal = ListOfAnimals[p0]
            if(animal.iskiller == true){

                var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflater.inflate(R.layout.animal_killer, null)
                myView.tvName.text = animal.name!!
                myView.tvDes.text = animal.des!!
                myView.tvAnimalImage.setImageResource(animal.image!!)
                myView.tvAnimalImage.setOnClickListener {
                    val intent = Intent(context,AnimalInfo::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("Des", animal.des!!)
                    intent.putExtra("image", animal.image!!)
                    context!!.startActivity(intent)
                }
                return myView

            } else {

                var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflater.inflate(R.layout.animal, null)
                myView.tvName.text = animal.name!!
                myView.tvDes.text = animal.des!!
                myView.tvAnimalImage.setImageResource(animal.image!!)

                myView.tvAnimalImage.setOnClickListener {
                    val intent = Intent(context,AnimalInfo::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("Des", animal.des!!)
                    intent.putExtra("image", animal.image!!)
                    context!!.startActivity(intent)
                }

                return myView
            }
        }

        override fun getItem(p0: Int): Any {
            return ListOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
        return p0.toLong()
        }

        override fun getCount(): Int {
            return ListOfAnimals.size
        }

    }
}

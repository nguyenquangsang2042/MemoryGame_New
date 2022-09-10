package com.sangnq2498.memorygame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() ,GameFragment.GameFragmentListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment(GameFragment.newInstance(),GameFragment.javaClass.name)
    }
    fun showFragment(frag: Fragment,tag:String)
    {
        tag ?.let {
            frag ?.let {
                supportFragmentManager.beginTransaction()
                    .add(R.id.gameLayoutr,
                        frag,
                        tag).commit()
            }
        }

    }

    override fun  makeTiles():ArrayList<TextView>
    {
        val tileArray:ArrayList<TextView> = ArrayList()
        for(i in 1..16)
        {
            val newTile=TextView(this)
            newTile.text==i.toString()
            newTile.setTextColor(Color.BLACK)
            newTile.setBackgroundColor(Color.RED)
            tileArray.add(newTile)
        }
        return tileArray
    }
}
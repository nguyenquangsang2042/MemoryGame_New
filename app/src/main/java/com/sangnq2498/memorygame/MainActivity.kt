package com.sangnq2498.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
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
}
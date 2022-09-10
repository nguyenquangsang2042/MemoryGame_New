package com.sangnq2498.memorygame

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder


/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {

    private  lateinit var caller:GameFragmentListener
    interface  GameFragmentListener{
        fun makeTiles(): ArrayList<TextView>
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is GameFragmentListener)
            caller=context
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val frag = inflater.inflate(R.layout.fragment_game, container, false)

        val recyclerView:RecyclerView=frag.findViewById(R.id.GameRv)
        recyclerView.layoutManager=GridLayoutManager(this.context,4)
        val textviews=caller.makeTiles()
        recyclerView.adapter=GameRecyclerAdapter(textviews)
        return frag
    }
    companion object {
        @JvmStatic
        fun newInstance(): GameFragment = GameFragment()
    }

    internal inner class GameRecyclerAdapter(val inputData: ArrayList<TextView>) :
        RecyclerView.Adapter<GameRecyclerAdapter.ReccyclerViewHolder>() {
        internal inner class ReccyclerViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
            RecyclerView.ViewHolder(inflater.inflate(R.layout.card_layout, parent, false)) {
            val tileParent=itemView.findViewById<SquareFrameLayout>(R.id.tileParent)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReccyclerViewHolder {
            val inflater=LayoutInflater.from(parent.context)
            val vh=ReccyclerViewHolder(inflater,parent)
            return vh
        }

        override fun getItemCount():Int= inputData.size


        override fun onBindViewHolder(holder: ReccyclerViewHolder, position: Int) {
            val thisTile=inputData[position]
            holder.tileParent.addView(thisTile)
        }
    }
}
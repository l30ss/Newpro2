package com.example.newpro

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.categories_list_item.view.*

class CategoriesAdapter( val context : Context): RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()

    private var categoryList = ArrayList<Categories>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(categories : ArrayList<Categories>){

        categories.also { this.categoryList = it }
        notifyDataSetChanged()
    }

    inner class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item : Categories){
            item.title.also { itemView.categories_title.text = it }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.categories_list_item, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.categoryList.size
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
       holder.bind(categoryList[position])
        val childLayoutManager = LinearLayoutManager(holder.itemView.nested_recyclerview.context, LinearLayoutManager.HORIZONTAL, false)

        holder.itemView.nested_recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = childLayoutManager
            val childAdapter = ChildAdapter(context, this@CategoriesAdapter.categoryList[position])
            adapter = childAdapter
            childAdapter.setData(this@CategoriesAdapter.categoryList[position].cardList)
            setRecycledViewPool(viewPool)
        }
    }

}
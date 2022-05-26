package com.example.newpro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val parentRecyclerView : RecyclerView = findViewById(R.id.parent_recyclerview)

        //show menu  recyclerview
        parentRecyclerView.setHasFixedSize(true)
        val categoriesAdapter : CategoriesAdapter = CategoriesAdapter(this)
        parentRecyclerView.adapter = categoriesAdapter
        parentRecyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        categoriesAdapter.setData(DataSource.data())

    }
}
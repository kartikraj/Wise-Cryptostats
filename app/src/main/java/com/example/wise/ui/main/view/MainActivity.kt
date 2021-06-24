package com.example.wise.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wise.R
import com.example.wise.adapters.CryptoAdapter
import com.example.wise.model.CrytoResponse
import com.example.wise.ui.main.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerAdapter: CryptoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Setuprecyclercview()
        initViewModel()

    }
    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val progress = findViewById<ProgressBar>(R.id.ProgressBar)
        progress.visibility =View.VISIBLE

        viewModel.getcrptoObserver().observe(this, Observer <CrytoResponse>{
            if(it != null){
                recyclerAdapter.setUpdated(it.markets)
                progress.visibility =View.INVISIBLE
            }
            else{
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT)
            }
        })
        viewModel.makeapicall()
    }

    private fun Setuprecyclercview() {
        val recyclerView= findViewById<RecyclerView>(R.id.rcview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = CryptoAdapter()
        recyclerView.adapter =  recyclerAdapter

    }

}
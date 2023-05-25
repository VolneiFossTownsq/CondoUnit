package com.example.condounitrecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView
import com.example.condounitrecycler.adapter.CondoAdapter
import com.example.condounitrecycler.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: CondoAdapter
    private lateinit var searchView: SearchView
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)
        itemAdapter = CondoAdapter()
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupViews()

        mainViewModel.unitiesList.observe(this) { unities ->
            itemAdapter.setUnities(unities)
        }
    }

    private fun setupViews() {
        recyclerView.adapter = itemAdapter

        // Configurar o SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { query ->
                    mainViewModel.onQueryChanged(query)
                }
                return true
            }
        })
    }


}



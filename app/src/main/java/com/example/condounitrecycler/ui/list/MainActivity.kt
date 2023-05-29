package com.example.condounitrecycler.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView
import com.example.condounitrecycler.R
import com.example.condounitrecycler.ui.details.UnitDetailsActivity
import com.example.condounitrecycler.adapter.CondoAdapter

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
        itemAdapter = CondoAdapter(::onCardClicked)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupViews()


        mainViewModel.unitiesList.observe(this) { unities ->
            itemAdapter.setUnities(unities)
        }

    }

    private fun setupViews() {
        recyclerView.adapter = itemAdapter

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

    private fun onCardClicked(unitId: String) {
        val intent = Intent(this, UnitDetailsActivity::class.java)
        intent.putExtra(UnitDetailsActivity.ARG_UNIT_ID, unitId)
        startActivity(intent)
    }
}



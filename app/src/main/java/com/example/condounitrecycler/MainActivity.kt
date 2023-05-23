package com.example.condounitrecycler

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.condounitrecycler.adapter.CondoAdapter
import com.example.condounitrecycler.ui.CondoUnit
import com.example.condounitrecycler.viewmodel.MainViewModel
import java.util.Locale


class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var itemAdapter: CondoAdapter = CondoAdapter()
    private var searchView: SearchView? = null
    private var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupViews()
        setSearchView()

    }

    fun setSearchView(){
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView?.clearFocus()
                hideKeyboard()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }


        })
    }

    private fun filterList(query: String?){

        if (query != null){
            val filteredList = mutableListOf<CondoUnit>()
            for (i in mainViewModel!!.unitiesList) {
                if (i.unitName.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()){
                Toast.makeText(this,"No data found", Toast.LENGTH_SHORT).show()
            } else {
                itemAdapter.setUnities(filteredList)
                itemAdapter.notifyDataSetChanged()
            }

        }


    }

    private fun setupViews() {
        recyclerView?.adapter = itemAdapter
        itemAdapter.setUnities(mainViewModel?.unitiesList ?: listOf())
    }

    private fun hideKeyboard() {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(searchView?.windowToken, 0)
    }


}


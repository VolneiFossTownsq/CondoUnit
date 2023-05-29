package com.example.condounitrecycler.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.condounitrecycler.main.MainRepository
import com.example.condounitrecycler.data.models.CondoUnit
import kotlinx.coroutines.launch
import java.util.Locale

class MainViewModel(private val repository: MainRepository = MainRepository()) : ViewModel() {

    private val _unitiesList: MutableLiveData<List<CondoUnit>> = MutableLiveData()
    val unitiesList: LiveData<List<CondoUnit>> = _unitiesList

    private val allUnities: MutableList<CondoUnit> = mutableListOf()


    init {
        fetchUnitData()
    }

    fun onQueryChanged(query: String) {
        if (query.isEmpty()) {
            _unitiesList.value = allUnities.toList()
        } else {
            val filteredList = allUnities.filter { unit ->
                unit.unitName.containsIgnoreCase(query)
            }
            _unitiesList.value = filteredList
        }
    }

    fun String.containsIgnoreCase(other: String): Boolean {
        return this.lowercase(Locale.ROOT).contains(other.lowercase(Locale.ROOT))
    }

    private fun fetchUnitData() {
        viewModelScope.launch {
            val result = repository.getUnities()
            if (result.isSuccess) {
                allUnities.clear()
                allUnities.addAll(result.getOrDefault(listOf()))
                _unitiesList.value = allUnities
            } else {
                println("houve bug")
            }
        }
    }

}
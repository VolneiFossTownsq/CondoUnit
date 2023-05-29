package com.example.condounitrecycler.data.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.condounitrecycler.ui.details.UnitDetailsViewModel

class UnitDetailsViewModelFactory(private val unitId:String) : ViewModelProvider.Factory {
    override fun<T: ViewModel> create(modelClass: Class<T>):T{
        if (modelClass.isAssignableFrom(UnitDetailsViewModel::class.java)){
            return UnitDetailsViewModel(unitId = unitId) as T
        }
        throw IllegalArgumentException("Unknown  ViewModel class")
    }
}
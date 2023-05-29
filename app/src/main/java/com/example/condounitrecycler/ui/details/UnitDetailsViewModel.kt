package com.example.condounitrecycler.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.condounitrecycler.data.details.UnitDetailsRepository
import com.example.condounitrecycler.data.models.CondoUnit
import kotlinx.coroutines.launch

class UnitDetailsViewModel(
    private val repository: UnitDetailsRepository = UnitDetailsRepository(),
    private val unitId : String
):ViewModel() {

    private val _unitDetails: MutableLiveData<CondoUnit> = MutableLiveData()
    val unitDetails : LiveData<CondoUnit> = _unitDetails

    private val _error: MutableLiveData<Boolean> = MutableLiveData()
    val error : LiveData<Boolean> = _error

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading : LiveData<Boolean> = _loading

    fun fetchUnitDetails() {
        viewModelScope.launch {
            _loading.value = true
            val result = repository.getUnitById(unitId)
            if (result.isSuccess) {
                _unitDetails.value = result.getOrNull()
                _error.value = false
            } else {
                _error.value = true
            }
            _loading.value = false
        }
    }

    fun retry(){
        fetchUnitDetails()
    }

}
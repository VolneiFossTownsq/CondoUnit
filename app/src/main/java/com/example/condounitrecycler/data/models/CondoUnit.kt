package com.example.condounitrecycler.data.models

import com.example.condounitrecycler.data.models.Resident

data class CondoUnit(
    val id: String,
    val unitName: String,
    val unitDescription: String,
    val unitPicture: String,
    val residents: List<Resident>
)
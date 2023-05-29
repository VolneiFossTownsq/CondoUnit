package com.example.condounitrecycler.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.condounitrecycler.R
import com.example.condounitrecycler.data.details.UnitDetailsViewModelFactory
import com.example.condounitrecycler.data.models.CondoUnit

class UnitDetailsActivity : AppCompatActivity() {

    private var toolbar: Toolbar? = null
    private var unitPicture: ImageView? = null
    private var errorView: ConstraintLayout? = null
    private var loadingView: ConstraintLayout? = null
    private var retryButton: Button? = null
    private var residentRecyclerView: RecyclerView? = null

    private var unitDetailsViewModel: UnitDetailsViewModel? = null
    private var residentsAdapter:ResidentsAdapter = ResidentsAdapter()

    companion object {
        const val ARG_UNIT_ID = "unit_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_details)

        instantiateViewModel()

        toolbar = findViewById(R.id.toolbar)
        unitPicture = findViewById(R.id.unitPicture)
        errorView = findViewById(R.id.errorView)
        loadingView = findViewById(R.id.loadingView)
        retryButton = findViewById(R.id.retryButton)
        residentRecyclerView = findViewById(R.id.residentsRecyclerView)

        setupViews()
        setupBindings()
    }


    private fun setupViews(){
        setupToolbar()

        retryButton?.setOnClickListener {
            unitDetailsViewModel?.retry()
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar?.setNavigationOnClickListener {
            finish()
        }
    }

    private fun instantiateViewModel() {
        val unitId = intent.getStringExtra(ARG_UNIT_ID)
        if (!unitId.isNullOrEmpty()){
            val viewModelFactory = UnitDetailsViewModelFactory(unitId)
            unitDetailsViewModel = ViewModelProvider(this,viewModelFactory)[UnitDetailsViewModel::class.java]
            unitDetailsViewModel?.fetchUnitDetails()
        }
    }

    private fun setupBindings() {
        unitDetailsViewModel?.unitDetails?.observe(this) { condoUnit ->
            toolbar?.title = condoUnit.unitName
            unitPicture?.load(condoUnit.unitPicture)
            setupAdapter(condoUnit)
        }

        unitDetailsViewModel?.error?.observe(this) { isError ->
            errorView?.isVisible = isError
        }

        unitDetailsViewModel?.loading?.observe(this) { isLoading ->
            loadingView?.isVisible = isLoading
            unitPicture?.isVisible = !isLoading
        }
    }

    private fun setupAdapter(condoUnit: CondoUnit){
        residentRecyclerView?.layoutManager = GridLayoutManager(this, 2)
        residentRecyclerView?.adapter = residentsAdapter
        residentsAdapter.setResidents(condoUnit.residents)
    }
}
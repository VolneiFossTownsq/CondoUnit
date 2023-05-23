package com.example.condounitrecycler.viewmodel

import androidx.lifecycle.ViewModel
import com.example.condounitrecycler.ui.CondoUnit

class MainViewModel : ViewModel() {

    private val _unitiesList : MutableList<CondoUnit> = makeCondoMockData()
    val unitiesList: List<CondoUnit> = _unitiesList

    fun makeCondoMockData(): MutableList<CondoUnit> {
        return mutableListOf(
            CondoUnit(
                id = "1",
                unitName = "Unidade #1",
                unitDescription = "belissima unidade...",
                unitPicture = "https://s2.glbimg.com/itGGFP4ZIy-S5LKl0GZe20LiFLI=/512x320/smart/e.glbimg.com/og/ed/f/original/2019/07/16/rihanna_hhr15.jpg"
            ),
            CondoUnit(
                id = "2",
                unitName = "Unidade #2",
                unitDescription = "belissima unidade...",
                unitPicture = "https://imagens-revista.vivadecora.com.br/uploads/2016/10/65243-casas-bonitas-fachada-stancati-viva-decora.jpg"
            ),
            CondoUnit(
                id = "3",
                unitName = "Unidade #3",
                unitDescription = "belissima unidade...",
                unitPicture = "https://www.tuacasa.com.br/wp-content/uploads/2015/06/fachadas-de-casas-000.jpg"
            ),
            CondoUnit(
                id = "4",
                unitName = "Unidade #4",
                unitDescription = "belissima unidade...",
                unitPicture = "https://www.tuacasa.com.br/wp-content/uploads/2019/02/fachadas-de-casas-modernas-0-1200x675.jpg"
            ),
            CondoUnit(
                id = "5",
                unitName = "Unidade #5",
                unitDescription = "belissima unidade...",
                unitPicture = "https://www.tuacasa.com.br/wp-content/uploads/2019/05/fachadas-de-casas-simples-0.jpg"
            ),
            CondoUnit(
                id = "6",
                unitName = "Unidade #6",
                unitDescription = "belissima unidade...",
                unitPicture = "https://img.freepik.com/fotos-gratis/villa-com-piscina-de-luxo-espetacular-design-contemporaneo-arte-digital-imoveis-casa-casa-e-propriedade-ge_1258-150765.jpg"
            )
        )
    }

}
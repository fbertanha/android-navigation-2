package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EstadoAppViewModel : ViewModel() {

    val components: LiveData<ComponentsVisuais>
        get() = _componentes

    private var _componentes: MutableLiveData<ComponentsVisuais> =
        MutableLiveData<ComponentsVisuais>().also {
            it.value = temComponentes
        }

    var temComponentes: ComponentsVisuais = ComponentsVisuais()
        set(value) {
            field = value
            _componentes.value = value
        }

}

class ComponentsVisuais(
    val appBar: Boolean = false,
    val bottomNavigation: Boolean = false
)

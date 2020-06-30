package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.ComponentsVisuais
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import kotlinx.android.synthetic.main.cadastro_usuario.*
import kotlinx.android.synthetic.main.login.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by felipebertanha on 21/June/2020
 */

class CadastroUsuarioFragment : Fragment() {

    private val controlador by lazy {
        findNavController()
    }

    private val estadoAppViewModel : EstadoAppViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cadastro_usuario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        estadoAppViewModel.temComponentes = ComponentsVisuais()
        cadastro_usuario_botao_cadastrar.setOnClickListener {
            controlador.popBackStack()
        }
    }
}
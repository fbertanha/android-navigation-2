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
import br.com.alura.aluraesporte.ui.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.login.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by felipebertanha on 08/June/2020
 */

class LoginFragment : Fragment() {

    private val navigator by lazy {
        findNavController()
    }

    private val viewModel by viewModel<LoginViewModel>()
    private val appViewModel : EstadoAppViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appViewModel.temComponentes  = ComponentsVisuais();
        login_botao_logar.setOnClickListener {
            viewModel.loga()
            vaiParaListaProdutos()
        }

        login_botao_cadastrar.setOnClickListener {
            vaiParaCadastro()
        }
    }

    private fun vaiParaCadastro() {
        navigator.navigate(LoginFragmentDirections.acaoLoginParaCadastroUsuario())
    }

    private fun vaiParaListaProdutos() {
        navigator.navigate(LoginFragmentDirections.actionLoginToListaProdutos())
    }
}
package br.com.alura.aluraesporte.ui.fragment;

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.recyclerview.adapter.ListaPagamentosAdapter
import br.com.alura.aluraesporte.ui.viewmodel.ComponentsVisuais
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import br.com.alura.aluraesporte.ui.viewmodel.PagamentoViewModel
import kotlinx.android.synthetic.main.lista_pagamentos.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by felipebertanha on 24/June/2020
 */
class ListaPagamentosFragment : BaseFragment() {

    private val adapter: ListaPagamentosAdapter by inject()
    private val viewModel: PagamentoViewModel by viewModel()
    private val estadoAppViewModel: EstadoAppViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lista_pagamentos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lista_pagamentos_recyclerview.adapter = adapter
        estadoAppViewModel.temComponentes = ComponentsVisuais(
            appBar = true,
            bottomNavigation = true
        )
        viewModel.todos().observe(this, Observer {
            it?.let { pagamentosEncontrados ->
                Log.e("aaa", "aaa")
                Log.e("porra", pagamentosEncontrados[0].preco.toString())
                adapter.add(pagamentosEncontrados)
            }
        })
    }
}

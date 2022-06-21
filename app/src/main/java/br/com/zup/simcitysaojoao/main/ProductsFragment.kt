package br.com.zup.simcitysaojoao.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.simcitysaojoao.LISTA_KEY
import br.com.zup.simcitysaojoao.PRODUTO
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.adapter.ProdutoAdapter
import br.com.zup.simcitysaojoao.databinding.FragmentProductsBinding
import br.com.zup.simcitysaojoao.model.Produto

class ProductsFragment : Fragment() {
    private lateinit var binding: FragmentProductsBinding

    private val adapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(), this::irParaDetalhe)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exibirRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter.limpaListaDeProdutos()
    }

    private fun recuperarAdicionarListaDados() {
        val listaProdutos = ArrayList<Produto>()
        val lista = arguments?.getParcelableArrayList<Produto>(LISTA_KEY)

        if (lista != null) {
            listaProdutos.addAll(lista)
            adapter.atualizarListaProduto(listaProdutos)
        }
    }

    private fun exibirRecyclerView() {
        recuperarAdicionarListaDados()
        binding.rvProduto.adapter = adapter
        binding.rvProduto.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun irParaDetalhe(produto: Produto) {
        val bundle = bundleOf(PRODUTO to produto)

        findNavController().navigate(R.id.action_productsFragment_to_productDetailsFragment, bundle)
    }
}
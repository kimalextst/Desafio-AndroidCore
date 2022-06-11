package cadastrarproduto.fragments.mostrarprodutofragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.simcitysaojoao.PRODUTO_KEY
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentCadastrarProdutoBinding
import br.com.zup.simcitysaojoao.databinding.FragmentMostrarProdutosCadastradosBinding
import br.com.zup.simcitysaojoao.model.Produto
import cadastrarproduto.adapter.ProdutoAdapter

class MostrarProdutosCadastradosFragment(private val lista : MutableList<Produto>) : Fragment() {

    private lateinit var binding: FragmentMostrarProdutosCadastradosBinding

    private val adapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(), this::irParaDetalhe)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {binding = FragmentMostrarProdutosCadastradosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exibirRecyclerView()
    }

    private fun exibirRecyclerView() {
        atualizarListaProdutos()
        binding.rvProduto.adapter = adapter
        binding.rvProduto.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun atualizarListaProdutos() {
        val listaProdutos = lista

        adapter.atualizarListaProduto(listaProdutos)
    }

    private fun irParaDetalhe(produto: Produto) {
        val intent = Intent(requireContext(), DetalhesAlbumActivity::class.java).apply {
            putExtra(PRODUTO_KEY, produto)
        }
        startActivity(intent)
    }
}
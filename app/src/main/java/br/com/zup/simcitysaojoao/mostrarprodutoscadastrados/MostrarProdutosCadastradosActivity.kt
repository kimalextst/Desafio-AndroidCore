package br.com.zup.simcitysaojoao.mostrarprodutoscadastrados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.simcitysaojoao.PRODUTO
import br.com.zup.simcitysaojoao.adapter.ProdutoAdapter
import br.com.zup.simcitysaojoao.databinding.ActivityCadastrarProdutoBinding
import br.com.zup.simcitysaojoao.databinding.ActivityMostrarProdutosCadastradosBinding
import br.com.zup.simcitysaojoao.detalhes.DetalhesProdutoActivity
import br.com.zup.simcitysaojoao.model.Produto

class MostrarProdutosCadastradosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMostrarProdutosCadastradosBinding

    private val adapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(), this::irParaDetalhe)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarProdutosCadastradosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirRecyclerView()
    }

    private fun recuperarAdicionarListaDados() {
        /**
         * Recuperando o objeto que está chegando a partir da intent
         * nesse caso usamos getParcelableExtra por que é o tipo de dado
         * que vamos recuperar da intent e entre os sinais de < e >
         * passamos a classe que queremos definir o tipo do nosso objeto
         * que nesse caso é Alune, e por fim passamos a chave para recuperar o valor
         * Obs: todas as chaves estao declaradas no arquivo de Constantes
         */
        val listaProdutos = ArrayList<Produto>()
        val produto = intent.getParcelableExtra<Produto>(PRODUTO)

        /**
         * Verificação para saber se o objeto está nulo
         */
        if (produto != null) {
            listaProdutos.add(produto)
            adapter.atualizarListaProduto(listaProdutos)
        }
    }

    private fun exibirRecyclerView() {
        recuperarAdicionarListaDados()
        binding.rvProduto.adapter = adapter
        binding.rvProduto.layoutManager = LinearLayoutManager(this)
    }

    private fun irParaDetalhe(produto: Produto) {
        val intent = Intent(this, DetalhesProdutoActivity::class.java).apply {
            putExtra(PRODUTO, produto)
        }
        startActivity(intent)
    }
}
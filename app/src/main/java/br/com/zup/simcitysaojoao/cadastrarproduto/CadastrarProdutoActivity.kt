package br.com.zup.simcitysaojoao.cadastrarproduto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import br.com.zup.simcitysaojoao.LISTA_KEY
import br.com.zup.simcitysaojoao.PRODUTO
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.adapter.ProdutoAdapter
import br.com.zup.simcitysaojoao.databinding.ActivityCadastrarProdutoBinding
import br.com.zup.simcitysaojoao.model.Produto
import br.com.zup.simcitysaojoao.mostrarprodutoscadastrados.MostrarProdutosCadastradosActivity

class CadastrarProdutoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarProdutoBinding
    private lateinit var nome : String
    private lateinit var qntd : String
    private lateinit var valorUni : String
    private lateinit var receita : String
    private val listaProdutos = ArrayList<Produto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle((R.string.titulo_produtos))

        binding.bvCadastrarProduto.setOnClickListener {
            adicionarListaDados()
            Toast.makeText(this,"Produto cadastrado com sucesso",Toast.LENGTH_LONG).show()
        }

        binding.bvVerProdutos.setOnClickListener {
            if (listaProdutos.isNotEmpty()){
                irParaMostrarProdutosCadastrados(enviarDados())
            }
        }
    }

    private fun enviarDados(): Produto? {
        return if (!verificarCamposEdicao()){
            val produto = Produto(nome,qntd,valorUni,receita)
            limparOsCamposEdicao()

            produto
        } else {
            null
        }
    }

    private fun recuperarDados(){
        nome = binding.etNomeProduto.text.toString()
        qntd = binding.etQntdProduto.text.toString()
        valorUni = binding.etValor.text.toString()
        receita = binding.etReceita.text.toString()
    }

    private fun adicionarListaDados() {
        recuperarDados()
        val produto = enviarDados()

        if (produto != null) {
            listaProdutos.add(produto)
        }
    }

    private fun verificarCamposEdicao(
    ): Boolean {
        when {
            this.nome.isEmpty() -> {
                binding.etNomeProduto.error = "Insira o nome do produto!"
                return true
            }
            this.qntd.isEmpty() -> {
                binding.etQntdProduto.error = "Insira um valor!"
                return true
            }
            this.valorUni.isEmpty() -> {
                binding.etValor.error = "Insira um valor!"
                return true
            }
            this.receita.isEmpty() -> {
                binding.etReceita.error = "Insira uma receita!"
                return true
            }
        }
        return false
    }

    private fun limparOsCamposEdicao() {
        binding.etNomeProduto.text.clear()
        binding.etQntdProduto.text.clear()
        binding.etValor.text.clear()
        binding.etReceita.text.clear()
    }

    private fun irParaMostrarProdutosCadastrados(produto: Produto?) {
        val intent = Intent(this, MostrarProdutosCadastradosActivity::class.java).apply {
            putExtra(PRODUTO, produto)
            putParcelableArrayListExtra(LISTA_KEY,listaProdutos)
        }
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
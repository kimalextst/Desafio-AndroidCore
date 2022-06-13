package br.com.zup.simcitysaojoao.cadastrarproduto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.simcitysaojoao.PRODUTO
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.ActivityCadastrarProdutoBinding
import br.com.zup.simcitysaojoao.databinding.ActivityHomeBinding
import br.com.zup.simcitysaojoao.model.Produto
import br.com.zup.simcitysaojoao.mostrarprodutoscadastrados.MostrarProdutosCadastradosActivity

class CadastrarProdutoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarProdutoBinding
    private lateinit var nome : String
    private lateinit var qntd : String
    private lateinit var valorUni : String
    private lateinit var receita : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bvCadastrarProduto.setOnClickListener {
            enviarDados()
        }
    }

    private fun enviarDados(){
        recuperarDados()
        if (!verificarCamposEdicao()){

            val produto = Produto(nome,qntd,valorUni,receita)

            val intent = Intent(this, MostrarProdutosCadastradosActivity::class.java).apply {
                putExtra(PRODUTO, produto)
            }
            startActivity(intent)
            limparOsCamposEdicao()
        }
    }

    private fun recuperarDados(){
        nome = binding.etNomeProduto.text.toString()
        qntd = binding.etQntdProduto.text.toString()
        valorUni = binding.etValor.text.toString()
        receita = binding.etReceita.text.toString()
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
}
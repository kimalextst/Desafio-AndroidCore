package br.com.zup.simcitysaojoao.detalhes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import br.com.zup.simcitysaojoao.PRODUTO
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.ActivityDetalhesProdutoBinding
import br.com.zup.simcitysaojoao.databinding.ActivityMostrarProdutosCadastradosBinding
import br.com.zup.simcitysaojoao.model.Produto

class DetalhesProdutoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalhesProdutoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirAppBarCustomizada()
        recuperarAlbum()
        favoritarProduto()
    }

    private fun exibirAppBarCustomizada() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Detalhes do produto")
    }

    private fun recuperarAlbum(){
        val produto = intent.getParcelableExtra<Produto>(PRODUTO)

        if (produto != null){
            exibirInformacoes(produto)
        }
    }

    private fun exibirInformacoes(produto: Produto){
        binding.ivCarrinho.setImageResource(produto.getImage())
        binding.tvNomeProduto.text = produto.getNome()
        binding.tvQuantidade.text = produto.getQntd()
        binding.tvValorUnitario.text = produto.getValor()
        binding.tvReceita.text = produto.getReceita()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun favoritarProduto() {
        binding.ivFavoritar.setOnClickListener {
            Toast.makeText(this, "Produto favoritado!", Toast.LENGTH_LONG).show()
        }
    }
}
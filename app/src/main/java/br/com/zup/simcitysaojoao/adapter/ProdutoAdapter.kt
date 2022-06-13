package br.com.zup.simcitysaojoao.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcitysaojoao.databinding.ProdutoItemBinding
import br.com.zup.simcitysaojoao.model.Produto

class ProdutoAdapter(
    private var listaProduto: MutableList<Produto>,
    private val clickProduto: (produto: Produto) -> Unit
) : RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProdutoViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProdutoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = listaProduto[position]
        holder.adicionarInformacoesView(produto)
        holder.binding.cvItemLista.setOnClickListener {
            clickProduto(produto)
        }
    }

    override fun getItemCount(): Int = listaProduto.size

    fun atualizarListaProduto(novaLista: ArrayList<Produto>) {
        if (listaProduto.size == 0) {
            listaProduto = novaLista
        } else {
            listaProduto.addAll(novaLista)
        }
        notifyDataSetChanged()
    }

    class ProdutoViewHolder(val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun adicionarInformacoesView( produto: Produto ) {
            binding.ivProduto.setImageResource(produto.getImage())
            binding.tvNomeProduto.text = produto.getNome()
            binding.tvQntdProduto.text = produto.getQntd()
        }
    }
}

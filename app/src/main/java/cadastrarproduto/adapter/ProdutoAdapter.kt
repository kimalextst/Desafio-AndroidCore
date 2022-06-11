package cadastrarproduto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcitysaojoao.databinding.ProdutoItemBinding
import br.com.zup.simcitysaojoao.model.Produto

class ProdutoAdapter (
    private var listaProduto: MutableList<Produto>,
    private val clickProduto: (album: Produto) -> Unit
) : RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProdutoAdapter.ProdutoViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProdutoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val album = listaProduto[position]
        holder.adicionarInformacoesView(album)
        holder.binding.cvItemLista.setOnClickListener {
            clickProduto(album)
        }
    }

    override fun getItemCount(): Int = listaProduto.size

    class ProdutoViewHolder(val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun adicionarInformacoesView( produto: Produto ) {
            binding.ivProduto.setImageResource(produto.getImage())
            binding.tvNomeProduto.text = produto.getNome()
            binding.tvQntdProduto.text = produto.getQntd()
        }
    }
}

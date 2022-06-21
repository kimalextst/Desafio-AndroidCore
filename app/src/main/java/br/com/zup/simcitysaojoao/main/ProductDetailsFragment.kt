package br.com.zup.simcitysaojoao.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.zup.simcitysaojoao.PRODUTO
import br.com.zup.simcitysaojoao.databinding.FragmentProductDetailsBinding
import br.com.zup.simcitysaojoao.model.Produto

class ProductDetailsFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recuperarAlbum()
        favoritarProduto()
    }

    private fun recuperarAlbum() {
        val produto = arguments?.getParcelable<Produto>(PRODUTO)

        if (produto != null) {
            exibirInformacoes(produto)
        }
    }

    private fun exibirInformacoes(produto: Produto) {
        binding.ivCarrinho.setImageResource(produto.getImage())
        binding.tvNomeProduto.text = produto.getNome()
        binding.tvQuantidade.text = produto.getQntd()
        binding.tvValorUnitario.text = produto.getValor()
        binding.tvReceita.text = produto.getReceita()

    }

    private fun favoritarProduto() {
        binding.ivFavoritar.setOnClickListener {
            Toast.makeText(requireContext(), "Produto favoritado!", Toast.LENGTH_LONG).show()
        }
    }
}
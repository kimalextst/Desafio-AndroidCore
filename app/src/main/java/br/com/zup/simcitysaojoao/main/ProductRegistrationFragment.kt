package br.com.zup.simcitysaojoao.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.zup.simcitysaojoao.LISTA_KEY
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentProductRegistrationBinding
import br.com.zup.simcitysaojoao.model.Produto

class ProductRegistrationFragment : Fragment() {
    private lateinit var binding: FragmentProductRegistrationBinding
    private lateinit var nome: String
    private lateinit var qntd: String
    private lateinit var valorUni: String
    private lateinit var receita: String
    private val listaProdutos = ArrayList<Produto>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bvCadastrarProduto.setOnClickListener {
            adicionarListaDados()
        }

        binding.bvVerProdutos.setOnClickListener {
            if (listaProdutos.isNotEmpty()) {
                irParaMostrarProdutosCadastrados(listaProdutos)
            }
        }
    }

    private fun enviarDados(): Produto? {
        return if (!verificarCamposEdicao()) {
            val produto = Produto(nome, qntd, valorUni, receita)
            Toast.makeText(requireContext(), "Produto cadastrado com sucesso", Toast.LENGTH_LONG)
                .show()
            limparOsCamposEdicao()

            produto
        } else {
            null
        }
    }

    private fun recuperarDados() {
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
            this.nome.isBlank() -> {
                binding.etNomeProduto.error = "Insira o nome do produto!"
                return true
            }
            this.qntd.isBlank() -> {
                binding.etQntdProduto.error = "Insira um valor!"
                return true
            }
            this.valorUni.isBlank() -> {
                binding.etValor.error = "Insira um valor!"
                return true
            }
            this.receita.isBlank() -> {
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

    private fun irParaMostrarProdutosCadastrados(produtos: ArrayList<Produto>) {
        val bundle = bundleOf(LISTA_KEY to produtos)

        findNavController().navigate(
            R.id.action_registerProductFragment_to_productsFragment,
            bundle
        )
    }
}
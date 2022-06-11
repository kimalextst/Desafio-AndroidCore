package cadastrarproduto.fragments.cadastrarprodutofragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.ActivityProdutoBinding
import br.com.zup.simcitysaojoao.databinding.FragmentCadastrarProdutoBinding
import br.com.zup.simcitysaojoao.model.Produto
import cadastrarproduto.fragments.mostrarprodutofragment.MostrarProdutosCadastradosFragment

class CadastrarProdutoFragment : Fragment() {
    private lateinit var binding: FragmentCadastrarProdutoBinding
    private lateinit var nome: String
    private lateinit var quantidade: String
    private lateinit var valorUnitario: String
    private lateinit var receita: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastrarProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bvCadastrarProduto.setOnClickListener {

        }

        binding.bvVerProdutos.setOnClickListener {
            startActivity(Intent(requireContext(), MostrarProdutosCadastradosFragment::class.java))
        }

        binding.bvValorTotal.setOnClickListener {

        }
    }

    private fun recuperarDadosDigitados(): Produto {
        this.nome = binding.etNomeProduto.text.toString()
        this.quantidade = binding.etQntdProduto.text.toString()
        this.valorUnitario = binding.etValor.text.toString()
        this.receita = binding.etReceita.text.toString()

        return Produto(image = R.drawable.carrinho, nome = nome, quantidade = quantidade, valorUnitario = valorUnitario, receita = receita)
    }

    private fun listaTemporaria(){
        val listaTemporaria : MutableList<Produto>
        val produto = recuperarDadosDigitados()

        listaTemporaria.add(Produto(R.drawable.carrinho,""))
    }

}
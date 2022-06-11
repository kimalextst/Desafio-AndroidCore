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
}
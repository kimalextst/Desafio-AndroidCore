package br.com.zup.simcitysaojoao.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.simcitysaojoao.databinding.ActivityHomeBinding
import cadastrarproduto.ProdutoActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bvGoToProduto.setOnClickListener {
            startActivity(Intent(this, ProdutoActivity::class.java))
        }
    }
}
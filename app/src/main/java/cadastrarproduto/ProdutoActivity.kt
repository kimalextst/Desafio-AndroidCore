package cadastrarproduto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.ActivityProdutoBinding

class ProdutoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirAppBarCustomizada()
        supportFragmentManager.findFragmentById(binding.navHostFragment.id)
    }

    private fun exibirAppBarCustomizada() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.title_produto)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
package br.com.zup.simcitysaojoao.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Produto(
    private val image: Int,
    private val nome:String,
    private val quantidade: String,
    private val valorUnitario:String,
    private val receita:String
) : Parcelable {
    fun getImage() = this.image
    fun getNome() = this.nome
    fun getQntd() = this.quantidade
    fun getValor() = this.valorUnitario.toDouble()
    fun getReceita() = this.receita
}
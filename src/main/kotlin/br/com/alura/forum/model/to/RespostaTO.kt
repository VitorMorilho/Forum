package br.com.alura.forum.model.to

import br.com.alura.forum.model.Topico
import java.time.LocalDate

data class RespostaTO(
    val id: Long? = null,
    val menssagem : String,
    val dataCriacao: LocalDate = LocalDate.now(),
    val autor: UsuarioTO,
    val topico: Topico,
    val solucao: Boolean
)

package br.com.alura.forum.model.to

import br.com.alura.forum.model.enum.StatusTopico
import java.time.LocalDate

data class TopicoViewTO(
    val id: Long?,
    val titulo: String,
    val menssagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDate
)

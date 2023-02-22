package br.com.alura.forum.model.to

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovoTopicoFormTO(
    @field:NotEmpty(message = "O campo titulo não pode ser vazio")
    @field:Size(min = 5, max = 100, message = "Titulo deve ter entre 5 a 100 caracteres")
    val titulo :String,
    @field:NotEmpty(message = "O campo mensagem não pode ser vazio")
    val menssagem: String,
    @field:NotNull(message = "O campo idCurso não pode ser vazio")
    val idCurso: Long,
    @field:NotNull(message = "O campo idUsuario não pode ser vazio")
    val idUsuario: Long
)

package br.com.alura.forum.model.to

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovoTopicoFormTO(
    @field:NotEmpty @field:Size(min = 5, max = 100) val titulo :String,
    @field:NotEmpty val menssagem: String,
    @field:NotNull val idCurso: Long,
    @field:NotNull val idUsuario: Long
)

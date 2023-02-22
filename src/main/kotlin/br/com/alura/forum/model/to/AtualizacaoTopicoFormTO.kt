package br.com.alura.forum.model.to

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AtualizacaoTopicoFormTO(
    @field:NotNull val id: Long,
    @field:NotEmpty @field:Size(min = 5, max = 100) val titulo: String,
    @field:NotEmpty val menssagem: String
)

package br.com.alura.forum.model

import br.com.alura.forum.model.enum.StatusTopico
import br.com.alura.forum.model.to.CursoTO
import br.com.alura.forum.model.to.RespostaTO
import br.com.alura.forum.model.to.UsuarioTO
import java.time.LocalDate

data class Topico(
    var id: Long? = null,
    val titulo: String,
    val menssagem: String,
    val dataCriacao: LocalDate = LocalDate.now(),
    val curso: CursoTO,
    val autor: UsuarioTO,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val respostas:List<RespostaTO> = ArrayList()
)
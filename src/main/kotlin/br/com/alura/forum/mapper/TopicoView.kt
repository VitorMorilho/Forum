package br.com.alura.forum.mapper

import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.to.TopicoViewTO
import org.springframework.stereotype.Component

@Component
class TopicoView: Mapper<Topico, TopicoViewTO> {

    override fun map(o: Topico): TopicoViewTO {
        return TopicoViewTO(
            id = o.id,
            titulo = o.titulo,
            menssagem = o.menssagem,
            dataCriacao = o.dataCriacao,
            status = o.status
        )
    }
}
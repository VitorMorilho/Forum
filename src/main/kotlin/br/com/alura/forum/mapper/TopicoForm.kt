package br.com.alura.forum.mapper

import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.to.NovoTopicoFormTO
import br.com.alura.forum.service.CursoService
import br.com.alura.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoForm(
    private var cursoService: CursoService,
    private var usuarioService: UsuarioService
): Mapper<NovoTopicoFormTO, Topico> {
    override fun map(o: NovoTopicoFormTO): Topico {
        return Topico(
            titulo = o.titulo,
            menssagem = o.menssagem,
            curso = cursoService.buscarPorIdCurso(o.idCurso),
            autor = usuarioService.buscarPorIdUsuario(o.idUsuario)
        )

    }
}

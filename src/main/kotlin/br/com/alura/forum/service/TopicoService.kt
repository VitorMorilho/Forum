package br.com.alura.forum.service

import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicoForm
import br.com.alura.forum.mapper.TopicoView
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.to.AtualizacaoTopicoFormTO
import br.com.alura.forum.model.to.NovoTopicoFormTO
import br.com.alura.forum.model.to.TopicoViewTO
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val viewMapper: TopicoView,
    private val formMapper: TopicoForm,
    private val notFoundException: String = "Topico nao enconrado"
) {

    fun listar(): List<TopicoViewTO> {
        return topicos.stream().map { t -> viewMapper.map(t) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoViewTO {
        val topico = topicos.stream().filter {t -> t.id == id}.findFirst().orElseThrow{NotFoundException(notFoundException)}
        return viewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoFormTO): TopicoViewTO {
        val topico = formMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return viewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoFormTO): TopicoViewTO {
        val topico = topicos.stream().filter {t -> t.id == form.id}.findFirst().orElseThrow{NotFoundException(notFoundException)}
        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            menssagem = form.menssagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado)
        return viewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter {t -> t.id == id}.findFirst().orElseThrow{NotFoundException(notFoundException)}
        topicos = topicos.minus(topico)
    }
}
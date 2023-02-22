package br.com.alura.forum.service

import br.com.alura.forum.model.to.CursoTO
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(var cursos: List<CursoTO>) {

    init {
        val curso = CursoTO(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )
        cursos = Arrays.asList(curso)
    }

    fun buscarPorIdCurso(id: Long): CursoTO{
        return cursos.stream().filter{ c -> c.id == id }.findFirst().get()
    }
}
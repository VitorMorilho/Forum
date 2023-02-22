package br.com.alura.forum.service

import br.com.alura.forum.model.to.UsuarioTO
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<UsuarioTO>) {

    init {
        val usuario = UsuarioTO(
            id = 1,
            nome = "Vitor",
            email = "Vitor@email.com"
        )
        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorIdUsuario(id: Long): UsuarioTO{
        return usuarios.stream().filter{ u -> u.id == id }.findFirst().get()
    }
}
package br.com.alura.forum.controller

import br.com.alura.forum.model.to.AtualizacaoTopicoFormTO
import br.com.alura.forum.model.to.NovoTopicoFormTO
import br.com.alura.forum.model.to.TopicoViewTO
import br.com.alura.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/topicos"])
class TopicoController(
    private val service: TopicoService) {

    @GetMapping(value = ["/listar"])
    fun listar(): List<TopicoViewTO >{
        return service.listar()
    }

    @GetMapping(value = ["/listar/{id}"])
    fun buscarPorId(@PathVariable id: Long): TopicoViewTO{
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid form: NovoTopicoFormTO, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoViewTO>{
        val topicoView = service.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoFormTO): ResponseEntity<TopicoViewTO>{
        val topicoViewTO = service.atualizar(form)
        return ResponseEntity.ok(topicoViewTO)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}
package br.com.alura.forum.mapper

interface Mapper<Origem, Destino> {

    fun map(o: Origem): Destino
}

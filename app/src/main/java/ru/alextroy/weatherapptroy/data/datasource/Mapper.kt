package ru.alextroy.weatherapptroy.data.datasource

interface Mapper<E, D> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E
}
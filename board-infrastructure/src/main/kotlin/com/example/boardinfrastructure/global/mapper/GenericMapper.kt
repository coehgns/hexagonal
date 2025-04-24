package com.example.boardinfrastructure.global.mapper

interface GenericMapper<E, D> {
    fun toEntity(model: D): E
}
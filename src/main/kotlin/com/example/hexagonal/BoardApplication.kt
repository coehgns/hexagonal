package com.example.boardinfrastructure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties
class BoardApplicatoin

fun main(args: Array<String>) {
    runApplication<BoardApplicatoin>(*args)
}
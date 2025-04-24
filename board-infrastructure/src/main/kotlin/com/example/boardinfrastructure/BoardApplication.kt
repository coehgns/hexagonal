package com.example.boardinfrastructure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan("com.example.boardinfrastructure.domain.board.domain.mapper")
class BoardApplicatoin

fun main(args: Array<String>) {
    runApplication<BoardApplicatoin>(*args)
}
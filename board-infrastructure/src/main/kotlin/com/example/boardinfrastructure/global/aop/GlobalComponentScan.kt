package com.example.boardinfrastructure.global.aop

import com.example.boarddomain.global.annotation.UseCase
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = ["com.example.boarddomain"],
    includeFilters = [
        Filter(
            type = FilterType.ANNOTATION,
            classes = [UseCase::class]
        )
    ]
)
class GlobalComponentScan
package com.shoesyouwant.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShoesApplication

fun main(args: Array<String>) {
    runApplication<ShoesApplication>(*args)
}

package org.lafeuille.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoSpringAwsApplication

fun main(args: Array<String>) {
    runApplication<DemoSpringAwsApplication>(*args)
}

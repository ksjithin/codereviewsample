
package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.example.mapper")
class VulnerableApp

fun main(args: Array<String>) {
    runApplication<VulnerableApp>(*args)
}

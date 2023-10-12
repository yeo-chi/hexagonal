package yeo.chi.study.hexagonal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = ["yeo.chi.study.hexagonal.configuration.jwt"])
@EnableFeignClients
class HexagonalApplication

fun main(args: Array<String>) {
    runApplication<HexagonalApplication>(*args)
}

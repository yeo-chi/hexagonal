package yeo.chi.study

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = ["yeo.chi.study.user.configuration.jwt"])
@EnableFeignClients
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

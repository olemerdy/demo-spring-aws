package org.lafeuille.demo

import org.lafeuille.demo.infra.localstack.LocalStackDefaults
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.localstack.LocalStackContainer

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {
    @Bean
    @ServiceConnection
    fun localStackContainer(): LocalStackContainer = LocalStackContainer(LocalStackDefaults.DOCKER_IMAGE_NAME)
}

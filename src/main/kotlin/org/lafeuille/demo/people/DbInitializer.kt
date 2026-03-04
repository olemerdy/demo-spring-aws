package org.lafeuille.demo.people

import io.awspring.cloud.dynamodb.DynamoDbTemplate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import software.amazon.awssdk.enhanced.dynamodb.Key
import java.util.UUID


@Component
class DbInitializer(
    private val dynamoDbTemplate: DynamoDbTemplate
) {
    private val log: Logger = LoggerFactory.getLogger(DbInitializer::class.java)

    @EventListener(ApplicationReadyEvent::class)
    fun initialize() {
        val entity = Person()
        val id: UUID = UUID.randomUUID()
        entity.id = id
        entity.name = "John Doe"
        entity.lastName = "Smith"

        dynamoDbTemplate.save(entity)

        val entityFromDb: Person? = dynamoDbTemplate.load(
            Key.builder().partitionValue(id.toString()).build(),
            Person::class.java
        )

        log.info("Found Person from DynamoDb: {}", entityFromDb)
    }
}

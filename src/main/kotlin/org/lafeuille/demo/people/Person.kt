package org.lafeuille.demo.people

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import java.util.UUID

@DynamoDbBean
class Person(
    @get:DynamoDbPartitionKey
    var id: UUID = UUID.randomUUID(),
    var name: String = "John",
    var lastName: String = "Doe",
)
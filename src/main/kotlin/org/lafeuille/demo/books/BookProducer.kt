package org.lafeuille.demo.books

import io.awspring.cloud.sqs.operations.SqsTemplate
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class BookProducer(
    private val sqsTemplate: SqsTemplate,
) {
    @EventListener(ApplicationReadyEvent::class)
    fun produce() {
        val book = Book("isbn", "Name")
        sqsTemplate.send {
            it
                .queue("book-event-queue")
                .payload(book)
                .header("eventId", UUID.randomUUID().toString())
                .delaySeconds(2)
        }
    }
}

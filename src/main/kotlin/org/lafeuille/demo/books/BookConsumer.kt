package org.lafeuille.demo.books

import io.awspring.cloud.sqs.annotation.SqsListener
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component


@Component
class BookConsumer {
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @SqsListener("book-event-queue")
    fun listen(@Payload payload: Book, @Headers headers: MutableMap<String?, Any?>?) {
        log.info("Book event received, headers: {}, payload: {}", headers, payload)
    }
}
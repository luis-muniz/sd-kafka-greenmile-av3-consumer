package com.service.consumers.subcribers

import com.service.consumers.domain.Event
import com.service.consumers.domain.enums.EventType
import com.service.consumers.repositories.EventRepository
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Subscriber(
    private val eventRepository: EventRepository
) {
    private val log = LoggerFactory.getLogger(Subscriber::class.java)

    @KafkaListener(
        topics = ["event-arrival"],
        groupId = "arrival"
    )
    fun consumeEventArrival(eventInfo: String) {
        val str = "\n++++++++++++++++++++++++++++++++++++++++\n++ Event: Arrival\n++ Info: ${eventInfo}\n\n"

        val newEvent = Event(eventType = EventType.ARRIVE, info = str)
        this.eventRepository.save(newEvent).subscribe()

        this.log.info(str)
    }

    @KafkaListener(
        topics = ["event-endangered-employee"],
        groupId = "endangered-employee"
    )
    fun consumeEventEndangeredEmployee(eventInfo: String) {
        val str = "\n++++++++++++++++++++++++++++++++++++++++\n++ Event: Endanger Employee\n++ Info: ${eventInfo}\n\n"

        val newEvent = Event(eventType = EventType.ENDANGERED_EMPLOYEE, info = str)
        this.eventRepository.save(newEvent).subscribe()

        this.log.info(str)
    }
}
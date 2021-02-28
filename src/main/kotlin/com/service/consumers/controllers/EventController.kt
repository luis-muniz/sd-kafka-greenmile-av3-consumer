package com.service.consumers.controllers

import com.service.consumers.domain.Event
import com.service.consumers.repositories.EventRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/events")
class EventController(
    private val eventRepository: EventRepository
) {
    @GetMapping
    fun getEvents(): Flux<Event> {
        return eventRepository.findAll()
    }
}
package com.service.consumers.repositories

import com.service.consumers.domain.Event
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface EventRepository: ReactiveMongoRepository<Event, String> {

}
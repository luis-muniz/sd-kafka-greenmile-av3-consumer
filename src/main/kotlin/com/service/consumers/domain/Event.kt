package com.service.consumers.domain

import com.service.consumers.domain.enums.EventType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "events")
data class Event(
    @Id
    val _id: String? = null,
    val eventType: EventType,
    val info: String,
)
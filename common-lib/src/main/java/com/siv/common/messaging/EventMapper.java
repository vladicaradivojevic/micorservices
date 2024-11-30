package com.siv.common.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siv.common.Event;

@Component
public final class EventMapper {
	
	@Autowired
    private final ObjectMapper objectMapper;
	
	public EventMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public <T> Event<T> extractEvent(String message, Class<T> clazz) {
		try {
			return objectMapper.readValue(message, objectMapper.getTypeFactory().constructParametricType(Event.class, clazz));
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Failed to convert JSON string to Event object", e);
		}
	}
	
	public Event<?> extractEvent(String message) {
		try {
			return objectMapper.readValue(message, Event.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Failed to convert JSON string to Event object", e);
		}
	}

	public <T> String toJson(Event<T> event) {
		try {
			return this.objectMapper.writeValueAsString(event);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Failed to convert event to JSON string", e);
		}
	}
}

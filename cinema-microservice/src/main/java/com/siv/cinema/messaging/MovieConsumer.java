package com.siv.cinema.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.siv.cinema.dto.MovieDto;
import com.siv.cinema.service.CinemaService;
import com.siv.common.Event;
import com.siv.common.EventTopic;
import com.siv.common.EventType;
import com.siv.common.messaging.EventMapper;

@Service
public class MovieConsumer {
	
	private final CinemaService cinemaService;

	private final EventMapper eventMapper;

	@Autowired
	public MovieConsumer(CinemaService cinemaService, EventMapper eventMapper) {
		this.cinemaService = cinemaService;
		this.eventMapper = eventMapper;
	}
	
	@KafkaListener(topics = EventTopic.MOVIE, groupId = "siv.cinema")
	public void listen(String message) {
		System.err.println("VLADA" + message);
		Event<MovieDto> event = eventMapper.extractEvent(message, MovieDto.class);

		if (event.getType().equals(EventType.CREATE.name())) {
			System.err.println("Detektovan novi film: " + event.getData());
			this.cinemaService.addMovie(event.getData());
		} else {
			System.err.println("Na topic movie detektovan event type: " + event.getType());

		}
	}
}

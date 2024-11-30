package com.siv.common;

import lombok.Data;

@Data
public final class Event<T> {

	private String type;
	private T data;
   
	private Event() {
	}

	private Event(String type, T data) {
		this.type = type;
		this.data = data;
	}
	
	public static <T> Event<T> of(String type, T data) {
		return new Event<T>(type, data);
	}
	
	public static <T> Event<T> of(EventType type, T data) {
		return new Event<T>(type.name(), data);
	}
}

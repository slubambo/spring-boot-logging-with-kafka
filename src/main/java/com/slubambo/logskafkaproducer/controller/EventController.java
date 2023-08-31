package com.slubambo.logskafkaproducer.controller;

import java.util.concurrent.Flow.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slubambo.logskafkaproducer.service.KafkaLogPublisher;

@RestController
@RequestMapping("/producer-app")
public class EventController {

	@Autowired
	private KafkaLogPublisher kafkaLogPublisher;

	@GetMapping("publish/{message}")
	public ResponseEntity<?> publishMessage(@PathVariable String message) {

		try {

			kafkaLogPublisher.sendMessageToTopic(message);

			return ResponseEntity.ok("Message published");

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}

package com.slubambo.logskafkaproducer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

public class KafkaLogPublisher {

	private KafkaTemplate<String, Object> template;

	public void sendMessageToTopic(String message) {
		CompletableFuture<SendResult<String, Object>> future = template.send("test-topic", message);

		future.whenComplete((result, ex) -> {

			if (ex == null) {
				System.out.println(
						"Send message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to send message=[" + message + "] due to " + ex.getMessage());
			}

		});

	}

}

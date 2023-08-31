package com.slubambo.logskafkaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

	public NewTopic createTopic() {
		return new NewTopic("simon-topic-1", 5, (short) 1);
	}

}

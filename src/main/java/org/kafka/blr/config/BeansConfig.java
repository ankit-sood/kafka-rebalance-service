package org.kafka.blr.config;

import java.util.function.Consumer;

import org.kafka.blr.service.KafkaConsumerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

@Configuration
public class BeansConfig {
	
	@Bean
	public Consumer<Message<String>> inputTopicConsumer(KafkaConsumerService kafkaConsumerService){
		return message -> kafkaConsumerService.processMessage(message);
	}
}

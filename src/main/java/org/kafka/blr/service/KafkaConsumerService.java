package org.kafka.blr.service;

import java.util.Objects;

import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	
	public void processMessage(Message<String> message) {
		try {
			System.out.println(message.getPayload());
			message.getHeaders();
		} finally {
			ackMessage(message);
		}
	}
	
	private void ackMessage(Message<String> message) {
		Acknowledgment ack = Objects.nonNull(message) ? message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class) : null;
		if(ack!=null) {
			ack.acknowledge();
		} else {
			System.out.print("Ack was null.");
		}
	}

}

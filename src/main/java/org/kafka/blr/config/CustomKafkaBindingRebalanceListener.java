package org.kafka.blr.config;

import java.util.Collection;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.TopicPartition;
import org.springframework.cloud.stream.binder.kafka.KafkaBindingRebalanceListener;
import org.springframework.stereotype.Component;

@Component
public class CustomKafkaBindingRebalanceListener implements KafkaBindingRebalanceListener
{
	 public void onPartitionsAssigned(String bindingName, Consumer<?, ?> consumer,
				Collection<TopicPartition> partitions, boolean initial) {
		 	System.out.println("CustomKafkaBindingRebalanceListener");
		 	if(initial) {
		 		for(TopicPartition partition: partitions) {
		 			//partition.
		 			System.out.println(partition.topic()+"-"+partition.partition());
		 			consumer.seek(partition, 3);
		 		}
		 	}
		}
}

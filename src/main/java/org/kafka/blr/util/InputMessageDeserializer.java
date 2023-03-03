package org.kafka.blr.util;

import org.apache.kafka.common.serialization.Deserializer;

public class InputMessageDeserializer implements Deserializer<String>{

	@Override
	public String deserialize(String topic, byte[] data) {
		return new String(data);
	}

}

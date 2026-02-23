import kafka.KafkaHelper

boolean result = KafkaHelper.consumeMessage("test-topic", "HelloKafka")

assert result : "Expected message not found!"
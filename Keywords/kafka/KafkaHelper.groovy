package kafka

import org.apache.kafka.clients.consumer.*
import java.time.Duration
import java.util.*

class KafkaHelper {

    static boolean consumeMessage(String topic, String expectedMessage) {

        Properties props = new Properties()
        props.put("bootstrap.servers", "localhost:9092")
        props.put("group.id", "katalon-group-" + System.currentTimeMillis())
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
        props.put("auto.offset.reset", "earliest")

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)
        consumer.subscribe(Arrays.asList(topic))

        boolean found = false

        for (int i = 0; i < 5; i++) {

            def records = consumer.poll(Duration.ofSeconds(3))

            for (record in records) {
                println("Received: " + record.value())

                if (record.value() != null && record.value().contains(expectedMessage)) {
                    found = true
                    break
                }
            }

            if (found) break
        }

        consumer.close()
        return found
    }
}
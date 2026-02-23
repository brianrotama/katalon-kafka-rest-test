# Katalon Technical Test

## Features
- REST API testing (Producer & Consumer)
- Kafka Consumer testing

## REST API
Using https://reqres.in

## Kafka Setup
1. docker-compose up -d
2. Create topic
3. Produce message
4. Run test case

## How to Run
Open Katalon → Run Test Suite



## Kafka Setup

### Start Kafka
docker compose up -d

### Create Topic
docker exec -it kafka-test-kafka-1 bash
kafka-topics --create \
--topic test-topic \
--bootstrap-server localhost:9092 \
--replication-factor 1 \
--partitions 1

### Produce Message
kafka-console-producer \
--topic test-topic \
--bootstrap-server localhost:9092

Type:
HelloKafka

test
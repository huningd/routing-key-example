# Routing Key Example
## Summary  [![Build Status](https://travis-ci.org/huningd/routing-key-example.svg?branch=master)](https://travis-ci.org/huningd/routing-key-example)
This example demonstrates the usage of routing key when working with [Spring Cloud Stream](https://cloud.spring.io/spring-cloud-stream/).

## Execute
To test this service create start a RabbitMQ and create the two vhosts accountancy and crm. Afterwards you can simple execute this service with
```
$> ./gradlew bootRun
``` 

## Important Links
- [Spring Cloud Stream](https://cloud.spring.io/spring-cloud-stream/)
- [Connecting to Multiple Systems](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/#multiple-systems)
- [Consumer Properties](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/#_rabbitmq_consumer_properties)
- [Producer Properties](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/#_rabbit_producer_properties)

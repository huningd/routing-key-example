# Routing Key Example
## Summary  [![Build Status](https://travis-ci.org/huningd/routing-key-example.svg?branch=master)](https://travis-ci.org/huningd/routing-key-example)
This example demonstrates the usage of routing key when working with [Spring Cloud Stream](https://cloud.spring.io/spring-cloud-stream/).

## Execute
To test this service create start a RabbitMQ and create the two vhosts accountancy and crm. Afterwards you can simple execute this service with
```
$> ./gradlew bootRun
``` 

## Create needed vhosts
As mentioned you for this example you need a RabbitMQ with the vhosts 'accountancy' and 'crm'. Therefore simply start a local RabbitMQ, e.q. with docker:
```
docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```
This will create a RabbitMQ container with management console. The management console is bound to the port 15672 and RabbitMQ is bound to 5672. The default user and password is guest/guest. You need this credentials to access the management api, see authorization header in the next examples. 
To create a new vhost you can send the next curl statement against the management api. This will create a new vhost 'accountancy'.    
```
curl -X PUT \
  http://localhost:15672/api/vhosts/accountancy \
  -H 'authorization: Basic Z3Vlc3Q6Z3Vlc3Q=' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json'
```
Accessing this vhost is only possible with the correct permissions. Assign with the following request all permission to user guest:
```
curl -X PUT \
  http://localhost:15672/api/permissions/accountancy/guest \
  -H 'authorization: Basic Z3Vlc3Q6Z3Vlc3Q=' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{"configure":".*","write":".*","read":".*"}'
```
Repeat both steps for the vhost 'crm'.


## Important Links
- [Spring Cloud Stream](https://cloud.spring.io/spring-cloud-stream/)
- [Connecting to Multiple Systems](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/#multiple-systems)
- [Consumer Properties](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/#_rabbitmq_consumer_properties)
- [Producer Properties](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/#_rabbit_producer_properties)
- [RabbitMQ Management HTTP API](https://pulse.mozilla.org/api/)

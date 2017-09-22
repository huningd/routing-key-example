package de.dhuning.cloud.stream.routingkeyexample

import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@Ignore("To execute this test RabbitMQ is necessary.")
class RoutingKeyExampleApplicationTests {

    @Test
    fun contextLoads() {
    }

}

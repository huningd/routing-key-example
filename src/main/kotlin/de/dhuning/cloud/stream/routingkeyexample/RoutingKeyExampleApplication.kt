package de.dhuning.cloud.stream.routingkeyexample

import de.dhuning.cloud.stream.routingkeyexample.api.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.cloud.stream.messaging.Source
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.support.GenericMessage


@SpringBootApplication
@EnableBinding(Source::class, Sink::class)
open class RoutingKeyExampleApplication : CommandLineRunner {

    @Autowired
    private val output: MessageChannel? = null

    @Throws(Exception::class)
    override fun run(vararg args: String) {
        output?.send(GenericMessage<Any>(Customer("1337", "Bob"), mapOf("tenantId" to "1337")))
    }

    @StreamListener(Sink.INPUT)
    fun receive(customer: Customer) {
        println(customer.toString())
    }
}


fun main(args: Array<String>) {
    SpringApplication.run(RoutingKeyExampleApplication::class.java, *args)
}

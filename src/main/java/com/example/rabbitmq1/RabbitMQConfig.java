package com.example.rabbitmq1;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "example.queue";
    public static final String EXCHANGE_NAME = "example.exchange";
    public static final String ROUTING_KEY = "routing.key";


    @Bean
    public Queue exampleQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange exampleExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding exampleBinding(Queue exampleQueue, DirectExchange exampleExchange) {
        return BindingBuilder.bind(exampleQueue)
                .to(exampleExchange)
                .with(ROUTING_KEY);
    }
}
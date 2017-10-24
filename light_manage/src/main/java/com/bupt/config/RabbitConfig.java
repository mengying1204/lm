package com.bupt.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by CJ on 2017/10/24.
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue monitorQueue() {
        return new Queue("monitor");
    }

}

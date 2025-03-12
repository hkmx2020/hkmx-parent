package com.hkmx.kafka.spingkafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * KafkaListener要做的事只是监听Topic中的数据并消费，如果在KafkaListener中还需要对异常进行处理则会显得代码块非常臃肿不利于维护，我们可以把异常
 * 处理的这些代码抽象出来，构造成一个异常处理器，KafkaListener中所抛出的异常都会经过ConsumerAwareErrorHandler异常处理器进行处理，这样就非常
 * 方便我们进行后期维护，比如后期更改异常处理业务的时候，只需要修改ConsumerAwareErrorHandler处理器就行了，而不需要KafkaListener的一堆代码中
 * 去修改代码。这也是一种思想的体现。
 */

@Slf4j
@Component
public class KafkaConsumerErrorHandler {

    @Bean
    public ConsumerAwareListenerErrorHandler consumerAwareErrorHandler() {
        return (Message<?> message, ListenerExecutionFailedException e, Consumer<?, ?> consumer) -> {
            // todo 执行消费异常之后的业务逻辑
            return new Object();
        };
    }
}

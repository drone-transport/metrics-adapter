package com.rb.alwaysontheroad.metricsadapter.config;

import com.rb.alwaysontheroad.metricsadapter.message.MetricsMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Slf4j
@Configuration
public class StreamChannelsConfig {
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
    public static final Random RANDOM = new Random();
    private final UUID droneId = UUID.randomUUID();

    @Bean
    public Supplier<Message<MetricsMessage>> physicalMetricsProducer() {
        return () -> {
            MetricsMessage metricsMessage = new MetricsMessage()
                    .setDroneId(droneId)
                    .setSpeed(this.randomSpeed());

            log.info("Sent message: {}", metricsMessage);

            this.holdThread();

            return MessageBuilder
                    .withPayload(metricsMessage)
                    .build();
        };
    }

    @Bean
    public Consumer<Message<MetricsMessage>> physicalMetricsConsumer() {
        return message -> {
            log.info("Received message: {}", message);

            this.holdThread();
        };
    }

    private void holdThread() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.error("Exception has occurred on attempt to make sleep thread", e);
        }
    }

    private double randomSpeed() {
        double start = 10;
        double end = 80;
        double random = RANDOM.nextDouble();
        double speed = start + (random * (end - start));
        return Double.parseDouble(DECIMAL_FORMAT.format(speed));
    }
}

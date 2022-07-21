package com.rb.alwaysontheroad.metricsadapter.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class MetricsMessage implements Identifiable {

    private UUID droneId;

    private Double speed;
}

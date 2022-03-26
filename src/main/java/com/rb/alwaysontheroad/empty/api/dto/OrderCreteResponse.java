package com.rb.alwaysontheroad.empty.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class OrderCreteResponse {

    private UUID orderId;
}

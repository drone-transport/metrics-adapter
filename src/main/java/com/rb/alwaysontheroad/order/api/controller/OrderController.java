package com.rb.alwaysontheroad.order.api.controller;

import com.rb.alwaysontheroad.order.api.dto.OrderCreteResponse;
import com.rb.alwaysontheroad.order.api.routes.OrderApiRoutes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Tag(name = "Order API controller")
@RestController
@RequiredArgsConstructor
public class OrderController {

    @Operation(summary = "Create new order")
    @GetMapping(
            value = OrderApiRoutes.ORDER_CREATE_URL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<OrderCreteResponse>> create() {
        OrderCreteResponse creteResponse = new OrderCreteResponse().setOrderId(UUID.randomUUID());
        log.info("Created order with details: '{}'", creteResponse);
        return Mono.just(ResponseEntity.ok(creteResponse));
    }
}

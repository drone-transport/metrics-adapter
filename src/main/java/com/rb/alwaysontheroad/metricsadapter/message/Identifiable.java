package com.rb.alwaysontheroad.metricsadapter.message;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface Identifiable {

    @NotNull
    UUID getDroneId();
}

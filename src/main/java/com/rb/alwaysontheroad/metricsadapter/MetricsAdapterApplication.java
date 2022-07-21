package com.rb.alwaysontheroad.metricsadapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//@EnableDiscoveryClient
//@EnableAdminServer
@SpringBootApplication
public class MetricsAdapterApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(MetricsAdapterApplication.class, args);
    }
}


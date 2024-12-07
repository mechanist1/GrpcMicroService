package com.example.protobufferstest;

import com.example.protobufferstest.Service.OrderServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProtoBuffersTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProtoBuffersTestApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(GRPCServer grpcServer) {
        return args -> {
            grpcServer.start();  // Start the gRPC server
        };
    }
}

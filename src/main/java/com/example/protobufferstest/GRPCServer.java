package com.example.protobufferstest;

import com.example.protobufferstest.Service.OrderServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GRPCServer {
    private OrderServiceImpl orderService;

    @Autowired
    public void GrpcServer(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    public void start() throws Exception {

        // Create a gRPC server and bind the service implementation to it
        Server server = ServerBuilder.forPort(50051)
                .addService(orderService) // Add the service implementation
                .build();

        // Start the server
        server.start();
        System.out.println("Server started, listening on 50051");

        // Keep the server running
        server.awaitTermination();
    }
}

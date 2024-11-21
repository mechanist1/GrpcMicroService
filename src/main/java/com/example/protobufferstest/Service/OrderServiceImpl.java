package com.example.protobufferstest.Service;

import com.example.protobufferstest.DAL.OrdersRepo;
import com.example.protobufferstest.Models.Order;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.grpc.generated.OrderResponse;
import com.example.grpc.generated.OrderRequest;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl extends com.example.grpc.generated.OrderServiceGrpc.OrderServiceImplBase {
    private final OrdersRepo orderRepository;

    @Override
    public void createOrder(Order request, StreamObserver<OrderResponse> responseObserver) {
        Order order = new Order();
        order.setServiceProviderId(request.getServiceProviderId());
        order.setServiceId(request.getServiceId());
        order.setTotalAmount(request.getTotalAmount());

        orderRepository.save(order);

        com.example.grpc.generated.OrderResponse response = OrderResponse.newBuilder()
                .setMessage("Order created successfully!")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getOrder(OrderRequest request, StreamObserver<com.example.grpc.generated.GrpcOrder> responseObserver) {
        Optional<Order> optionalOrder = orderRepository.findById(request.getId());
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();

            // Create a GrpcOrder object to send as the response
            com.example.grpc.generated.GrpcOrder response = com.example.grpc.generated.GrpcOrder.newBuilder()
                    .setId(order.getId())
                    .setBookingId(order.getBookingId()) // Correctly set BookingId
                    .setServiceProviderId(order.getServiceProviderId())
                    .setServiceId(order.getServiceId())
                    .setTotalAmount(order.getTotalAmount())
                    .build();

            responseObserver.onNext(response);  // Send the response
        } else {
            responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND));
        }
        responseObserver.onCompleted();
    }


    @Override
    public void updateOrder(Order request, StreamObserver<OrderResponse> responseObserver) {
        Optional<Order> optionalOrder = orderRepository.findById(request.getId());
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setServiceProviderId(request.getServiceProviderId());
            order.setServiceId(request.getServiceId());
            order.setTotalAmount(request.getTotalAmount());

            orderRepository.save(order);

            OrderResponse response = OrderResponse.newBuilder()
                    .setMessage("Order updated successfully!")
                    .build();

            responseObserver.onNext(response);
        } else {
            responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND));
        }
        responseObserver.onCompleted();
    }

    @Override
    public void deleteOrder(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
        if (orderRepository.existsById(request.getId())) {
            orderRepository.deleteById(request.getId());

            OrderResponse response = OrderResponse.newBuilder()
                    .setMessage("Order deleted successfully!")
                    .build();

            responseObserver.onNext(response);
        } else {
            responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND));
        }
        responseObserver.onCompleted();
    }
}
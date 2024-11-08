package com.example.protobufferstest.Service;


import com.example.grpc.generated.GreeterGrpc;
import com.example.grpc.generated.HelloReply;
import com.example.grpc.generated.HelloRequest;
import com.example.protobufferstest.Message;
import com.example.protobufferstest.MessagesRepo;
import io.grpc.stub.StreamObserver;
import io.grpc.stub.annotations.GrpcGenerated;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GreeterService extends GreeterGrpc.GreeterImplBase {
private MessagesRepo messagesRepo;
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String name = request.getName();
        Message msg = new Message();
        msg.setName(name);
        messagesRepo.save(msg);
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello, " + name)
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }


}

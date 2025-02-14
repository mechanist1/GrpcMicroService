// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MyMethods.proto

// Protobuf Java Version: 3.25.5
package com.example.protobufferstest.GRPCautogenerated.com.example.grpc.generated;

public interface GrpcInventoryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.grpc.GrpcInventory)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int64 service_provider_id = 3;</code>
   * @return The serviceProviderId.
   */
  long getServiceProviderId();

  /**
   * <code>int64 quantity = 4;</code>
   * @return The quantity.
   */
  long getQuantity();

  /**
   * <code>repeated .com.example.grpc.GrpcOrder orders = 5;</code>
   */
  java.util.List<com.example.protobufferstest.GRPCautogenerated.com.example.grpc.generated.GrpcOrder> 
      getOrdersList();
  /**
   * <code>repeated .com.example.grpc.GrpcOrder orders = 5;</code>
   */
  com.example.protobufferstest.GRPCautogenerated.com.example.grpc.generated.GrpcOrder getOrders(int index);
  /**
   * <code>repeated .com.example.grpc.GrpcOrder orders = 5;</code>
   */
  int getOrdersCount();
  /**
   * <code>repeated .com.example.grpc.GrpcOrder orders = 5;</code>
   */
  java.util.List<? extends com.example.protobufferstest.GRPCautogenerated.com.example.grpc.generated.GrpcOrderOrBuilder> 
      getOrdersOrBuilderList();
  /**
   * <code>repeated .com.example.grpc.GrpcOrder orders = 5;</code>
   */
  com.example.protobufferstest.GRPCautogenerated.com.example.grpc.generated.GrpcOrderOrBuilder getOrdersOrBuilder(
      int index);
}

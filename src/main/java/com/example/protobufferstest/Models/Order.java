package com.example.protobufferstest.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long BookingId;
    Long serviceProviderId;
    Long serviceId;
    Long totalAmount;
}

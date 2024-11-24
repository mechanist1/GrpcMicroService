package com.example.protobufferstest.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "order_inventory",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_id"))
    private List<Inventory> inventories = new ArrayList<>();



}

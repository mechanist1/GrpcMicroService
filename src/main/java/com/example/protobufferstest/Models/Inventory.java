package com.example.protobufferstest.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    String name;
    Long serviceProviderId;
    Long quantity;

    @ManyToMany(mappedBy = "inventories")
    private List<Order> orders=new ArrayList<>();
}

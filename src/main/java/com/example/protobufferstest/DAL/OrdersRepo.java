package com.example.protobufferstest.DAL;

import com.example.protobufferstest.Message;
import com.example.protobufferstest.Models.Order;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrdersRepo extends JpaRepository<Order,Long> {
}

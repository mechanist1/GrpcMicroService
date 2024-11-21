package com.example.protobufferstest.DAL;

import com.example.protobufferstest.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoriesRepo extends JpaRepository<Inventory, Long> {}
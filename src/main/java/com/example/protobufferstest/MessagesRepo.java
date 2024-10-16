package com.example.protobufferstest;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MessagesRepo extends JpaRepository<Message,Long> {
}

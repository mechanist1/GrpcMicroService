package com.example.protobufferstest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Message {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;

}

package com.lynam.Automated.Cuteness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TheModel {
    @Id
    @GeneratedValue
    private Long id;
    private String quote;
}

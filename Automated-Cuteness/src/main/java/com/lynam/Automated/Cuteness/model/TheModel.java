package com.lynam.Automated.Cuteness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


import java.io.Serializable;

@Entity
@Data
@Table
public class TheModel implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String quote;
    private String author;
}

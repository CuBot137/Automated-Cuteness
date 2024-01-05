package com.lynam.Automated.Cuteness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "QuoteDB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TheModel {

    @Id
    @GeneratedValue
    private Long id;
    private String quote;
    private String author;
}

package com.hackathon.gestion_bar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDrink;

    @Column(length = 100)
    private String nameDrink;

    private Double priceDrink;

    @ManyToOne
    private Category category;
}

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
public class Compose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompose;

    @ManyToOne
    private Drink drink;

    @ManyToOne
    private Cocktail cocktail;

}

package com.hackathon.gestion_bar.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class ParameterPostCoclail {
    private String nameCocktail;
    private List<ComposeParameter> compose;
}

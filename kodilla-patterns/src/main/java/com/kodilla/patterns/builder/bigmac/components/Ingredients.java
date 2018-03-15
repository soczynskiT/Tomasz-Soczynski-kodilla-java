package com.kodilla.patterns.builder.bigmac.components;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ingredients {
    public static final String LETTUCE = "LETTUCE";
    public static final String ONION = "ONION";
    public static final String BEACON = "BEACON";
    public static final String CUCUMBER = "CUCUMBER";
    public static final String PEPPER = "PEPPER";
    public static final String CHILI = "CHILI";
    public static final String MUSHROOMS = "MUSHROOMS";
    public static final String SHRIMPS = "SHRIMPS";
    public static final String CHEESE = "CHEESE";
    public static final String TOMATO = "TOMATO";

    private final Set<String> burgerIngredients;

    public Ingredients() {
        this.burgerIngredients = setBurgerIngredients();
    }

    private Set<String> setBurgerIngredients() {
        return new HashSet<>(Arrays.asList(LETTUCE, ONION, BEACON, CUCUMBER, PEPPER, CHILI,
                MUSHROOMS, SHRIMPS, CHEESE));
    }

    public Set<String> getBurgerIngredients() {
        return burgerIngredients;
    }
}

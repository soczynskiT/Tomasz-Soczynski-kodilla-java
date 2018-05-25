package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.bigmac.components.Ingredients;
import com.kodilla.patterns.builder.bigmac.components.Roll;
import com.kodilla.patterns.builder.bigmac.components.Sauce;

import java.util.ArrayList;
import java.util.List;

public final class BigMac {
    private final Roll roll;
    private final int burgers;
    private final Sauce sauce;
    private final List<String> burgerIngredients;

    public static class BigMacBuilder {
        private final Ingredients ingredients = new Ingredients();
        private Roll roll;
        private int burgers;
        private Sauce sauce;
        private final List<String> burgerIngredients = new ArrayList<>();

        BigMacBuilder roll(boolean withSesame) {
            this.roll = new Roll(withSesame);
            return this;
        }

        BigMacBuilder burgers(int burgersNo) {
            if (burgersNo >= 0) {
                if (burgersNo <= 3) {
                    this.burgers = burgersNo;
                } else {
                    System.out.println("Maximum burgers no = 3, burgers no set to maximum");
                    this.burgers = 3;
                }
            } else {
                throw new IndexOutOfBoundsException("Wrong value of burger number");
            }
            return this;
        }

        BigMacBuilder sauce(String sauce) {
            this.sauce = new Sauce(sauce);
            return this;
        }

        BigMacBuilder ingredients(String ingredient) {
            if (ingredients.getBurgerIngredients().contains(ingredient)) {
                burgerIngredients.add(ingredient);
            } else {
                System.out.println("This ingredient is not available for burgers !");
            }
            return this;
        }

        BigMac build() {
            if (roll != null) {
                return new BigMac(roll, burgers, sauce, burgerIngredients);
            } else {
                System.out.println("At least roll is required to create BigMac");
                return null;
            }
        }
    }

    private BigMac(final Roll roll, final int burgers, final Sauce sauce, final List<String> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.burgerIngredients = ingredients;
    }

    public Roll getRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauceName() {
        return sauce.getName();
    }

    public List<String> getBurgerIngredients() {
        return burgerIngredients;
    }

    @Override
    public String toString() {
        return "BigMac components:\n" +
                "Roll: [" + roll + "]\n" +
                "Burgers no: [" + burgers + "]\n" +
                "Sauce: [" + sauce + "]\n" +
                "Ingredients: " + burgerIngredients.toString();
    }
}

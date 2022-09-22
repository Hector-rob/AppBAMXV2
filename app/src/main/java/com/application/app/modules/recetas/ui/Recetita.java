package com.application.app.modules.recetas.ui;

public class Recetita {

    String title, ingredients;

    public Recetita(){}

    public Recetita(String title, String ingredients) {
        this.title = title;
        this.ingredients = ingredients;
    }

    public String getTitle() {
        return title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}

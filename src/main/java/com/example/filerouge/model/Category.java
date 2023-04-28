package com.example.filerouge.model;

import java.util.Collection;

public class Category {
    private int idCategory;
    private String nameCategory;
    private String descriptionCategory;
    private Collection<Product> products;

    public Category(String nameCategory, String descriptionCategory) {
        this.nameCategory = nameCategory;
        this.descriptionCategory = descriptionCategory;
    }

    public Category(int idCategory, String nameCategory, String descriptionCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.descriptionCategory = descriptionCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public String getDescriptionCategory() {
        return descriptionCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        this.descriptionCategory = descriptionCategory;
    }
}

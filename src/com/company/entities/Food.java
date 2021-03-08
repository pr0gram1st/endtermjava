package com.company.entities;

public class Food {
    int id;
    String name;
    String type;
    int calories;
    int price;
    public Food(int id, String name, String type, int calories, int price){
        this.id = id;
        this.name = name;
        this.type = type;
        this.calories = calories;
        this.price = price;
    }
    public Food(String name, String type, int calories, int price){
        this.name = name;
        this.type = type;
        this.calories = calories;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Food Info: " + '\n' +
                "Id = " + id + '\n' +
                "Name = " + name + '\n' +
                "Type = " + type + '\n' +
                "Calories = " + calories + '\n' +
                "Price = " + price + '\n';
    }
}

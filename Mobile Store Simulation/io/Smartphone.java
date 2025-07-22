package io;

public class Smartphone {
    private String ModelName;
    private int price;
    private String color;

    public Smartphone(String ModelName, int price, String color)
    {
        this.ModelName = ModelName;
        this.price = price;
        this.color = color;
    }

    public String getModelName()
    {
        return ModelName;
    }

    public int getPrice()
    {
        return price;
    }

    @Override
    public String toString()
    {
        return String.format("Model: %s, Color: %s, Price: ₹%d", ModelName, color, price);
    }
}

package rikkei.academy.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String country;
    private int price;
    public Product(){

    }

    public Product(int id, String name, String country, int price) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", price=" + price +
                '}';
    }
}

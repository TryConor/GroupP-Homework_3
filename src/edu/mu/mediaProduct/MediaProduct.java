package edu.mu.mediaProduct;

import edu.mu.products.Genre;

public class MediaProduct {

    private String type;
    protected String title;
    protected double price;
    protected int year; 
    protected Genre genre;

    public MediaProduct(String type, String title, double price, int year, Genre genre) {
        this.type = type;
        this.title = title;
        this.price = price;
        this.year = year;
        this.genre = genre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "MediaProduct [type=" + type + ", title=" + title + ", price=" + price + ", year=" + year + ", genre=" + genre + "]";
    }
}

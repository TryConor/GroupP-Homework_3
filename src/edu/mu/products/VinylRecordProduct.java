package edu.mu.products;

import edu.mu.mediaProduct.MediaProduct;
import edu.mu.products.Genre;

public class VinylRecordProduct extends MediaProduct {

    public VinylRecordProduct(String title, double price, int year, Genre genre) {
        super("Vinyl", title, price, year, genre);
    }

    public VinylRecordProduct(VinylRecordProduct other) {
        super(other.getType(), other.getTitle(), other.getPrice(), other.getYear(), other.getGenre());
    }
}

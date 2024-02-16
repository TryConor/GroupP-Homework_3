package edu.mu.products;

import edu.mu.mediaProduct.MediaProduct;
import edu.mu.products.Genre;

public class TapeRecordProduct extends MediaProduct {

    public TapeRecordProduct(String title, double price, int year, Genre genre) {
        super("Tape", title, price, year, genre);
    }

    public TapeRecordProduct(TapeRecordProduct other) {
        super(other.getType(), other.getTitle(), other.getPrice(), other.getYear(), other.getGenre());
    }
}

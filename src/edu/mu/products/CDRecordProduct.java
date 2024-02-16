package edu.mu.products;

import edu.mu.mediaProduct.MediaProduct;
import edu.mu.products.Genre;

public class CDRecordProduct extends MediaProduct {

    public CDRecordProduct(String title, double price, int year, Genre genre) {
        super("CD", title, price, year, genre);
    }

    public CDRecordProduct(CDRecordProduct other) {
        super(other.getType(), other.getTitle(), other.getPrice(), other.getYear(), other.getGenre());
    }
}

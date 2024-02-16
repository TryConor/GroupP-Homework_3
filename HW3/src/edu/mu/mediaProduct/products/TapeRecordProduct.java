package edu.mu.mediaProduct.products;
import edu.mu.mediaProduct.MediaProduct;

public class TapeRecordProduct extends MediaProduct {
	
	public TapeRecordProduct (String title, double price, int year, Genre genre) {
		
		super(title, price, year, genre);
		
	}
	
	public TapeRecordProduct(TapeRecordProduct other) {
		
		super(other.title, other.price, other.year, other.genre);
		
	}

}
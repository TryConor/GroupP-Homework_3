package edu.mu.products;
import edu.mu.mediaProduct.MediaProduct;

public class CDRecordProduct extends MediaProduct {

	public CDRecordProduct(String title, double price, int year, Genre genre) {
		
		super(title, price, year, genre);
		
	}
	
	public CDRecordProduct(CDRecordProduct other) {
		
		super(other.title, other.price, other.year, other.genre);
		
	}
	
}

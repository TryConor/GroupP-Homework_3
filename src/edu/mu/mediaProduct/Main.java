package edu.mu.mediaProduct;
import edu.mu.products.Genre;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MediaProduct product = new MediaProduct("Movie", 19.99, 2023, Genre.ROCK);
        System.out.println(product);

	}

}

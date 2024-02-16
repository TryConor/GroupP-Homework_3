package edu.mu.StockManagerSingleton;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import edu.mu.mediaProduct.MediaProduct;

public class StockManagerSingleton {
	
	private static StockManagerSingleton instance = null;
	
	private final static String filePath = "files/inventory.csv";
		
	private StockManagerSingleton() {
		
	}
	
	public static StockManagerSingleton getInstance() {
		if(instance == null) {
			instance = new StockManagerSingleton();
		}
		return instance;
	}
	
	ArrayList<MediaProduct> inventory = new ArrayList<MediaProduct>();
	
	public boolean initializeStock() {
		try {
			
			return true;
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}

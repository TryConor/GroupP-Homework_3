package edu.mu.StockManagerSingleton;

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
	
}

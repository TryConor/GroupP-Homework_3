# GroupP-Homework_3
Homework 3

__Main: __

Our main demonstrating the addItem method when this method is called from StockManagerSingleton. 
It then attempts to create 3 media products and add them to the csv.
However, the program is actually tripling the amount of entries in the csv.
I believe this is because each time a new item is created it is actually duplicating the entire csv along with it (thats just my theory)
This method returns output "True"

Next our program calls the updateItemPrice method from StockManagerSingleton 
In our program we demonstrate that ItemPrice is working by choosing to update ProductA from $19.99 to $24.99
In the csv file ProductA is updated from $19.99 to $24.99
This method returns output "True"

Next our program calls the removeItem method from StockManagerSingleton
We demonstrate that removeItem is working by showing that we can remove ProductB from the csv.
This method returns output "True"

Next we call stockManager.printListOfMediaProduct(vinylRecords);, stockManager.printListOfMediaProduct(cdRecords);,
and stockManager.printListOfMediaProduct(tapeRecords);
All 3 of these ArrayLists return their correct outputs.

__Singleton: __

StockManagerSingleton hosts the bulk of our methods. Each method has extensive comments to understand how they work.
Stock Manager Singleton has a constructor and a copy constructor to prevent information loss.
Initialize Stock reads the bulk of our data from the CSV
Here you will also find our methods for addItem, updateItemPrice, removeItem, saveStock, getMediaProductBelowPrice, printListOfMediaProduct,
and the creation and calling of three seperate ArrayLists for outputting CDs, Tapes, and Vinyls. 

__MediaProduct: __
Contains our protected and privated atributes. Contains all getter, setter, and toString methods. 

Conor McLaughlin 
Mikey Keeny
Kristyn Morgenthaler 
Eli Wuerth 



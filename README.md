# GroupP-Homework_3
Homework 3

**Main: **

Our main begins by demonstrating the addItem method when this method is called from StockManagerSingleton. 
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



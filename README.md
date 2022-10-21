# PTBS-SER515-CS
 Author: Sahithya Cherukuri (scheru20) --
SER 515 
 ## Product Trading and Bidding System

####The System Functioning is as follows: 
- Seller logs into the system and chooses the products they wish to sell.
- Seller is prompted to enter the price (offerings) for each of the selected product
- Seller completes his offering he is logged out from the system
(Run the system again)
- Now Buyer logs into the system
- Buyer is provided with an option to choose whether to view or to save.
- If Buyer wants to view the offerings:
    - Buyer chooses the products he wants to view
    - Buyer clicks on view
    - Sees the quoted/offered price
    - See the count of expired offers
- If Buyer wants to add their bid, they click on the items they wish to bid and click on save
    - Buyer is prompted to enter the bid amount for each of the selected products.
- Buyer can then view the bid and offering.
- The later functionality includes seller accepting the bid from any interested buyer. 


####The functionality of the diagrams is as follows:

**Facade Design Pattern**
- Facade acts as the interface between GUI and underlying classes. 

Implementation: The PTBS (GUI in the repo) calls Facade to internally call and load data. 

**Bridge Design Pattern**
- Bridge is used to configure the implementation at runtime. (provides abstraction level)
 
Implementation: While displaying the menu in the PTBS GUI, the menu will be loaded at runtime when we choose Meat and Produce Pane.

**Factory Design Pattern**
- The parameters required to display the menus at runtime are specified by Factory Design Pattern

Implementation:  While displaying the menu, we use UserType to get when buyer or seller interface needs to be created and which menu is to be shown.

**Iterator**
- Helps iterate through product list and offering list

Implementation: While loading data from the file, product and offering iterator can be used to iterate through all the products present.

**Visitor**
- When we have to load all the offerings, we visit the data to check for any redundant offerings present to either remove or display the appropriate data

Implementation: While displaying the offerings to Buyer we check for the expired items (count is calculated)
 
####The Screenshots of the various instances is attached below - 

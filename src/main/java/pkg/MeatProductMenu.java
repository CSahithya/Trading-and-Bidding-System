package pkg;

/*
The MeatProductMenu java class
author: Sahithya Cherukuri
scheru20
SER515-Design Patterns
PTBS
 */

public class MeatProductMenu implements ProductMenu{
    public Product[] showMenu(){
        System.out.println("Factory Pattern to get the MeatProductMenu");
        LoadData ld = new LoadData();
        return ld.getProducts();
    }
    public void showAddButton(){

    }
    public void showViewButton(){

    }
    public void showRadioButton(){

    }
    public void showLabels(){

    }
    public void showComboxes(){

    }
}
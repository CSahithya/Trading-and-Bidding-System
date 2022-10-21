package pkg;

/*
The Seller Person Java Class File
author: Sahithya Cherukuri
scheru20
SER515-Design Patterns
PTBS
 */

public class Seller extends Person {
    Product[] pro;
    private ProductMenu theProductMenu;
    public void showMenu(){


    }
    public Product[] CreateProductMenu(){
        System.out.println("Bridge Pattern Referenced");
        theProductMenu = new MeatProductMenu();
        pro = theProductMenu.showMenu();
        return pro;
    }
}
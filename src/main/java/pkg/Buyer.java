package pkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
The Buyer Person java class file
author: Sahithya Cherukuri
scheru20
SER515-Design Patterns
PTBS
 */

public class Buyer extends Person {
    private ProductMenu theProductMenu;
    Product[] pro;
    public void showMenu(){

    }

    // Buyer calls the produce menu to display the products available
    public Product[] CreateProductMenu(){
        System.out.println("Bridge Pattern Referenced");
        theProductMenu = new ProduceProductMenu();
        pro = theProductMenu.showMenu();
        return pro;
    }
}
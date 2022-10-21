package pkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Buyer extends Person {
    private ProductMenu theProductMenu;
    Product[] pro;
    public void showMenu(){


    }
    public Product[] CreateProductMenu(){
        System.out.println("Bridge Pattern Referenced");
        theProductMenu = new ProduceProductMenu();
        pro = theProductMenu.showMenu();
        return pro;
    }
}
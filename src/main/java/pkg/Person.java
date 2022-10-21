package pkg;

/*
The Abstract Person Class File
author: Sahithya Cherukuri
scheru20
SER515-Design Patterns
PTBS
 */

public abstract class Person{
    private ProductMenu theProductMenu;
    public abstract void showMenu();
    public void showAddButton(){

    }
    public void showViewButton(){

    }
    public void showRadioButton(){

    }
    public void showLabels(){

    }
    public abstract Product[] CreateProductMenu();
}
package pkg;

/*
The Product Menu Implementor
author: Sahithya Cherukuri
scheru20
SER515-Design Patterns
PTBS
 */

public interface ProductMenu{
    public abstract Product[] showMenu();
    public abstract void showAddButton();
    public abstract void showViewButton();
    public abstract void showRadioButton();
    public abstract void showLabels();
    public abstract void showComboxes();
}
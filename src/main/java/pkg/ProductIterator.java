package pkg;
import java.util.ArrayList;
import java.util.Iterator;

/*
The Product Iterator file to iterate through the ProductList
author: Sahithya Cherukuri
scheru20
SER515-Design Patterns
PTBS
 */

public class ProductIterator implements Iterator<Product> {
    ClassProductList theProductList;
    int currentProduct = -1;

    public ProductIterator() {
    }

    public ProductIterator(ClassProductList productList) {
        theProductList = productList;
    }

    public boolean hasNext() {
        if (currentProduct >= theProductList.size() - 1)
            return false;
        else
            return true;
    }

    public Product next() {
        if (hasNext() == true) {
            currentProduct++;
            return (Product) theProductList.get(currentProduct);
        } else {
            return null;
        }
    }

    public void remove() {
        if (currentProduct == -1)
            currentProduct++;
        theProductList.remove(currentProduct);
    }

    // the next Course that fits the given CourseName
    public Product next(String CourseName) {
        Product theProduct;
        theProduct = (Product) next();
        while (theProduct != null) {
            if (CourseName.compareTo(theProduct.toString()) == 0) {
                return theProduct;
            }
            theProduct = (Product) next();
        }
        return null;
    }

}
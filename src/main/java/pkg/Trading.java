package pkg;

/*
The Trading Class File
author: Sahithya Cherukuri
scheru20
SER515-Design Patterns
PTBS
 */

public class Trading {
    Product p;
    Trading(){
        p = new Product();
    }
    void accept(NodeVisitor visitor) {
        visitor.visitProduct(p);
    }
}

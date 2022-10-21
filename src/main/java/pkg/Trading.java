package pkg;

public class Trading {
    Product p;
    Trading(){
        p = new Product();
    }
    void accept(NodeVisitor visitor) {
        visitor.visitProduct(p);
    }
}

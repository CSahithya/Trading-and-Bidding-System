package pkg;

import java.util.ArrayList;

/*
The Product Class that has the Product information
author: Sahithya Cherukuri
scheru20
SER515-Design Patterns
PTBS
 */

public class Product {
    private String type;
    private String name;
    private ArrayList<String> offering;

    Product(){
        this.offering = new ArrayList<>();
    }

    public void setOffering(String offer) {
        this.offering.add(offer);
    }

    public ArrayList<String> getOffering() {
        return offering;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}

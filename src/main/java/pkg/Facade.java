package pkg;

import java.util.*;

public class Facade{
    private int UserType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList;
    private Person thePerson;

    public boolean login(){
        UserType = 1;
        return true;
    }

    public void addTrading(){

    }
    public void viewTrading(){

    }
    public void decideBidding(){

    }
    public void discussBidding(){

    }
    public void submitBidding(){

    }
    public void remind(){

    }
    public void createUser(UserInfoItem userInfoItem){

    }
    public void createProductList(){

    }
    public void AttachProductToUser(){

    }
    public Product SelectProduct(){

        return null;
    }
    public void productOperation(){

    }
}
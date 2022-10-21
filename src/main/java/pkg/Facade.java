package pkg;

import java.io.*;
import java.util.*;

public class Facade{
    protected int userType;
    protected Product theSelectedProduct;
    private int nProductCategory;
    protected Product[] theProductList;
    protected Product[] theOfferingList;
    protected Person thePerson;
    protected UserInfoItem user = null;
    PTBS pb;
    Offering offer;
    private LoadData ld;

    Facade(){
        ld = new LoadData();
        offer = new Offering();
        System.out.println("In Facade Class");
    }

    public boolean login(){
        UserInfoItem[] buyers = ld.getBuyers();
        UserInfoItem[] sellers = ld.getSellers();
        for(int i=0;i<buyers.length;i++){
            if(buyers[i].getUserName().equals(user.getUserName())&&buyers[i].getPassword().equals(user.getPassword())){
                userType=1;
                thePerson = new Buyer();
                return true;
            }
        }
        for(int i=0;i<sellers.length;i++){
            if(sellers[i].getUserName().equals(user.getUserName())&&sellers[i].getPassword().equals(user.getPassword())){
                userType=0;
                thePerson = new Seller();
                return true;
            }
        }
        return false;
    }

    public void addTrading(){
        System.out.println("Offering added "+theSelectedProduct);
        offer.createOffering(theSelectedProduct,user.getUserName());
    }
    public String viewTrading(String s){
        //theOfferingList = new ProduceProductMenu().showMenu();
        OfferingIterator oi = new OfferingIterator();
        if(oi.hm.containsKey(s))
            return oi.hm.get(s);
        else return "No Offerings yet";
    }
    public void decideBidding(){

    }
    public void discussBidding(){

    }
    public void submitBidding(){

    }
    public int remind(){
        Trading t = new Trading();
        ReminderVisitor rv = new ReminderVisitor();
        rv.visitTrading(t);
        return  rv.expiredCount;
    }
    public void createUser(UserInfoItem userInfoItem){
        this.user = userInfoItem;
    }
    public boolean createNewUser(String usertype, String userName, String pswd){
        File addUser;
        try{
            if(usertype.equals("0")){
                addUser = new File("src\\main\\resources\\SellerInfo.txt");
                FileWriter fw = new FileWriter(addUser, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.newLine();
                bw.append(userName+":"+pswd);
                bw.close();
                fw.close();
            }
            else if (usertype.equals("1")){
                addUser = new File("src\\main\\resources\\BuyerInfo.txt");
                FileWriter fw = new FileWriter(addUser, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.newLine();
                bw.append(userName+":"+pswd);
                bw.close();
                fw.close();
            }
            else{
                return false;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void createProductList(){
        if(userType==1){
            theProductList = thePerson.CreateProductMenu();
        }
        else if (userType==0){
            theProductList = thePerson.CreateProductMenu();
        }

    }
    public void AttachProductToUser(){
        try{
            File userProduct = new File("src\\main\\resources\\UserProduct.txt");
            FileWriter fw = new FileWriter(userProduct, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.append(user.getUserName()+":"+theSelectedProduct.getName());
            bw.close();
        }catch (FileNotFoundException f){
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Product SelectProduct(){

        return null;
    }
    public void productOperation(){

    }
}
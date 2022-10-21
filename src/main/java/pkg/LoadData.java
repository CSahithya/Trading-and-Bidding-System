package pkg;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class LoadData {
    File buyers = new File("src\\main\\resources\\BuyerInfo.txt");
    File sellers = new File("src\\main\\resources\\SellerInfo.txt");
    File userProducts = new File("src\\main\\resources\\UserProduct.txt");
    File products = new File("src\\main\\resources\\ProductInfo.txt");
    File offering = new File("src\\main\\resources\\Offerings.txt");
    private Product[] pro;
    private UserInfoItem[] buyer;
    private UserInfoItem[] seller;

    public Product[] getOfferings(){
        StringBuilder sb = new StringBuilder();
        int meat=0, produce=0;
        Scanner sc;
        try{
            sc = new Scanner(offering);
            while(sc.hasNext()){
                sb.append(sc.nextLine()+"\n");
            }
        }catch (FileNotFoundException f){
            f.printStackTrace();
        }
        String s[] = sb.toString().split("\n");
        pro = new Product[s.length];
        if(s.length == 0 || (s.length==1 && s[0].equals(""))){
            return null;
        }
        for(int i=0;i<s.length;i++){
            String temp[]=s[i].split(":");
            pro[i]=new Product();
            if (temp[0].equals("Meat")) {
                meat++;
                pro[i].setName(temp[1]);
                pro[i].setType(temp[0]);
            }
            else {
                produce++;
                pro[i].setName(temp[1]);
                pro[i].setType(temp[0]);
            }
        }
        return pro;
    }

    public Product[] getProducts(){
        //System.out.println("");
        StringBuilder sb = new StringBuilder();
        int meat=0, produce=0;
        Scanner sc;
        try{
            sc = new Scanner(products);
            while(sc.hasNext()){
                sb.append(sc.nextLine()+"\n");
            }
        }catch (FileNotFoundException f){
            f.printStackTrace();
        }
        String s[] = sb.toString().split("\n");
        pro = new Product[s.length];
        for(int i=0;i<s.length;i++){
            String temp[]=s[i].split(":");
            pro[i]=new Product();
            if (temp[0].equals("Meat")) {
                meat++;
                pro[i].setName(temp[1]);
                pro[i].setType(temp[0]);
            }
            else {
                produce++;
                pro[i].setName(temp[1]);
                pro[i].setType(temp[0]);
            }
        }
        return pro;
    }
    public UserInfoItem[] getBuyers(){
        StringBuilder sb = new StringBuilder();
        Scanner sc = null;
        try{
            sc = new Scanner(buyers);
            while(sc.hasNext()){
                sb.append(sc.nextLine()+"\n");
            }
            String s[] = sb.toString().split("\n");
            buyer = new UserInfoItem[s.length];
            for(int i=0;i<s.length;i++){
                String[] temp = s[i].split(":");
                buyer[i] = new UserInfoItem();
                buyer[i].setUserName(temp[0]);
                buyer[i].setPassword(temp[1]);
            }
        }catch(FileNotFoundException f){
            f.printStackTrace();
        }
        //System.out.println(Arrays.toString(buyer));
        return buyer;
    }
    public UserInfoItem[] getSellers(){
        StringBuilder sb = new StringBuilder();
        Scanner sc = null;
        try{
            sc = new Scanner(sellers);
            while(sc.hasNext()){
                sb.append(sc.nextLine()+"\n");
            }
            String s[] = sb.toString().split("\n");
            seller = new UserInfoItem[s.length];
            for(int i=0;i<s.length;i++){
                String[] temp = s[i].split(":");
                seller[i] = new UserInfoItem();
                seller[i].setUserName(temp[0]);
                seller[i].setPassword(temp[1]);
            }
        }catch(FileNotFoundException f){
            f.printStackTrace();
        }
        //System.out.println(Arrays.toString(seller));
        return seller;
    }
}

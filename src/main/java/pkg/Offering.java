package pkg;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/*
The Offering java class creates the offering (writes the offering to the text file locally)
Called from Facade
author: Sahithya Cherukuri
scheru20
SER515-Design Patterns
PTBS
 */

public class Offering{
    //private String name;
    //private String productType;
    public void createOffering(Product product, String name){
        try{
            File userProduct = new File("src\\main\\resources\\Offerings.txt");
            FileWriter fw = new FileWriter(userProduct, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if(userProduct.length()!=0)
            bw.newLine();
            String s = product.getOffering().toString();
            bw.append(product.getType()+":"+product.getName()+":"+ s.substring(1,s.length()-1));
            bw.close();
        }catch (FileNotFoundException f){
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
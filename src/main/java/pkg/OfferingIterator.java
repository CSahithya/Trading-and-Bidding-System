package pkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class OfferingIterator{
    HashMap<String, String> hm = new HashMap<>();
    OfferingIterator(){
        System.out.println("Offering Iterator. Iterator Pattern Reference");
        try{
            File userProduct = new File("src\\main\\resources\\Offerings.txt");
            Scanner sc = new Scanner(userProduct);
            StringBuilder sb = new StringBuilder();
            while ((sc.hasNext())){
                sb.append(sc.nextLine()+"\n");
            }
            if(sb.length()<=1) return;
            String[] prods = sb.toString().split("\n");
            for(int i=0;i< prods.length;i++){
                String[] temp = prods[i].split(":");
                /*
                order of values in prod -> type of product, name of product, price offered at,
                timestamp of offering and expiration value
                 */
                String prodInfo = "";
                for(int j=2;j<temp.length;j++){
                    prodInfo+=temp[j]+"   ";
                }

                String key = "";
                if(temp.length>1)
                    key = temp[0]+":"+temp[1];
                if(hm.containsKey(key)){
                    String store = hm.get(key)+"\n"+prodInfo;
                    hm.put(key,store);
                }
                else{
                    hm.put(key,prodInfo);
                }

                //System.out.println(hm);
            }
        }catch (FileNotFoundException f){
            f.printStackTrace();
        }
    }
}
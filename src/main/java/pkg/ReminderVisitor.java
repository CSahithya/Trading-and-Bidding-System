package pkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

/*
The Reminder Visitor class where the Date is compared and checked to see if an offering is expired
author: Sahithya Cherukuri
scheru20
SER515-Design Patterns
PTBS
 */

public class ReminderVisitor extends NodeVisitor {
    int expiredCount;
    ReminderVisitor(){
        expiredCount = 0;
    }

    @Override
    public void visitFacade(Facade facade) {

    }

    @Override
    public void visitProduct(Product product) {

    }

    @Override
    public void visitTrading(Trading trading) {
        System.out.println("Reminder Visitor to check the expiration Visited");
        File f = new File("src\\main\\resources\\Offerings.txt");
        StringBuilder sb = new StringBuilder();
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                sb.append(sc.nextLine()+"\n");
            }
            String s[]= sb.toString().split("\n");
            for(int i=0;i<s.length;i++){
                String temp[] = s[i].split(":");
                String[] exp = temp[s.length-1].split(" - ");
                DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new java.util.Date());
                Date d1 = simpleDateFormat.parse(String.valueOf(timeStamp));
                Date d2 = simpleDateFormat.parse(temp[s.length-2]);
                if(d1.compareTo(d2)>0){
                    int diff = (d2.getMinutes() - d1.getMinutes());
                    int comp = Integer.parseInt(String.valueOf(exp[1]));
                    if(diff > comp){
                        expiredCount++;
                    }

                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
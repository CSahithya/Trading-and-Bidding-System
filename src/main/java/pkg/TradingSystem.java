package pkg;

import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

public class TradingSystem{
    Facade f;
    PTBS pb;

    public static void main(String[] args) {
        TradingSystem ts = new TradingSystem();
        ts.init();
    }
    public void init(){
        pb = new PTBS();
        while(!pb.loginVal){}
        if(pb.loginVal){
            if(pb.userType==1){
                Person buyer = new Buyer();
                buyer.showMenu();
            }
        }
        //while(!f.login()){}
        //f.viewTrading();


    }
}
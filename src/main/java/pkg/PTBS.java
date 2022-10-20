package pkg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PTBS{
    private JLabel Username, Password;
    private JTextField textField1;
    private JButton Login;
    private JPasswordField passwordField1;
    private JPanel panel;
    private JFrame frame;
    protected JFrame buyerFrame;
    protected JFrame sellerFrame;

    protected String userName;
    protected String pswd;
    protected boolean loginVal=false;
    protected int userType = -1;
    private LoadData ld;
    private Facade facade;

    PTBS(){
        facade = new Facade();
        this.createLogin();
    }
    private void createLogin() {
        panel = new JPanel();
        frame = new JFrame("Login Frame");
        panel.setLayout(null);
        frame.setTitle("LOGIN PAGE");
        frame.setLocation(400, 200);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Username = new JLabel("Username");
        Username.setBounds(30,50,100,20);
        panel.add(Username);

        textField1 = new JTextField();
        textField1.setBounds(120, 50, 150, 20);
        panel.add(textField1);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(120, 80, 150, 20);
        panel.add(passwordField1);

        Password = new JLabel("Password");
        Password.setBounds(30, 80, 100, 20);
        panel.add(Password);

        Login = new JButton("Login");
        Login.setBounds(70,150,100,20);
        Login.setForeground(Color.WHITE);
        Login.setBackground(Color.BLACK);
        panel.add(Login);

        Login.addActionListener(e -> {
            UserInfoItem user = new UserInfoItem();
            user.setUserName(textField1.getText());
            user.setPassword(String.valueOf(passwordField1.getPassword()));
            facade.createUser(user);
            if(facade.login()){
                facade.createProductList();
                if(facade.userType==1) {
                    if(facade.theProductList==null){
                        JOptionPane jp = new JOptionPane();
                        jp.showMessageDialog(frame,"Seller needs to enter offering first. Login as a seller First");
                        System.exit(0);
                    }
                    this.getBuyerGUI();
                }
                else{

                    this.getSellerGUI();
                }
            }
            else{
                JOptionPane jp = new JOptionPane();
                jp.showMessageDialog(frame,"Invalid Login");
            }
        });
        frame.add(panel);
        frame.setVisible(true);
    }

    public void getBuyerGUI(){
        //buyerFrame = new JFrame();
        frame.remove(panel);
        frame.setTitle("Buyer Frame");

        //frame.setVisible(false);
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(10,10,200,200);

        JPanel buyerPanel = new JPanel();
        buyerPanel.setBounds(10, 150,100,100);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JCheckBox[] checkBox = new JCheckBox[facade.theProductList.length];
        for(int i=0,x=120,y=120;i<facade.theProductList.length;i++,y=y+50){
            //JLabel l = new JLabel();
            checkBox[i] = new JCheckBox(facade.theProductList[i].getName());
            checkBox[i].setBounds(100,y, 50,50);
            if(facade.theProductList[i].getType().equals("Meat")){
                p1.add(checkBox[i]);
            }
            else{
                p2.add(checkBox[i]);
            }

        }
        tp.add("Meat",p1);
        tp.add("Produce",p2);
        JButton save = new JButton("Save");
        save.setBounds(10, 10, 70, 30);

        save.addActionListener(e -> {
            for(int i=0;i<checkBox.length;i++){
                if(checkBox[i].isSelected()) {
                    facade.theSelectedProduct = new Product();
                    facade.theSelectedProduct.setName(facade.theProductList[i].getName());
                    facade.theSelectedProduct.setType(facade.theProductList[i].getType());
                    facade.AttachProductToUser();
                }

            }
            facade.viewTrading();
        });

        buyerPanel.add(save);
        frame.add(buyerPanel);
        frame.add(tp);
        frame.setVisible(true);

    }

    public void getSellerGUI(){
        //buyerFrame = new JFrame();
        frame.remove(panel);

        frame.setTitle("Seller Frame");

        //frame.setVisible(false);
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(10,10,200,200);

        JPanel buyerPanel = new JPanel();
        buyerPanel.setBounds(10, 150,100,100);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JCheckBox[] checkBox = new JCheckBox[facade.theProductList.length];
        for(int i=0,x=120,y=120;i<facade.theProductList.length;i++,y=y+50){
            //JLabel l = new JLabel();
            checkBox[i] = new JCheckBox(facade.theProductList[i].getName());
            checkBox[i].setBounds(100,y, 50,50);
            if(facade.theProductList[i].getType().equals("Meat")){
                p1.add(checkBox[i]);
            }
            else{
                p2.add(checkBox[i]);
            }

        }
        tp.add("Meat",p1);
        tp.add("Produce",p2);
        JButton save = new JButton("Save");
        save.setBounds(10, 10, 70, 30);

        save.addActionListener(e -> {
            for(int i=0;i<checkBox.length;i++){
                if(checkBox[i].isSelected()) {
                    System.out.println(checkBox[i].getName());
                    facade.theSelectedProduct = new Product();
                    facade.theSelectedProduct.setName(facade.theProductList[i].getName());
                    facade.theSelectedProduct.setType(facade.theProductList[i].getType());
                    facade.AttachProductToUser();
                    facade.addTrading();
                }

            }

            facade.viewTrading();
        });

        buyerPanel.add(save);
        frame.add(buyerPanel);
        frame.add(tp);
        frame.setVisible(true);

    }
    public void errorLogin(){
        System.out.println("In login timer");
        JOptionPane jp = new JOptionPane();
        jp.showMessageDialog(frame,"Timer to enter user details exceeded");
        System.exit(0);
    }
}

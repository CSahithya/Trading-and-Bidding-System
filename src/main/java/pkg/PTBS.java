package pkg;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

/*
The Main GUI class file where all the frames and screens are implemented
author: Sahithya Cherukuri
scheru20
SER515-Design Patterns
PTBS
 */
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
        frame.setSize(400, 400);
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

        Password.setLabelFor(passwordField1);
        Username.setLabelFor(textField1);

        Login = new JButton("Login");
        Login.setBounds(200,150,70,20);

        Login.setForeground(Color.WHITE);
        Login.setBackground(Color.BLACK);
        panel.add(Login);

        JButton createUser = new JButton("Create User");
        createUser.setBounds(70,150,120,20);
        createUser.setForeground(Color.WHITE);
        createUser.setBackground(Color.BLACK);
        panel.add(createUser);

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

        createUser.addActionListener(e -> {
            JOptionPane jp = new JOptionPane();
            String s = jp.showInputDialog("UserType: 0(Seller)/1(Buyer)");
            if(facade.createNewUser(s, textField1.getText(), String.valueOf(passwordField1.getPassword()))){
                JOptionPane.showMessageDialog(frame,"Success!");
            }
            else{
                JOptionPane.showMessageDialog(frame,"Failure, try again!");
            }
            textField1.setText("");
            passwordField1.setText("");
        });
        panel.setVisible(true);
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
        JButton offer = new JButton("Offer");
        offer.setBounds(10, 10, 70, 30);

        JButton view = new JButton("View");
        view.setBounds(100, 10, 70, 30);

        view.addActionListener(e -> {
            String result="";
            for(int i=0;i<checkBox.length;i++) {
                if (checkBox[i].isSelected()) {
                    String s = facade.theProductList[i].getType()+":"+facade.theProductList[i].getName();
                    result += s+"\n"+facade.viewTrading(s)+"\n";
                }
            }
            JOptionPane f = new JOptionPane();
            if(result.isEmpty()){
                JOptionPane.showMessageDialog(f, "Select products to view trading");
            }
            else{
                JOptionPane.showMessageDialog(f, result);
                JOptionPane.showMessageDialog(f, "Count of Expired Products in the Entire File: "+facade.remind());
            }
        });

        offer.addActionListener(e -> {
            for(int i=0;i<checkBox.length;i++){
                if(checkBox[i].isSelected()) {
                    facade.theSelectedProduct = new Product();
                    facade.theSelectedProduct.setName(facade.theProductList[i].getName());
                    facade.theSelectedProduct.setType(facade.theProductList[i].getType());
                    JOptionPane f = new JOptionPane();
                    String s = JOptionPane.showInputDialog(f,"Enter bidding price :"+facade.theSelectedProduct.getName());
                    if(s==null){
                        break;
                    }
                    //System.out.println(offerInfo);
                    facade.theSelectedProduct.setOffering("Buyer - "+facade.user.getUserName()+": Price - "+s);
                    facade.AttachProductToUser();
                    facade.addTrading();
                }

            }
            //JOptionPane jp = new JOptionPane();
        });

        buyerPanel.add(offer);
        buyerPanel.add(view);
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

        JPanel sellerPanel = new JPanel();
        sellerPanel.setBounds(10, 250,200,100);

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


        JLabel timerLabel = new JLabel("Set the expiration time");
        timerLabel.setBounds(10,40,150,20);
        JTextField timer = new JTextField();
        timer.setBounds(10,10,100,20);
        timerLabel.setLabelFor(timer);
        //sellerPanel.add(timer);

        JTextPane time = new JTextPane();
        time.setBounds(10, 150,200,100);
        time.add(timerLabel);
        time.add(timer);

        JButton save = new JButton("Save");
        save.setBounds(15, 50, 70, 30);

        save.addActionListener(e -> {
            int i;
            for(i=0;i<checkBox.length;i++){
                if(checkBox[i].isSelected()) {
                    System.out.println(checkBox[i].getName());
                    facade.theSelectedProduct = new Product();
                    facade.theSelectedProduct.setName(facade.theProductList[i].getName());
                    facade.theSelectedProduct.setType(facade.theProductList[i].getType());
                    JOptionPane f = new JOptionPane();
                    String s = JOptionPane.showInputDialog(f,"Enter offering price :"+facade.theSelectedProduct.getName());
                    if(s==null){
                        break;
                    }
                    //System.out.println(offerInfo);
                    String t = timer.getText();
                    if(t == null){
                        t = "20";
                    }
                    String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new java.util.Date());
                    facade.theSelectedProduct.setOffering("Seller - "+facade.user.getUserName()+": Price - "+s+": "+timeStamp+": Expiry(minutes) - "+t);
                    facade.AttachProductToUser();
                    facade.addTrading();
                }
            }
            JOptionPane f = new JOptionPane();
            if(i>=checkBox.length) {
                JOptionPane.showMessageDialog(f, "Operation Successful. Please Login again!");
                System.exit(0);
            }
            else{
                JOptionPane.showMessageDialog(f, "Operation Unsuccessful. Please try again!");
            }

        });

        sellerPanel.add(save);
        frame.add(time);
        frame.add(sellerPanel);
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

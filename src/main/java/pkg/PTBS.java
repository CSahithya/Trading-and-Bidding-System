package pkg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PTBS {
    private JLabel Username;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel Password;
    private JButton Login;


    private void createUIComponents() {
        // TODO: place custom component creation code here
        Username = new JLabel("Username");
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        Password = new JLabel("Password");
        Login = new JButton("Login");
        Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkLogin();
            }
        });
    }
    public static void checkLogin(){

    }
}

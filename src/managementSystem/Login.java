package managementSystem;

import javax.swing.*;                                       //Java Extended Package
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,signUp;
    JTextField accountText;
    JPasswordField passwordText;
    Login() {                                               //initiate the frame in the constructor so it opens window panel when a Login object is instantiated
        setTitle("TuneTrades");
        setLayout(null);                                    //want to use custom layout not border, thus set to null
        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icons/trade-1.png"));     //get an icon from icons package
        Image myImage = logo.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon properImage = new ImageIcon(myImage);
        JLabel myLabel = new JLabel(properImage);
        myLabel.setBounds(70,10,100,100);
        add(myLabel);

        //Now add text infront of the image

        JLabel myText = new JLabel("TuneTrades, start your journey now!");
        myText.setForeground(Color.ORANGE);
        myText.setFont(new Font("Times New Roman",Font.BOLD,38));
        myText.setBounds(190,30,650,40);
        add(myText);

        //New label for login details

        JLabel accountNumber = new JLabel("Username: ");
        accountNumber.setForeground(Color.ORANGE);
        accountNumber.setFont(new Font("Raleway",Font.BOLD,26));
        accountNumber.setBounds(150,140,240,40);
        add(accountNumber);

        accountText = new JTextField();
        accountText.setBounds(420, 150,250,40);
        add(accountText);

        JLabel password = new JLabel("Password: ");
        password.setForeground(Color.ORANGE);
        password.setFont(new Font("Raleway",Font.BOLD,26));
        password.setBounds(150,215,210,40);
        add(password);

        passwordText = new JPasswordField();
        passwordText.setBounds(420, 225,250,40);
        add(passwordText);

        login = new JButton("SIGN IN");
        login.setBounds(420,300, 100,30 );
        login.addActionListener(this);
        add(login);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(570,300,100,30);
        signUp.addActionListener(this);
        add(signUp);

        getContentPane().setBackground(Color.black);
        setSize(850,500);                      //define the dimensions of the frame
        setVisible(true);                                  //make the frame visible
        setLocation(250,125);


    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            dbCon conn = new dbCon();
            String username = accountText.getText();
            String password = passwordText.getText();
            String query = "select * from signuptwo where username = '"+username+"' and password = '"+password+"'";
            try {
               ResultSet rs =  conn.s.executeQuery(query);
               if (rs.next()) {
                   setVisible(false);
               }
               else {
                   JOptionPane.showMessageDialog(null, "Entered Information is Incorrect");
               }
            }
            catch (Exception exception){
                System.out.println(exception);
            }

        }
        else if (e.getSource() == signUp){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
}

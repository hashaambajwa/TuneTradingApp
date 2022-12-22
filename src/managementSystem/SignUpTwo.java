package managementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpTwo extends JFrame implements ActionListener {
    JTextField usernameTextField, passwordTextField;
    JComboBox account;
    String formno;
    JButton next;
    public SignUpTwo(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("Account Information");
        getContentPane().setBackground(Color.black);
        setVisible(true);

        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icons/trade-1.png"));     //get an icon from icons package
        Image myImage = logo.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon properImage = new ImageIcon(myImage);
        JLabel myLabel = new JLabel(properImage);
        myLabel.setBounds(250,400,100,100);
        add(myLabel);

        ImageIcon logo1 = new ImageIcon(ClassLoader.getSystemResource("icons/International_Business_Illustration-01.jpg"));     //get an icon from icons package
        Image myImage1 = logo1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon properImage1 = new ImageIcon(myImage1);
        JLabel myLabel1 = new JLabel(properImage1);
        myLabel1.setBounds(450,400,100,100);
        add(myLabel1);


        JLabel username = new JLabel("Set Username:");
        username.setFont(new Font("Raleway", Font.BOLD,16));
        username.setForeground(Color.orange);
        username.setBounds(100,150,120,30);
        add(username);

        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        usernameTextField.setBounds(230,150,400,30);
        add(usernameTextField);

        JLabel password = new JLabel("Set Password");
        password.setFont(new Font("Raleway", Font.BOLD,16));
        password.setForeground(Color.orange);
        password.setBounds(100,190,120,30);
        add(password);

        passwordTextField = new JTextField();
        passwordTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        passwordTextField.setBounds(230,190,400,30);
        add(passwordTextField);

        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raleway", Font.BOLD,16));
        accountType.setForeground(Color.orange);
        accountType.setBounds(100,230,120,30);
        add(accountType);

        String accountTypes[] = {"TFSA","RRSP","RESP","RRIF"};
        account = new JComboBox(accountTypes);
        account.setBounds(230,230,400,30);
        add(account);

        JLabel title = new JLabel("Login Information");
        title.setForeground(Color.orange);
        title.setFont(new Font("Arial",Font.BOLD,36));
        title.setBounds(250,40,600,40);
        add(title);

        setSize(850,800);
        setLocation(300,10);
        setVisible(true);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD, 14));
        next.setBounds(680,600,80,30);
        next.addActionListener(this);
        add(next);

    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String accountType = (String) account.getSelectedItem();

        try {
            dbCon con = new dbCon();
            String query = "insert into signuptwo values('"+formno+"', '"+username+"', '"+password+"', '"+accountType+"')";
            con.s.executeUpdate(query);
            setVisible(false);
            new Login();

        }
        catch (Exception exception){
            System.out.println(exception);
        }
    }
}

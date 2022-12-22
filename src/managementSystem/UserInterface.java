package managementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame implements ActionListener {
    JButton purchase, sell, deposit, withdraw;
    public UserInterface(){

        setTitle("HomePage");
        setLayout(null);
        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icons/business-candle-stick-graph-chart-of-stock-market-investment-trading-free-vector.jpg"));     //get an icon from icons package
        Image myImage = logo.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon properImage = new ImageIcon(myImage);
        JLabel myLabel = new JLabel(properImage);
        myLabel.setBounds(350,200,100,100);
        add(myLabel);



        JLabel title = new JLabel("Portfolio Manager");
        title.setForeground(Color.orange);
        title.setFont(new Font("Arial",Font.BOLD,36));
        title.setBounds(250,40,600,40);
        add(title);

        JButton purchase = new JButton("Purchase");
        purchase.setFont(new Font("Raleway",Font.BOLD, 14));
        purchase.setBounds(106,150,200,30);
        purchase.addActionListener(this);
        add(purchase);

        JButton sell = new JButton("Sell");
        sell.setFont(new Font("Raleway",Font.BOLD, 14));
        sell.setBounds(531,150,200,30);
        sell.addActionListener(this);
        add(sell);

        JButton deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway",Font.BOLD, 14));
        deposit.setBounds(106,350,200,30);
        deposit.addActionListener(this);
        add(deposit);

        JButton withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("Raleway",Font.BOLD, 14));
        withdraw.setBounds(531,350,200,30);
        withdraw.addActionListener(this);
        add(withdraw);

        getContentPane().setBackground(Color.black);
        setSize(850,500);                      //define the dimensions of the frame
        setVisible(true);                                  //make the frame visible
        setLocation(250,125);





    }

    public static void main(String[] args) {
        new UserInterface();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == purchase ){

        }
        else if (e.getSource() == sell){

        }
        else if (e.getSource() == withdraw){

        }
        else if (e.getSource() == deposit){

        }
    }
}

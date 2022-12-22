package managementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField, emailTextField, cardTextField, pinTextField;
    JButton next;
    JRadioButton visa,masterCard,americanX;
    JDateChooser dateChooser;
    public SignUpOne(){
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%900L)+1000L);
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setForeground(Color.ORANGE);
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel pageDesc = new JLabel("User Information");
        pageDesc.setFont(new Font("Raleway", Font.BOLD,26));
        pageDesc.setForeground(Color.ORANGE);
        pageDesc.setBounds(300,80,240,40);
        add(pageDesc);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD,26));
        name.setForeground(Color.ORANGE);
        name.setBounds(140,130,240,40);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(360,130,400,40);
        add(nameTextField);

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD,26));
        dob.setForeground(Color.ORANGE);
        dob.setBounds(140,190,240,40);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(360,190,300,40);
        add(dateChooser);

        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Raleway", Font.BOLD,26));
        email.setForeground(Color.ORANGE);
        email.setBounds(140,250,240,40);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(360,250,400,40);
        add(emailTextField);

        JLabel bankingDetails = new JLabel("Banking Details");
        bankingDetails.setFont(new Font("Raleway", Font.BOLD,26));
        bankingDetails.setForeground(Color.ORANGE);
        bankingDetails.setBounds(300,320,240,40);
        add(bankingDetails);

        JLabel cardType = new JLabel("CardType: ");
        cardType.setFont(new Font("Raleway", Font.BOLD,26));
        cardType.setForeground(Color.ORANGE);
        cardType.setBounds(140,400,240,40);
        add(cardType);

        visa = new JRadioButton("Visa");
        visa.setBounds(360, 400, 70, 30);
        add(visa);
        masterCard = new JRadioButton("MasterCard");
        masterCard.setBounds(480,400,100,30);
        add(masterCard);
        americanX = new JRadioButton("American Express");
        americanX.setBounds(600,400,150,30);
        add(americanX);

        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(visa);
        typeGroup.add(masterCard);
        typeGroup.add(americanX);

        JLabel cardNumber = new JLabel("CardNumber: ");
        cardNumber.setFont(new Font("Raleway", Font.BOLD,26));
        cardNumber.setForeground(Color.ORANGE);
        cardNumber.setBounds(140,460,240,40);
        add(cardNumber);

        cardTextField = new JTextField();
        cardTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cardTextField.setBounds(360,460,400,40);
        add(cardTextField);

        JLabel pin = new JLabel("Pin: ");
        pin.setFont(new Font("Raleway", Font.BOLD,26));
        pin.setForeground(Color.ORANGE);
        pin.setBounds(140,520,240,40);
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(360,520,400,40);
        add(pinTextField);

        getContentPane().setBackground(Color.BLACK);
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
        new SignUpOne();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = Long.toString(random);
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String card = cardTextField.getText();
        String pin = pinTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String cardType = null;
        if (visa.isSelected()){
            cardType = "Visa";
        }
        else if (masterCard.isSelected()){
            cardType = "MasterCard";
        }
        else if (americanX.isSelected()){
            cardType = "American Express";
        }

        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter an Name");
            }
            else {
                dbCon con = new dbCon();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+email+"', '"+card+"', '"+pin+"', '"+dob+"', '"+cardType+"')";
                con.s.executeUpdate(query);

                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        }
        catch (Exception exception){
            System.out.println(exception);
        }

    }
}

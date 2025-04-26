import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signUp,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
        setTitle("Automated Teller Machine");

        setLayout(null);

        // Load the image icon
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);

        // Add image to JLabel
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, i3.getIconWidth(), i3.getIconHeight()); // Set position & size
        add(label);

        JLabel text= new JLabel("Welcome to ATM");
        text.setFont(new Font("osward", Font.BOLD,38));
        text.setBounds(200, 40, 400, 40 );
        add(text);

        JLabel cardno= new JLabel("Card No. ");
        cardno.setFont(new Font("raleway", Font.BOLD,20));
        cardno.setBounds(100, 100, 150, 40 );
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,110,250,30);
        cardTextField.setFont(new Font("Ariel",Font.BOLD, 14));
        add(cardTextField);

        JLabel pin= new JLabel("PIN:");
        pin.setFont(new Font("raleway", Font.BOLD,20));
        pin.setBounds(100, 150, 400, 40 );
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,155,250,30);
        pinTextField.setFont(new Font("Ariel",Font.BOLD, 14));
        add(pinTextField);

        login= new JButton("SIGN IN");
        login.setBounds(300,200,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear= new JButton("CLEAR");
        clear.setBounds(450,200,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signUp= new JButton("SIGNUP");
        signUp.setBounds(370,250,100,30);
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);

        // Frame settings
        getContentPane().setBackground(Color.white);
        setSize(800, 400);
        setLocation(350, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource()==login){
             Conn conn=new Conn();
             String cardnumber=cardTextField.getText();
             String pinnumber=pinTextField.getText();
             String query="select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"' ";

             try{
                 ResultSet rs=conn.s.executeQuery(query);
                 if(rs.next()){
                     setVisible(false);
                     new Transaction(pinnumber).setVisible(true);
                 }else{
                     JOptionPane.showMessageDialog(null,"Incorrect Card or Pin");
                 }
             }catch(Exception e){
                 System.out.println(e);
             }
        } else if (ae.getSource()==signUp){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

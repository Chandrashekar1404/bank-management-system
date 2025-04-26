import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signupthree extends JFrame implements ActionListener {

    JRadioButton sa,ca,ra,fa;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    public Signupthree(String formno){

        this.formno=formno;

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1=new JLabel("page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type=new JLabel("Account type:");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(150,120,400,30);
        add(type);

        sa =new JRadioButton("Saving Acount");
        sa.setFont(new Font("Ralway",Font.BOLD,16));
        sa.setBackground(Color.WHITE);
        sa.setBounds(300,125,150,20);
        add(sa);

        ca =new JRadioButton("Current Account");
        ca.setFont(new Font("Ralway",Font.BOLD,16));
        ca.setBackground(Color.WHITE);
        ca.setBounds(450,125,150,20);
        add(ca);

        ra =new JRadioButton("Recurring Account");
        ra.setFont(new Font("Ralway",Font.BOLD,16));
        ra.setBackground(Color.WHITE);
        ra.setBounds(300,185,200,20);
        add(ra);

        fa =new JRadioButton("Fixed Deposit Account");
        fa.setFont(new Font("Ralway",Font.BOLD,16));
        fa.setBackground(Color.WHITE);
        fa.setBounds(500,185,300,20);
        add(fa);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(sa);
        groupaccount.add(ca);
        groupaccount.add(ra);
        groupaccount.add(fa);

        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(150,240,400,30);
        add(card);

        JLabel Cnumber=new JLabel("xxxx-xxxx-xxxx-7414");
        Cnumber.setFont(new Font("Raleway",Font.BOLD,16));
        Cnumber.setBounds(300,240,400,30);
        add(Cnumber);

        JLabel PN=new JLabel("PIN:");
        PN.setFont(new Font("Raleway",Font.BOLD,16));
        PN.setBounds(150,300,400,30);
        add(PN);

        JLabel Pnumber=new JLabel("xxxx");
        Pnumber.setFont(new Font("Raleway",Font.BOLD,16));
        Pnumber.setBounds(300,300,400,30);
        add(Pnumber);

        JLabel servicesRequired=new JLabel("Services Required:");
        servicesRequired.setFont(new Font("Raleway",Font.BOLD,16));
        servicesRequired.setBounds(150,360,400,30);
        add(servicesRequired);

        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("raleway", Font.BOLD,16));
        c1.setBounds(150,400,200,30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("raleway", Font.BOLD,16));
        c2.setBounds(350,400,200,30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("raleway", Font.BOLD,16));
        c3.setBounds(600,400,200,30);
        add(c3);

        c4=new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("raleway", Font.BOLD,16));
        c4.setBounds(150,450,200,30);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("raleway", Font.BOLD,16));
        c5.setBounds(350,450,200,30);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("raleway", Font.BOLD,16));
        c6.setBounds(600,450,200,30);
        add(c6);

        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("raleway", Font.BOLD,12));
        c7.setBounds(150,530,600,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBounds(250,600,150,30);
        submit.setFont(new Font("Ralway", Font.BOLD,14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,600,150,30);
        cancel.setFont(new Font("Ralway", Font.BOLD,14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);




//        JTextField cardnotextField = new JTextField();
//        cardnotextField.setBounds(300,245,400,30);
//        cardnotextField.setFont(new Font("Ariel",Font.BOLD, 14));
//        add(cardnotextField);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType=null;
            if(sa.isSelected()){
                accountType="Savings Account";
            } else if (ca.isSelected()) {
                accountType="Current Account";
            } else if (ra.isSelected()) {
                accountType="Recurring Account";
            } else if (fa.isSelected()) {
                accountType="Fixed Deposit Account";
            }

            Random random= new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000) + 5040936000000000L);

            String pinnumber="" + Math.abs((random.nextLong()%9000L)+1000L);

            String facility="";
            if(c1.isSelected()){
                facility = facility + "ATM CARD";
            } else if (c2.isSelected()) {
                facility=facility + "Internet Banking";
            } else if (c3.isSelected()) {
                facility=facility + "Mobile Banking";
            } else if (c4.isSelected()) {
                facility=facility + "Email & SMS Alert";
            } else if (c5.isSelected()) {
                facility=facility + "Cheque Book";
            } else if (c6.isSelected()) {
                facility=facility+ "E-Statement";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is required");
                }else{
                    Conn conn=new Conn();
                    String query1 = "insert into signupthree values ('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values ('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number " + cardnumber + "\n Pin: " + pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
            }catch (Exception e){
                System.out.println(e);
            }


        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main (String [] args){
        new Signupthree("");
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

    JButton deposit,withdraw,fastcash,pinchange,ministatement,exit,checkbalance;
    String pinnumber;
    Fastcash(String pinnumber){

        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text= new JLabel("Select withdrawl amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        deposit= new JButton("Rs 100");
        deposit.setBounds(170,400,120,30);
        deposit.setFont(new Font("System", Font.BOLD,12));
        deposit.setBackground(Color.WHITE);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw= new JButton("Rs 500");
        withdraw.setBounds(380,400,120,30);
        withdraw.setFont(new Font("System", Font.BOLD,12));
        withdraw.setBackground(Color.WHITE);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash= new JButton("Rs 1000");
        fastcash.setBounds(170,440,120,30);
        fastcash.setFont(new Font("System", Font.BOLD,12));
        fastcash.setBackground(Color.WHITE);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement= new JButton("Rs 2000");
        ministatement.setBounds(380,440,120,30);
        ministatement.setFont(new Font("System", Font.BOLD,12));
        ministatement.setBackground(Color.WHITE);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange= new JButton("Rs 5000");
        pinchange.setBounds(170,480,120,30);
        pinchange.setFont(new Font("System", Font.BOLD,12));
        pinchange.setBackground(Color.WHITE);
        pinchange.addActionListener(this);
        image.add(pinchange);

        checkbalance= new JButton("Rs 10000");
        checkbalance.setBounds(380,480,120,30);
        checkbalance.setFont(new Font("System", Font.BOLD,12));
        checkbalance.setBackground(Color.WHITE);
        checkbalance.addActionListener(this);
        image.add(checkbalance);

        exit= new JButton("Back");
        exit.setBounds(380,520,120,30);
        exit.setFont(new Font("System", Font.BOLD,12));
        exit.setBackground(Color.WHITE);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
           String amount = ((JButton)ae.getSource()).getText().substring(3);

           Conn c =new Conn();

           try{
               ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
               int balance = 0;

               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));
                   }else{
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
               }

               if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }

               Date date = new Date();
               String query="insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+amount+"')";
                c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs "+amount+ " Debited Successfully");

               setVisible(false);
               new Transaction(pinnumber).setVisible(true);

           }catch(Exception e){
               System.out.println(e);
           }

        }
    }

    public static void main(String [] args){

        new Fastcash("");
    }
}

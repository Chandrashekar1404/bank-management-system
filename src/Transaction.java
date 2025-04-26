import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit,withdraw,fastcash,pinchange,ministatement,exit,checkbalance;
    String pinnumber;
    Transaction(String pinnumber){

        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text= new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        deposit= new JButton("Deposit");
        deposit.setBounds(170,400,120,30);
        deposit.setFont(new Font("System", Font.BOLD,12));
        deposit.setBackground(Color.WHITE);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw= new JButton("Withdraw");
        withdraw.setBounds(380,400,120,30);
        withdraw.setFont(new Font("System", Font.BOLD,12));
        withdraw.setBackground(Color.WHITE);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash= new JButton("Fast cash");
        fastcash.setBounds(170,440,120,30);
        fastcash.setFont(new Font("System", Font.BOLD,12));
        fastcash.setBackground(Color.WHITE);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement= new JButton("Mini-Statement");
        ministatement.setBounds(380,440,120,30);
        ministatement.setFont(new Font("System", Font.BOLD,12));
        ministatement.setBackground(Color.WHITE);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange= new JButton("Pin Change");
        pinchange.setBounds(170,480,120,30);
        pinchange.setFont(new Font("System", Font.BOLD,12));
        pinchange.setBackground(Color.WHITE);
        pinchange.addActionListener(this);
        image.add(pinchange);

        checkbalance= new JButton("Check balance");
        checkbalance.setBounds(380,480,120,30);
        checkbalance.setFont(new Font("System", Font.BOLD,12));
        checkbalance.setBackground(Color.WHITE);
        checkbalance.addActionListener(this);
        image.add(checkbalance);

        exit= new JButton("Exit");
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
            System.exit(0);
        } else if (ae.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource()==withdraw) {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        } else if (ae.getSource()==fastcash) {
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }else if(ae.getSource()==checkbalance){
            setVisible(false);
            new BalanceEnquery(pinnumber).setVisible(true);
        } else if (ae.getSource()==ministatement) {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }

    public static void main(String [] args){

        new Transaction("");
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener {

    JButton change, back;
    JPasswordField pintextfield, repintextfield;
    String pinnumber;

    Pinchange(String pinchange) {

        this.pinnumber=pinchange;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(165, 320, 180, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);

        pintextfield = new JPasswordField();
        pintextfield.setBounds(320, 320, 150, 30);
        pintextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(pintextfield);

        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setBounds(165, 360, 180, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(repintext);

        repintextfield = new JPasswordField();
        repintextfield.setBounds(320, 360, 150, 30);
        repintextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(repintextfield);

        change = new JButton("Change");
        change.setBounds(380, 480, 120, 30);
        change.setFont(new Font("System", Font.BOLD, 12));
        change.setBackground(Color.WHITE);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(380, 520, 120, 30);
        back.setFont(new Font("System", Font.BOLD, 12));
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);


        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pintextfield.getText();
                String rpin = repintextfield.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin doesn't match");
                    return;
                }

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new pin");
                    return;
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter pin");
                    return;
                }

                Conn conn= new Conn();
                String query1 = "update bank set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
                String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
                String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";


                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);


            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }

    }
    public static void main (String [] args){
        new Pinchange("").setVisible(true);
    }
}

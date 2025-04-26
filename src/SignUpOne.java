import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{

    long random;
    JTextField NameTextField,FatherNameTextField,EmailTextField,AddressTextField,CityTextField,StateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,married,Notmarried;
    JDateChooser dateChooser;

    SignUpOne(){
        setLayout(null);

        Random ran =new Random();
        random= Math.abs((ran.nextLong() % 9000l) + 1000l);

        JLabel formno=new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD, 38 ));
        formno.setBounds(140, 20, 600,40);
        add(formno);

        JLabel personalDetails=new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD, 22 ));
        personalDetails.setBounds(290, 80, 400,30);
        add(personalDetails);

        JLabel Name=new JLabel("Name:");
        Name.setFont(new Font("Raleway",Font.BOLD, 20 ));
        Name.setBounds(150, 120, 400,30);
        add(Name);

        NameTextField = new JTextField();
        NameTextField.setBounds(350,125,400,30);
        NameTextField.setFont(new Font("Ariel",Font.BOLD, 14));
        add(NameTextField);

        JLabel FatherName =new JLabel("Father's Name:");
        FatherName.setFont(new Font("Raleway",Font.BOLD, 20 ));
        FatherName.setBounds(150, 170, 400,30);
        add(FatherName);

        FatherNameTextField = new JTextField();
        FatherNameTextField.setBounds(350,175,400,30);
        FatherNameTextField.setFont(new Font("Ariel",Font.BOLD, 14));
        add(FatherNameTextField);

        JLabel DOB =new JLabel("Date of Birth:");
        DOB.setFont(new Font("Raleway",Font.BOLD, 20 ));
        DOB.setBounds(150, 220, 400,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(350, 225, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel gender =new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD, 20 ));
        gender.setBounds(150, 270, 400,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(350, 270, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);


        female = new JRadioButton("Female");
        female.setBounds(450, 270, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);


        JLabel Email =new JLabel("Email:");
        Email.setFont(new Font("Raleway",Font.BOLD, 20 ));
        Email.setBounds(150, 320, 400,30);
        add(Email);

        EmailTextField = new JTextField();
        EmailTextField.setBounds(350,325,400,30);
        EmailTextField.setFont(new Font("Ariel",Font.BOLD, 14));
        add(EmailTextField);

        JLabel MS =new JLabel("Marital Status:");
        MS.setFont(new Font("Raleway",Font.BOLD, 20 ));
        MS.setBounds(150, 370, 400,30);
        add(MS);

        married = new JRadioButton("Yes");
        married.setBounds(350, 370, 60, 30);
        married.setBackground(Color.WHITE);
        add(married);

        Notmarried = new JRadioButton("No");
        Notmarried.setBounds(450, 370, 60, 30);
        Notmarried.setBackground(Color.WHITE);
        add(Notmarried);

        ButtonGroup maritalStatus=new ButtonGroup();
        maritalStatus.add(married);
        maritalStatus.add(Notmarried);

        JLabel AD =new JLabel("Address:");
        AD.setFont(new Font("Raleway",Font.BOLD, 20 ));
        AD.setBounds(150, 420, 400,30);
        add(AD);

        AddressTextField = new JTextField();
        AddressTextField.setBounds(350,425,400,30);
        AddressTextField.setFont(new Font("Ariel",Font.BOLD, 14));
        add(AddressTextField);

        JLabel city =new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD, 20 ));
        city.setBounds(150, 470, 400,30);
        add(city);

        CityTextField = new JTextField();
        CityTextField.setBounds(350,475,400,30);
        CityTextField.setFont(new Font("Ariel",Font.BOLD, 14));
        add(CityTextField);

        JLabel state =new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD, 20 ));
        state.setBounds(150, 520, 400,30);
        add(state);

        StateTextField = new JTextField();
        StateTextField.setBounds(350,525,400,30);
        StateTextField.setFont(new Font("Ariel",Font.BOLD, 14));
        add(StateTextField);

        JLabel pincode =new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD, 20 ));
        pincode.setBounds(150, 570, 400,30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setBounds(350,575,400,30);
        pinTextField.setFont(new Font("Ariel",Font.BOLD, 14));
        add(pinTextField);

        next= new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(700,650,80,30);
        next.addActionListener(this);
        add(next);



        setSize(850,800);
        setLocation(350, 10);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        String formno="",random;
        String name=NameTextField.getText();
        String fname=FatherNameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender= null;
        if(male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender="Female";
        }

        String email= EmailTextField.getText();

        String marital=null;
        if(married.isSelected()){
            marital="married";
        } else if (Notmarried.isSelected()) {
            marital="unmarried";
        }

        String address=AddressTextField.getText();
        String state=StateTextField.getText();
        String city=CityTextField.getText();
        String pin=pinTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signuptwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }


    public static void main(String[]args){
        new SignUpOne();
    }
}

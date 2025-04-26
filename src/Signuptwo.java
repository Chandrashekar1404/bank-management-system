import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import jdk.jfr.Category;

import java.awt.event.*;

public class Signuptwo extends JFrame implements ActionListener {
        JTextField ReligionTextField,CategoryTextField,IncomeTextField,QualificationTextField,OccupationTextField,PanTextField,AadharTextField,SeniorTextField,ExistingTextField;
        JButton next;
        JRadioButton Literal,NotLiteral;
        String formno;


        Signuptwo(String formno){

            this.formno=formno;

            setLayout(null);

            setTitle("page 2");


            JLabel additionalDetails=new JLabel("Page 2: Additional Details");
            additionalDetails.setFont(new Font("Raleway",Font.BOLD, 22 ));
            additionalDetails.setBounds(290, 80, 400,30);
            add(additionalDetails);

            JLabel religion=new JLabel("Religion:");
            religion.setFont(new Font("Raleway",Font.BOLD, 20 ));
            religion.setBounds(150, 120, 400,30);
            add(religion);

            ReligionTextField = new JTextField();
            ReligionTextField.setBounds(350,125,400,30);
            ReligionTextField.setFont(new Font("Ariel",Font.BOLD, 14));
            add(ReligionTextField);

            JLabel category =new JLabel("Category:");
            category.setFont(new Font("Raleway",Font.BOLD, 20 ));
            category.setBounds(150, 170, 400,30);
            add(category);

            CategoryTextField = new JTextField();
            CategoryTextField.setBounds(350,175,400,30);
            CategoryTextField.setFont(new Font("Ariel",Font.BOLD, 14));
            add(CategoryTextField);

            JLabel income =new JLabel("Income:");
            income.setFont(new Font("Raleway",Font.BOLD, 20 ));
            income.setBounds(150, 220, 400,30);
            add(income);

            IncomeTextField = new JTextField();
            IncomeTextField.setBounds(350,225,400,30);
            IncomeTextField.setFont(new Font("Ariel",Font.BOLD, 14));
            add(IncomeTextField);

            JLabel literal =new JLabel("Literal:");
            literal.setFont(new Font("Raleway",Font.BOLD, 20 ));
            literal.setBounds(150, 270, 400,30);
            add(literal);

            Literal = new JRadioButton("Yes");
            Literal.setBounds(350, 270, 60, 30);
            Literal.setBackground(Color.WHITE);
            add(Literal);


            NotLiteral = new JRadioButton("No");
            NotLiteral.setBounds(450, 270, 120, 30);
            NotLiteral.setBackground(Color.WHITE);
            add(NotLiteral);

            ButtonGroup educational=new ButtonGroup();
            educational.add(Literal);
            educational.add(NotLiteral);


            JLabel qualification =new JLabel("Qualification:");
            qualification.setFont(new Font("Raleway",Font.BOLD, 20 ));
            qualification.setBounds(150, 320, 400,30);
            add(qualification);

            QualificationTextField = new JTextField();
            QualificationTextField.setBounds(350,325,400,30);
            QualificationTextField.setFont(new Font("Ariel",Font.BOLD, 14));
            add(QualificationTextField);

            JLabel occupation =new JLabel("Occupation:");
            occupation.setFont(new Font("Raleway",Font.BOLD, 20 ));
            occupation.setBounds(150, 370, 400,30);
            add(occupation);

            OccupationTextField = new JTextField();
            OccupationTextField.setBounds(350,375,400,30);
            OccupationTextField.setFont(new Font("Ariel",Font.BOLD, 14));
            add(OccupationTextField);


            JLabel pan =new JLabel("PAN number:");
            pan.setFont(new Font("Raleway",Font.BOLD, 20 ));
            pan.setBounds(150, 420, 400,30);
            add(pan);

            PanTextField = new JTextField();
            PanTextField.setBounds(350,425,400,30);
            PanTextField.setFont(new Font("Ariel",Font.BOLD, 14));
            add(PanTextField);

            JLabel aadhar =new JLabel("Aadhaar number:");
            aadhar.setFont(new Font("Raleway",Font.BOLD, 20 ));
            aadhar.setBounds(150, 470, 400,30);
            add(aadhar);

            AadharTextField = new JTextField();
            AadharTextField.setBounds(350,475,400,30);
            AadharTextField.setFont(new Font("Ariel",Font.BOLD, 14));
            add(AadharTextField);

            JLabel senior =new JLabel("Senior citizen:");
            senior.setFont(new Font("Raleway",Font.BOLD, 20 ));
            senior.setBounds(150, 520, 400,30);
            add(senior);

            SeniorTextField = new JTextField();
            SeniorTextField.setBounds(350,525,400,30);
            SeniorTextField.setFont(new Font("Ariel",Font.BOLD, 14));
            add(SeniorTextField);

            JLabel existing =new JLabel("Existing Account:");
            existing.setFont(new Font("Raleway",Font.BOLD, 20 ));
            existing.setBounds(150, 570, 400,30);
            add(existing);

            ExistingTextField = new JTextField();
            ExistingTextField.setBounds(350,575,400,30);
            ExistingTextField.setFont(new Font("Ariel",Font.BOLD, 14));
            add(ExistingTextField);

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
            String Religion=ReligionTextField.getText();
            String category=CategoryTextField.getText();
            String income=IncomeTextField.getText();
            String literal= null;
            if(Literal.isSelected()){
                literal = "Yes";
            }else if (NotLiteral.isSelected()){
                literal="No";
            }

            String qualification= QualificationTextField.getText();

            String occupation=OccupationTextField.getText();
            String pan=PanTextField.getText();
            String aadhar=AadharTextField.getText();
            String senior=SeniorTextField.getText();
            String existing=ExistingTextField.getText();

            try{
                    Conn c = new Conn();
                    String query = "insert into signuptwo values ('"+formno+"','"+Religion+"','"+category+"','"+income+"','"+literal+"','"+qualification+"','"+occupation+"','"+pan+"','"+aadhar+"','"+senior+"','"+existing+"')";
                    c.s.executeUpdate(query);

//                    signupthree object
                setVisible(false);
                new Signupthree(formno).setVisible(true);

            }catch(Exception e){
                System.out.println(e);
            }

        }


        public static void main(String[]args){
            new Signuptwo("");
        }
    }


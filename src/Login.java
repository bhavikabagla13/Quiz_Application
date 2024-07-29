
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{
    
    JButton rules,back;
    JTextField tfname;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image =new JLabel(i1);
        image.setBounds(0, 0,600, 500);
        add(image);
        
        JLabel heading=new JLabel("Smart  Mind");
        heading.setBounds(750,60,300,45);
        heading.setFont(new Font ("Viner Hand ITC",Font.BOLD,42));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel name=new JLabel("Enter your name ");
        name.setBounds(810,155,300,20);
        name.setFont(new Font ("Mongolian Baiti",Font.BOLD,22));
        name.setForeground(Color.MAGENTA);
        add(name);
        
        tfname=new JTextField ();
        tfname.setBounds(735,200,300,25);
        tfname.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(tfname);
        
        rules=new JButton(" Start Quiz ");
        rules.setBounds(735,270,120,25);
        rules.setBackground(Color.GREEN);
        rules.addActionListener(this);
        add(rules);
        
        back=new JButton(" Back ");
        back.setBounds(917,270,120,25);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        setLayout(null);
        
        setSize(1200,500);
        setLocation(100,150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==rules)
        {
            String name=tfname.getText();
            setVisible(false);
            new Rules(name);
        }
        else if(ae.getSource()==back){
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new Login();                                              //anonymous object  without store in variable
    }
}

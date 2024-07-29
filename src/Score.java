import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Score extends JFrame implements ActionListener{
    
    JButton playagain;
    
    Score(String name,int score){
        getContentPane().setBackground(Color.WHITE);                                  //frame
        setSize(900,550);
        setLocation(250,120);
        setLayout(null);
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));    //set image
       Image i2=i1.getImage().getScaledInstance(320,270,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
         JLabel image =new JLabel(i3);
        image.setBounds(40, 150,300, 250);
        add(image);
        
        JLabel heading=new JLabel("Thankyou  "+ name+ "  for  playing  Smart  Minds ");
        heading.setBounds(50,25,700,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        add(heading);
        
        JLabel lblscore=new JLabel("Your Score is "+ score);
        lblscore.setBounds(450,190,300,30);
        lblscore.setForeground(Color.MAGENTA);
        lblscore.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
        add(lblscore);
        
        playagain=new JButton(" Play Again ");
        playagain.setBounds(480,270,150,35);
        playagain.setBackground(Color.BLACK);
        playagain.setForeground(Color.WHITE);
        playagain.setFont(new Font("Tahoma",Font.PLAIN,18));
        playagain.addActionListener(this);
        add(playagain);
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==playagain){
           setVisible(false);
           new Login();
       }
    }
    
    
    public static void main(String args[]){
        new Score("User",0);
    }
    
}
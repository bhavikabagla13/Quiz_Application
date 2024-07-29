import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;

public class Quiz extends JFrame implements ActionListener {
    
String questions[][] =new String[10][5];
String answers[][]=new String[10][1];
String useranswers[][]=new String[10][1];
JLabel qno,question;
JButton next,submit,lifeline;
JRadioButton opt1,opt2,opt3,opt4;
ButtonGroup groupoption;
public static int timer=15;
public static int ans_given=0;
public static int count=0;
public static int score=0;

String name;
    Quiz(String name){
        this.name=name;
         getContentPane().setBackground(Color.WHITE);                                  //frame
        setSize(1250,740);
        setLocation(50,0);
        setVisible(true);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));    //set image
        JLabel image =new JLabel(i1);
        image.setBounds(0, 0,1250, 300);
        add(image);
        
        qno=new JLabel();
        qno.setBounds(50,400,50,30);
        qno.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(qno);
        
        question=new JLabel();
        question.setBounds(100,400,850,30);
        question.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(question);
        
         setLayout(null);
        
        
        questions[0][0] = "Which is used to find and fix bugs in the Java programs?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored,when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][0] = "JDB";
        answers[1][0] = "int";
        answers[2][0] = "java.util package";
        answers[3][0] = "Marker Interface";
        answers[4][0] = "Heap memory";
        answers[5][0] = "Remote interface";
        answers[6][0] = "import";
        answers[7][0] = "Java Archive";
        answers[8][0] = "java.lang.StringBuilder";
        answers[9][0] = "Bytecode is executed by JVM";
        
        
        opt1=new JRadioButton();
        opt1.setBounds(120,460,700,30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt1);
        
        opt2=new JRadioButton();
        opt2.setBounds(120,500,700,30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt2);
        
        opt3=new JRadioButton();
        opt3.setBounds(120,540,700,30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt3);
        
        opt4=new JRadioButton();
        opt4.setBounds(120,580,700,30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt4);
    
        groupoption=new ButtonGroup();             //use to select only one option
        groupoption.add(opt1);
        groupoption.add(opt2);
        groupoption.add(opt3);
        groupoption.add(opt4);
         
        next=new JButton(" Next ");
        next.setBounds(970,470,200,40);
        next.setBackground(Color.DARK_GRAY);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Tahoma",Font.PLAIN,18));
        next.addActionListener(this);
        add(next);
         
        lifeline=new JButton(" 50-50 Lifeline ");
        lifeline.setBounds(970,530,200,40);
        lifeline.setBackground(Color.DARK_GRAY);
        lifeline.setForeground(Color.WHITE);
        lifeline.setFont(new Font("Tahoma",Font.PLAIN,18));
        lifeline.addActionListener(this);
        add(lifeline);   
                 
        submit=new JButton(" Submit ");
        submit.setBounds(970,590,200,40);
        submit.setBackground(Color.DARK_GRAY);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma",Font.PLAIN,18));
        submit.addActionListener(this);
        submit.setEnabled(false);                                     //disable till last question
        add(submit);
        
        start(count);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            repaint();                                             //time again start from 15
            
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
          
            
            
            ans_given=1;       
            if(groupoption.getSelection()==null){
                useranswers[count][0]="";                        // agar koi answer select nhi kiya h to
            }
            else{
                useranswers[count][0]=groupoption.getSelection().getActionCommand();         // to retrieve user answer and store in variable
            }
            
            if(count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        }
        else if(ae.getSource()==lifeline){
            if(count==2 || count ==4 || count ==6|| count ==8|| count ==9){
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }
            else{
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            
            lifeline.setEnabled(false);
                
        }
        
        else if(ae.getSource()==submit){
            ans_given=1;
            
             if(groupoption.getSelection()==null){
                useranswers[count][0]="";                        // agar koi answer select nhi kiya h to
             }
            else{
                useranswers[count][0]=groupoption.getSelection().getActionCommand();         // to retrieve user answer and store in variable
             }
                 
            for(int i=0;i<useranswers.length;i++){
                if(useranswers[i][0].equals(answers[i][0])){
                    score+=10;
                }
            } 
            setVisible(false);
            new Score(name,score);
        }
    }
    
    public void start(int count){                                                     //start method call automatically
        qno.setText(""+(count +1)+ ".");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);                                        // to display options
        opt1.setActionCommand(questions[count][1]);               //to perfom action and retreive user answer
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
    
        groupoption.clearSelection();                                           //clear selction for next question
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        String time ="Time left - "+ timer + " seconds";        // initially 15 value hogi
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,20));
        
        if(timer> 0){
            g.drawString(time,980,450);
        }
        else{
            g.drawString("Times Up!!" ,980,450);
    }
        
        timer--;
        
        try{
            Thread.sleep(1000);            //1000miliseconds means 1 sec
            repaint();
            
        }
        catch(Exception e){
        }
        
        if(ans_given==1){
            ans_given=0;
            timer=15;
            
        }
        else if(timer<0){
            timer=15;
            
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
             if(count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
             
             if(count==9){                           //time up hogya aur submit ni kiya to auto submit hoga
                 if(groupoption.getSelection()==null){
                useranswers[count][0]="";                        // agar koi answer select nhi kiya h to
             }
            else{
                useranswers[count][0]=groupoption.getSelection().getActionCommand();         // to retrieve user answer and store in variable
             }
                 
            for(int i=0;i<useranswers.length;i++){
                if(useranswers[i][0].equals(answers[i][0])){
                    score+=10;
                }
            } 
            setVisible(false);
            new Score(name,score);
                 
          }
             else{                                                //next button click kiya h to
            
            if(groupoption.getSelection()==null){
                useranswers[count][0]="";                        // agar koi answer select nhi kiya h to
            }
            else{
                useranswers[count][0]=groupoption.getSelection().getActionCommand();         // to retrieve user answer and store in variable
            }
            count++;
            start(count);
        }
        
        }  
        
    }
    
public static void main(String args[]){
    new Quiz("User");
}    
}
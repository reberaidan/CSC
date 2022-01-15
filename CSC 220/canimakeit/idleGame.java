package canimakeit;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class idleGame implements ActionListener{
    
    JFrame frame;
    JTextField textfield;
    JButton[] switches = new JButton[5];
    JPanel panel;
    Font myFont = new Font("Ink Free",Font.BOLD,30);
    int inputNumbers = 0;

    float score = 0;

    int upgrade1 = 0;
    double upgrade1mult = 1;

    int upgrade2 = 0;
    double upgrade2mult = 1;

    int upgrade3 = 0;
    double upgrade3mult = 1;
    double cost3 = 1+ 3*upgrade3+ 0.33*upgrade3;

    int upgrade4 = 0;
    double upgrade4mult = 1;


    
    public static void main(String[] args) throws InterruptedException{
        idleGame win = new idleGame();
    }

    idleGame() throws InterruptedException{
        frame = new JFrame("Protogame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550,550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        
        switches[0] = new JButton("Click Me"); 
        switches[0].addActionListener(this); 
        switches[0].setFont(myFont);
        switches[0].setFocusable(false);

        switches[1] = new JButton("CLicker 1 | Cost: "+ cost(100, upgrade1)); 
        switches[1].addActionListener(this); 
        switches[1].setFont(myFont);
        switches[1].setFocusable(false);

        switches[2] = new JButton("Autoclick: Lvl 2"); 
        switches[2].addActionListener(this); 
        switches[2].setFont(myFont);
        switches[2].setFocusable(false);

        switches[3] = new JButton("Autoclick: Lvl 3"); 
        switches[3].addActionListener(this); 
        switches[3].setFont(myFont);
        switches[3].setFocusable(false);

        switches[4] = new JButton("Autoclick: Lvl 4"); 
        switches[4].addActionListener(this); 
        switches[4].setFont(myFont);
        switches[4].setFocusable(false);
        

        panel = new JPanel();
        panel.setBounds(50,100,400,400);
        panel.setLayout(new GridLayout(5,1,10,10));
        panel.setBackground(Color.white);

        for(int i=0;i<5;i++){
            panel.add(switches[i]);
        }

        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);

        while(true){
            textfield.setText(String.valueOf(score));
            Thread.sleep(1000);
            score+= upgrade1*upgrade1mult;
            score+= 2*upgrade2*upgrade2mult;
            score+= 3*upgrade3*upgrade3mult;
            score+= 4*upgrade4*upgrade4mult;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e){

    
        if(e.getSource() == switches[0]){
            score += 1;
            textfield.setText(String.valueOf(score));

        }
        if(e.getSource()== switches[1]){
            if(score >= cost(100,upgrade1)){
                
                score -= cost(100,upgrade1);
                upgrade1++;
                textfield.setText(String.valueOf(score));
                switches[1].setText("Upgrade 1 | Cost: "+ cost(100,upgrade1));
            }  
        }
        if(e.getSource()== switches[2]){
            if(score >= 200){
                upgrade2++;
                score -= 200;
                textfield.setText(String.valueOf(score));
            }  
        }
        if(e.getSource()== switches[3]){
            if(score >= 300){
                upgrade3++;
                score -= cost3;
                textfield.setText(String.valueOf(score));
            }  
        }
        if(e.getSource()== switches[4]){
            if(score >= 400){
                upgrade4++;
                score -= 400;
                textfield.setText(String.valueOf(score));
            }  
        }
        
            
        
        
    }
    int cost(int basecost, int upgrades){
        Double cost = 100*(Math.pow(1.15,upgrades));
        return cost.intValue();
    }
}

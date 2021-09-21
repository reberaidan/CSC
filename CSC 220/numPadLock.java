import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class numPadLock implements ActionListener{
    
    JFrame frame;
    JTextField textfield;
    JButton[] switches = new JButton[10];
    int inputs[] = {0,0,0,0,0};
    int password[] = {1,2,3,4,5};
    int currentNumber = 0;
    JPanel panel;
    Font myFont = new Font("Ink Free",Font.BOLD,30);
    public static void main(String[] args){
        numPadLock code = new numPadLock();
    }
    numPadLock(){
        frame = new JFrame("Only Odd Inputs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550,550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setText("Locked");

        for(int i=0;i<10; i++){
            switches[i] = new JButton(String.valueOf(i)); 
            switches[i].addActionListener(this); 
            switches[i].setFont(myFont);
            switches[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(50,100,400,400);
        panel.setLayout(new GridLayout(3,3,10,10));
        panel.setBackground(Color.white);

        for(int i=1;i<4;i++){
            panel.add(switches[i]);
        }
        for(int i=4;i<7;i++){
            panel.add(switches[i]);
        }

        for(int i=7;i<10;i++){
            panel.add(switches[i]);
        }
        
        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        for(int i=0;i<9;i++){
            if(e.getSource() == switches[i]){
                inputs[currentNumber] = i;
                currentNumber++;
                System.out.println(i);
            }
        }
        if(currentNumber == 5){
            int check = 0;
            for(int i=0; i<5; i++){
                if(inputs[i] == password[i]){
                    check++;
                }
            }
            System.out.println(check);
            if(check==5){
                textfield.setText("Unlocked");
                panel.setBackground(Color.green);

            }
            else{
                panel.setBackground(Color.red);
                
            }
            currentNumber = 0;
        }
        else{
            textfield.setText("Locked");
            panel.setBackground(Color.white);
        }
        
    }
}

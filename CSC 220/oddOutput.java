import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class oddOutput implements ActionListener{
    
    JFrame frame;
    JTextField textfield;
    JButton[] switches = new JButton[5];
    int inputs[] = {0,0,0,0,0};
    JPanel panel;
    Font myFont = new Font("Ink Free",Font.BOLD,30);
    int inputNumbers = 0;

    
    public static void main(String[] args){
        oddOutput win = new oddOutput();
        
    }

    oddOutput(){
        frame = new JFrame("Only Odd Inputs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550,550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        for(int i=0;i<5; i++){
            switches[i] = new JButton(String.valueOf(i)); 
            switches[i].addActionListener(this); 
            switches[i].setFont(myFont);
            switches[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(50,100,400,400);
        panel.setLayout(new GridLayout(1,5,10,10));
        panel.setBackground(Color.white);

        for(int i=0;i<5;i++){
            panel.add(switches[i]);
        }

        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e){

        for(int i=0;i<5;i++){
            if(e.getSource() == switches[i]){
                if(inputs[i]==0){
                    inputNumbers++;
                    inputs[i] = 1;
                    System.out.println(inputNumbers);

                }
                else{
                    inputNumbers--;
                    inputs[i] = 0;
                    System.out.println(inputNumbers);
                }
            }
        }
        if(inputNumbers%2==0.0){
            textfield.setText("off");
        }
        else{
            textfield.setText("on");
        }
        
    }
}

package com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math.*;

public class NamarRep extends JFrame implements ActionListener {

    private JFrame frame;
    private JMenuBar menubar;
    private JMenu menu;
    private JMenu menu1;
    private JLabel message = new JLabel("Enter Decimal Number:");
    private JTextField numVal = new JTextField(20);
    private JButton clearButton = new JButton("Clear");
    public String[] NUM = { // 1D Array of Menu Choices
        "Hex", "Binary", "Octal"
    };

    public String[] NUM1 = { // 1D Array of Menu Choices
        "Sine", "Cosine", "Tangent"
    };
    
    public NamarRep(String title) {

        
        //System.setProperty("java.awt.headless", "false");

	    // Initializing Key Objects
        frame = new JFrame(title);
	    menubar = new JMenuBar(); 
	    menu = new JMenu("Number Representations");
        menu1 = new JMenu("Trigonometric Functions");
        
        //Initializing Menu objects and adding actions
        for (String mx : NUM) {
            JMenuItem m = new JMenuItem(mx);
            m.addActionListener(this);
            menu.add(m); 
        }

        //Initializing Menu objects and adding actions
        for (String mx : NUM1) {
            JMenuItem m = new JMenuItem(mx);
            m.addActionListener(this);
            menu1.add(m); 
        }
        
        clearButton.addActionListener(this);

        menubar.add(menu);
        menubar.add(menu1);
        frame.setJMenuBar(menubar);
        frame.setLayout(new FlowLayout());
        //frame.setLayout(50,30);
        frame.add(message);
        frame.add(numVal);
        frame.add(clearButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

         frame.setSize(500,200);

        frame.setVisible(true);

}

public void actionPerformed(ActionEvent e)    
{
    String s = e.getActionCommand(); 
    double value=0; //declaring double to hold values with decimals
    String out="";  

    if(s.equals(NUM1[0])) {
        value = Math.sin(Math.toRadians(Double.parseDouble(numVal.getText())));  //Changes input to radians in order to use sin function and return the value as a double 
        numVal.setText(String.valueOf(value)); //gets value inputted in text box
    }
    else if (s.equals(NUM1[1])) {
        value = Math.cos(Math.toRadians(Double.parseDouble(numVal.getText()))); //Same operation as sin but with cos function
        numVal.setText(String.valueOf(value));
    }
    else if(s.equals(NUM1[2])) {
        value = Math.tan(Math.toRadians(Double.parseDouble(numVal.getText()))); //tangent operaton
        numVal.setText(String.valueOf(value));
    }
    else if(s.equals(NUM[0])) {
        int x = Integer.parseInt(numVal.getText()); 

        out="";
        int a;
        for(;x>=1; x=x/16) {
            a = x % 16;
            if(a>9) {
                if(a==10) { 
                    out+= 'A';
                }
                else if(a == 11) {
                	out+= 'B';
                }
                else if(a == 12) {
                	out+= 'C';
                }
                else if(a == 13) {
                	out+= 'D';
                }
                else if(a == 14) {
                	out+= 'E';
                }
                else if(a == 15) {
                	out+= 'F';
                }
            }
            else
            	out+=String.valueOf(a);
            
        }
        numVal.setText("0x"+reverseString(out));
        
    }
    else if(s.equals(NUM[1])) {
        int x = Integer.parseInt(numVal.getText());
        int a;
        out="";
        for(; x>=1; x=x/2) {
            a = x % 2;
            out+=String.valueOf(a);
        }
        numVal.setText(reverseString(out));
    }
    else if(s.equals(NUM[2])) {
        int x = Integer.parseInt(numVal.getText());
        int a;
        out = "";
        for(;x>=1;x=x/8) {
        	a = x % 8;
        	out+=String.valueOf(a);
        }
        numVal.setText(reverseString(out));
    }
    else if(s.equals("Clear"))
    {
    	numVal.setText("");
    }

}

    private String reverseString(String out)
    {
    	char[] ch = out.toCharArray();
    	int x = out.length()-1;
    	String s="";
    	for(;x>=0;x--) {
    		s+=ch[x];
    	}
    	return s;
    }

    public static void main(String[] args) {
        
        NamarRep np= new NamarRep("My Menu");
    }
}


NamarRep.main(null)
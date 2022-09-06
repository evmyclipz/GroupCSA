package com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math.*;

public class NamarRep extends JFrame implements ActionListener {

    private JFrame frame;
    private JMenuBar menubar;
    private JMenu menu;
    private JMenu menu1;//New menu
    private JLabel message = new JLabel("Enter Decimal Number:");
    private JTextField numVal = new JTextField(20);
    private JButton clearButton = new JButton("Clear");
    public String[] NUM = { // 1D Array of Menu Choices
        "Hex", "Binary", "Octal"
    };

    public String[] NUM1 = { // 1D Array of Menu #1 Choices
        "Sine", "Cosine", "Tangent"
    };
    
    public NamarRep(String title) {

        
        //System.setProperty("java.awt.headless", "false");

	    // Initializing Key Objects
        frame = new JFrame(title);
	    menubar = new JMenuBar(); 
	    menu = new JMenu("Number Representations");
        menu1 = new JMenu("Trigonometric Functions");
        
        //Initializing number converstions Menu objects
        for (String mx : NUM) {
            JMenuItem m = new JMenuItem(mx);
            m.addActionListener(this);
            menu.add(m); 
        }

        //Initializing trigonometry Menu objects
        for (String mx : NUM1) {
            JMenuItem m = new JMenuItem(mx);
            m.addActionListener(this);
            menu1.add(m); 
        }
        
        clearButton.addActionListener(this);//to reset the text 

        menubar.add(menu);//add the new menu to the menubar
        menubar.add(menu1);//add the new menu to the menubar
        frame.setJMenuBar(menubar);
        
        //New layout with 
        frame.setLayout(new FlowLayout());
        //frame.setLayout(50,30);
        frame.add(message);
        frame.add(numVal);
        frame.add(clearButton);//adds clear button

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

         frame.setSize(500,200); //inreasing the window size

        frame.setVisible(true);//to be visible

}

public void actionPerformed(ActionEvent e) 
{
    String s = e.getActionCommand();
    double value=0;
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
        int a; //
        for(;x>=1; x=x/16) { //decimal to hexadecimal
            a = x % 16;
            if(a>9) {
                if(a==10) { 
                    out+= 'A';//appends to string
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
            	out+=String.valueOf(a);//appends to string
            
        }
        //most important line of code, hardest to use
        numVal.setText("0x"+reverseString(out));//use of method which reverses the string because if you go through normal division, the remainder are not in correct order of a hex structure.
        
    }
    else if(s.equals(NUM[1])) { //use of if and else to provide direction of action
        int x = Integer.parseInt(numVal.getText());
        int a; //always decleared to avoid mixing with other values
        out=""; //always decleared to avoid mixing with other values
        for(; x>=1; x=x/2) { //decimal to binary
            a = x % 2;
            out+=String.valueOf(a);
        }
        numVal.setText(reverseString(out)); //again use of 
    }
    else if(s.equals(NUM[2])) { 
        int x = Integer.parseInt(numVal.getText());
        int a;
        out = "";
        for(;x>=1;x=x/8) { //decimal to octal
        	a = x % 8;
        	out+=String.valueOf(a);
        }
        numVal.setText(reverseString(out));
    }
    else if(s.equals("Clear")) //to clear input 
    {
    	numVal.setText("");
    }

}
    // reverses th input string
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

    public static void main(String[] args) { //main programm which starts the GUI programm.....Very Proud of myself
        
        NamarRep np= new NamarRep("My Menu"); //gives control to NamarRep
    }
}


NamarRep.main(null)
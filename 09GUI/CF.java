import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CF extends JFrame implements ActionListener{
    private Container pane;
    private JCheckBox c;
    private JTextField t;
    private JButton b;

    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	System.out.println(s);
	if(s.equals("do")){
	    if(c.isSelected()){
		t.setText("" + FtoC(Double.parseDouble(t.getText())) );
	    }
	    else{
		t.setText("" + CtoF(Double.parseDouble(t.getText())) );
	    }
	}
    }

    public static double FtoC(double f){
	return (f-32)*5/9;
    }

    public static double CtoF(double c){
	return c*1.8+32;
    }
    
    public CF(){
	this.setTitle("Celcius to Farenheight");
	this.setSize(1920,1080);
	this.setLocation(0,0);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	
	c = new JCheckBox("revers?");
	t = new JTextField(24);
	b = new JButton("do");

	c.addActionListener(this);
	t.addActionListener(this);
	b.addActionListener(this);
	
	pane.add(c);
	pane.add(t);
	pane.add(b);
    }

    public static void main(String[]args){
	CF g = new CF();
	g.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.events.*;

public class CF extends JFrame implements ActionListener{
    private Container pane;
    private JCheckBox c;
    private JTtextField t;
    
    public CF(){
	this.setTitle("Farenheight to Celcius");
	this.setSize(700,700);
	this.setLocation(30,50);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();

	c = new JCheckBox("revers?");
	t = new JTextField(234789);

	pane.add(c);
	pane.add(t);
    }

    public static void main(String[]args){
	CF g = new CF();
	g.setVisible(true);
    }
}


/*
	Program to Calc. (a^2 - b^2), using awt graphics & ActionListener( Swing )

*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class B extends JFrame implements ActionListener{

	JTextField tf1, tf2, tf3;
	B(){

		setLayout( new FlowLayout() );
		
		JLabel l1 = new JLabel( "Enter a:" );
		tf1 = new JTextField( 20 );

		JLabel l2 = new JLabel( "Enter b:" );
		tf2 = new JTextField( 20 );

		JLabel l3 = new JLabel( "Result:" );
		tf3 = new JTextField( 20 );		

		JButton b1 = new JButton( "=" );

		add( l1 );
		add( l2 );
		add( l3 );
		add( tf1 );
		add( tf2 );
		add( tf3 );
		add( b1 );

		b1.addActionListener( this );
	}

	public void actionPerformed( ActionEvent e ){
		int ans = 0;

		ans = Integer.parseInt( tf1.getText() ) * Integer.parseInt( tf1.getText() );
		ans -= Integer.parseInt( tf2.getText() ) * Integer.parseInt( tf2.getText() );

		tf3.setText( Integer.toString( ans ) );
	}
}

class prac1{

	public static void main(String[] args) {
		B b = new B();
		b.setSize( 300, 400 );
		b.setVisible( true );
	}
}

















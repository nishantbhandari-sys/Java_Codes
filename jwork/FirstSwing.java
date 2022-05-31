//	JFrame can also be inherited & used 

import javax.swing.*;

class FirstSwing{

	public static void main( String[] args ){
		
		JFrame f = new JFrame();
		JButton b = new JButton( "click me!!" );
		
		b.setBounds( 130, 100, 100, 40 );	//	x-axis, y-axis, width, height
		f.add( b );
		f.setSize( 400, 500 );	//	Width & HEight
		f.setLayout( null );	//	Using no layout managers
		f.setVisible( true );	//	making the frame visible
	}
}

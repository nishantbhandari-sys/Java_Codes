package p2;

import p1.*;

class cls2 {

	public static void main( String[] args ){

		cls1 obj = new cls1( );
		obj.show();

		System.out.println ( "sum: " + obj.sum( 5, 4 ) );
		System.out.println ( "multi: " + obj.multi( 5, 4 ) );
		System.out.println ( "div: " + obj.div( 4, 2 ) );
		
		

	}
//	public int multi( int x, int y )
//	{	return x * y; 	}
}

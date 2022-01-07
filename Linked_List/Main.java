
public class Main{
	public static void main(String[] args) {

		LL list = new LL() ;

		list.insert_Beg( 40 ) ;
		list.insert_Beg( 30 ) ;
		list.insert_Beg( 10 ) ;

		list.insert_End( 50 ) ;
		list.display() ;
		
		list.insert_Rec( 20, 0 );
		list.insert_Rec( 60, 5 );

        
		list.display() ;

		// System.out.println( "MAin" );
	}

}












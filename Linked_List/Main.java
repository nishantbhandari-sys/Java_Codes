
public class Main{
	public static void main(String[] args) {

		LL list = new LL() ;

		list.insert_Beg( 10 ) ;
		list.insert_Beg( 30 ) ;
		list.insert_Beg( 70 ) ;

		list.insert_End( 50 ) ;
// 		list.display() ;
		
		list.insert_Rec( 20, 0 );
		list.insert_Rec( 60, 5 );
        
        
        LL lst2 = new LL();
        lst2.insert_End( 5 );
        lst2.insert_End( 4 );
        lst2.insert_End( 3 );
        list.insert_End( 2 );
        
        System.out.print( "Ques: " );
		list.display();

        list.bubbleSort();
        
        System.out.print( "Ans: " );
        list.display();

		// System.out.println( "MAin" );
	}

}











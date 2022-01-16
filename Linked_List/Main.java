
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
        lst2.insert_End( 1 );
        lst2.insert_End( 2 );
        lst2.insert_End( 3 );
        lst2.insert_End( 4 );
        lst2.insert_End( 5 );
        
//         System.out.print( "Ques: " );
		lst2.display();

//         list.bubbleSort();
        
//         System.out.print( "Ans: " );

//         lst2.revBween();

	boolean ans = lst2.issPalindrome();
        System.out.println( ans );
		
        lst2.display();

		// System.out.println( "MAin" );
	}

}











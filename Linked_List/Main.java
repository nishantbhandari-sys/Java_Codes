
public class Main{
	public static void main(String[] args) {

		LL list = new LL() ;

		list.insert_Beg( 1 ) ;
		list.insert_Beg( 3 ) ;
		list.insert_Beg( 7 ) ;

		list.insert_End( 5 ) ;
// 		list.display() ;
		
		list.insert_Rec( 2, 0 );
		list.insert_Rec( 6, 5 );
        
        
        LL lst2 = new LL();
        lst2.insert_End( 1 );
        lst2.insert_End( 2 );
        lst2.insert_End( 3 );
        lst2.insert_End( 4 );
        lst2.insert_End( 5 );
        // lst2.insert_End( 6 );
        
//         System.out.print( "Ques: " );

// 		list.display();

//         list.bubbleSort();
        
//         System.out.print( "Ans: " );

        // boolean ans = lst2.issPalindrome();
        // System.out.println( ans );

        // lst2.reorder();
        // lst2.rotateRight( 8 );

        // lst2.removekthEnd( 5 );
        // lst2.swapkNodes( 2 );

        // lst2.display();

        LL l1 = new LL();
        LL l2 = new LL();
        
        l1.insert_End( 9 );
        l1.insert_End( 9 );
        l1.insert_End( 9 );
        
        l2.insert_End( 9 );
        l2.insert_End( 9 );
        
        LL sum = new LL();
        sum.atn( l1, l2 );
        sum.display();
        
		// System.out.println( "MAin" );
	}

}










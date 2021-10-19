public class rev_digits_recursion
{
	public static void main(String[] args) {
		System.out.println( f( 4530 ) );
	}
  
	public static int f( int n ){
    
	    return hlp( n, (int) Math.log10( n ) +1 ) ;
	}
	
	public static int hlp( int n, int d ){
    
	    if( n%10 == n ){
	        return n ;
	    }
	    return (n%10 * (int) Math.pow( 10, d -1)) + hlp( n/10, d -1 ) ;
	}
	
}

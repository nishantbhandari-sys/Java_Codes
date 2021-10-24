import java.util.Arrays ;
public class Main
{
	public static void main(String[] args) {
	    int arr[] = new int[] { 4, 3, 2, 1, 9, 5} ;
	   // int arr[] = new int[] { 4, 3, 2, 1 } ;
	    
	    selr( arr, arr.length -1, 0, 0 ) ;
		System.out.println( Arrays.toString( arr ) ) ;
	}
	
	public static void selr( int[] arr, int n, int i, int mxi ){
	    
	    if( n == 0 ) {
	        return ;
	    }
	    
	    if( i <= n ){
	        
	        if( arr[ i ] > arr[ mxi ] ){
	            selr( arr, n, i +1, i ) ;
	        }
	        else
	            selr( arr, n, i +1, mxi ) ;
	    }
	    else{
	        swap( arr, n , mxi ) ;
	        selr( arr, n -1, 0, 0 ) ;
	    }
	}

	public static void swap( int[] arr, int i, int j ){
	    int t = arr[ i ] ;
	    arr[ i ] = arr[ j ] ;
	    arr[ j ] = t ;
	}
	
	public static void bubble( int[] arr, int r, int c ){
	    
	    if( r == 0 )
	        return ;
	        
	    if( c < r ){
	        
    	     if( arr[ c ] > arr[c +1] ) {
    	        //  Swap
    	        int t = arr[ c ] ;
    	        arr[ c ] = arr[ c +1] ;
    	        arr[ c +1] = t ;
    	        
    	     }
    	   bubble( arr, r, c +1 ) ;
	    } else{
	        
	        bubble( arr, r -1, 0 ) ;
	    }
	}	
}

public class Main
{
	public static void main(String[] args) {
	    int[] arr = new int[] { 8, 7, 6, 1 ,2 ,3 ,4 } ;
	    
		System.out.println( rsa( arr, 0, arr.length -1, 5 ) );
	}
	
	public static int rsa( int[] arr, int s, int e, int key ){
	    
	    if( s > e )
	        return -1 ;
	    int mid = s + (e - s)/ 2 ;
	    
	    if( arr[ mid ] == key )
	        return mid ;
	    
	    if( arr[ s ] <= arr[ mid ] ){   //  array is sorted
	        if( key >= arr[ s ] && key <= arr[ mid ] ){
	            return rsa( arr, s, mid -1, key ) ;
	        }
	        else{
	            return rsa( arr, mid +1, e, key ) ;
	        }
	    }
	    
	    else if( key >= arr[ mid ] && key <= arr[ e ] )
	        return rsa( arr, mid +1, e, key ) ;
	        
	    return rsa( arr, s, mid -1, key ) ;
	}
}

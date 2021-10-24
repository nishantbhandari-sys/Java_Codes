  //  Complexity  =>  O( n ) 

import java.util.Arrays ;
public class Main
{
	public static void main(String[] args) {
	    int arr[][] = { 
	        
	        { 1,  2,   3,  4 },
	        { 5,  6,   7,  8 },
	        { 9,  10, 11, 12 },
	        { 13, 14, 15, 16 },
	        
	    } ;

		System.out.println( Arrays.toString( search( arr, 14 ) ) );
	}
	
	public static int[] search(int[][] mat, int key ){
	    
	    int r = 0 ;
	    int c = mat[0].length -1 ;
	    
	    while( r < mat.length && c >= 0 ){
	        
	        if( mat[ r ] [ c ] == key )
	            return new int[] { r, c } ;
	            
	        if( mat[ r ][ c ] > key )
	            c-- ;
	        else
	            r++ ;
	    }
	    return new int[] { -1, -1 } ;
	}
	
}

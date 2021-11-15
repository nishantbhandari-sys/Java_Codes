import java.util.* ;
public class Main{
	public static void main(String[] args) {
	    int[] arr = { 1, 2, 3 } ;
	    
	    List<List<Integer>> ans = subSequence( arr ) ;
	    
	    for( List<Integer> i : ans ){
	        System.out.println( i );
	    }
	}
	
	public static List<List<Integer>> subSequence( int[] arr ){
	    List<List<Integer>> outer = new ArrayList<>() ;
	    outer.add( new ArrayList<>() ) ;
	    
	    for( int num: arr ){
	        int n = outer.size() ;
	        for( int i = 0; i < n; i++ ){
	            
	            //  creating a new list containing previous elements
	            List<Integer> in = new ArrayList<>( outer.get( i ) ) ;
	            
	            in.add( num ) ;     //  adds num in all elements of list
	            outer.add( in ) ;   //  add the new list with previous list
	        }
	       // for( List<Integer> i : ans ){
	       //     System.out.println( i );
	       // }
	       // System.out.println( n ) ;
	    }
	    return outer ;
	}
}

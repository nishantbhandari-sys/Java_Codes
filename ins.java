import java.util.Scanner;

/*
	n -> size of array
	worst case comparisons = (n -1) * (n -2) /2;
	best case comparisons = n -1

*/

public class ins{

	public static void main( String[] args ){
		Scanner sc = new Scanner( System.in );
		
		int n = sc.nextInt();
		int[] arr = new int[ n ];
	
		for( int i = 0; i < n; i++ )		arr[ i ]= sc.nextInt();
		
		//	Insertion
		itr( arr, n );
		
		//	Recursive
		//	rec2( arr, n -1 );
		
		for( int i : arr )			System.out.print( i + " " );
	}
	
	public static void rec2( int[] arr, int en ){
		
		if( en == 0 )		return;
		
		rec2( arr, en -1);	//	Find the sorted array for en -1 elements
	
		int ele = arr[ en ];
		int j = en -1;
		
		while( j >= 0 && arr[ j ] > ele ){
			
			arr[ j +1] = arr[ j ];
			j--;
		}
		
		arr[ j +1] = ele;
	}
	
	
	
	public static void rec( int[] arr, int st, int en ){
		
		if( en -st == 0 )		return;
		
		rec( arr, st +1, en );
	
		int ele = arr[ st ];
		int i = st +1;
		while( i <= en && arr[ i ] < ele ){
			
			arr[ i -1] = arr[ i ];
			i++;
		}
		
		arr[ i -1] = ele;
	}
	
	public static void itr( int[] arr, int n ){
	
		int write = 0;
		int comp = 0;
	
		for( int i = 1; i < n; i++ ){
			
			int ele = arr[ i ];
			int j = i -1;
			
			while( j >= 0 && arr[ j ] > ele ){
				arr[ j +1 ] = arr[ j ];
				j--;
				
				write++;
				comp++;
			}
		
			arr[ j +1 ] = ele;
		}
	
		System.out.println( "write ops: " + write + "\ncomp: " + comp );
	}
}










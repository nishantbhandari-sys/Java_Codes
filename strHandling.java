//	String Handling

public class strHandling {
	
    public static void main(String args[]) {
	    System.out.println();
		
		String str = new String( "Your Name" );
		
		System.out.println( "String: " + str );
		
		System.out.println( "CharAt: " + str.charAt( 1 ) );
		
		System.out.println( "Substring: " + str.substring( 0, 4 ) );
		
		System.out.println( "Concatenate: " + str.concat( " nishant" ) );
		
		System.out.println( "To Upper: " + str.toUpperCase() );
		
		System.out.println( "To Lower: " + str.toLowerCase() );
		
		System.out.println( "Trim: " +    "   white  spaces   ".trim( ) );
		
		System.out.println( "\nStringBuffer\n" );
		
		StringBuffer s2 = new StringBuffer( "No name" );
		
		System.out.println( "Substring: " + s2.substring( 0, 4 ) );
		
		System.out.println( "size: " + s2.length() );
		
		System.out.println( "Append: " + s2.append( " appended" ) );
		
		System.out.println();
    }
}

//	Constructor Chaining

public class cc {
	
    public static void main(String args[]) {
	    
		temp obj = new temp( 5, 6, 7 );
		obj.display();
    }
}

class temp{
	int v1, v2, v3;
	
	temp( int var ){
//		this( 1, 2, 3 );
		
		v1 = var;
		System.out.println( "In 3rd Const." );
	}
	
	temp( int v1, int v2 ){
		this( v1 );
		
		this.v2 = v2;
		System.out.println( "In 2nd Const." );
	}
	
	temp( int v1, int v2, int v3 ){
		this( v1, v2 );
		
		this.v3 = v3;
		System.out.println( "In 1st Const." );
	}
	
	void display(){
		System.out.println( "\nv1: " + v1 + " v2: " + v2 + " v3: " + v3 );
	}
}
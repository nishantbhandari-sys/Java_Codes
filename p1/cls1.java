package p1;

public interface I1{
	public int multi( int x, int y );
}

public class cls1 implements I1{

	 public void show( ){
		System.out.println( "In show function" );
	}

	public int sum( int x, int y ){
		return x + y;
	}
	public float div( float x, float y ){
		return x / y;
	}

	public int multi( int x, int y )
	{	return x * y; 	}

}

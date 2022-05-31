
class testRun extends Thread{

	public void run(){
		
		for( int i = 1; i < 5; i++ ){
			
			try{
				Thread.sleep( 500 );
			}
			catch( InterruptedException e ){
				System.out.println( e );
			}
			
			System.out.println( i );
		}
	
	}

	public static void main( String[] args ){
	
		testRun t1 = new testRun( );
		testRun t2 = new testRun( );
		t1.start();	
		t2.start();	
	}
}

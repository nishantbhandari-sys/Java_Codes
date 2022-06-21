
class thr2 implements Runnable{

	public void run(){
		System.out.println( "thread is running2" );
	}

	public static void main( String[] args ){
	
		thr2 m1 = new thr2();
		Thread t1 = new Thread( m1 );
		t1.start();	
	}
}

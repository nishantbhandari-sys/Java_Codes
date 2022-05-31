/*

	TWo ways to create thread:
		-- by extending Thread class
		-- by implementing Runnable interface

*/

class thr1 extends Thread{

	public void run(){
		System.out.println( "thread is running" );
	}

	public static void main( String[] args ){
	
		thr1 t1 = new thr1();
		t1.start();	
	}
}

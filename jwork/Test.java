
class A implements Runnable {

	public void run(){
		
		for( int i = 1; i < 5; i++ ){
			
			System.out.println( "Thread A " + i );
		}
		System.out.println( "Exiting A" );
	}
}

class B implements Runnable {

	public void run(){
		
		for( int i = 1; i < 5; i++ ){
			
			System.out.println( "Thread B " + i );
		}
		System.out.println( "Exiting B" );
	}
}

class C implements Runnable {

	public void run(){
		
		for( int i = 1; i < 5; i++ ){
			
			System.out.println( "Thread C " + i );
		}
		System.out.println( "Exiting C" );
	}
}


class Test{
	public static void main( String[] args ){
	
		A obj1 = new A();
		B obj2 = new B();
		C obj3 = new C();
	
		Thread t1 = new Thread( obj1 );
		Thread t2 = new Thread( obj2 );
		Thread t3 = new Thread( obj3 );
	
		t1.start();
		try{
			t1.join();	//	Without join random Threads will get executed
		}
		catch( Exception e ){
			System.out.println( e );
		}
	
		t2.start();	
		t3.start();
	}
}








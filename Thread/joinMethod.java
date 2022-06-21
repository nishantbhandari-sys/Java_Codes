/*
When the join() method is invoked, the current thread stops its execution and go into the wait state.
The current thread remains in the wait state until 
the thread on which the join() method is invoked/ called is dead or it wait for the specified time frame
*/

class newThread implements Runnable{
    String name;
    Thread t;
    
    newThread( String name ){
        this.name = name;
        t = new Thread( this, name );
        t.start();
    }
    
    public void run(){
        try{
            for( int i = 5; i > 0; i-- ){
                System.out.println( name + " " + i );
                t.sleep( 500 );
            }
        }
        catch( Exception e ){
            System.out.println( e );
        }
        
        System.out.println( "Exiting Thread " + name );
    }
}

public class Main{
    
	public static void main(String[] args) {
	    newThread t1 = new newThread( "one" );
	    
 		try{
            t1.t.join();
        }
        catch( Exception e ){
            System.out.println( e );
        }
        
        newThread t2 = new newThread( "two" );
	    newThread t3 = new newThread( "thre" );
	    
	}
}






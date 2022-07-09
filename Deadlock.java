/*      DeadLock    */
/*      Occurs when 2 threads have a circular Dependence on a pair of synchronized Objects     */
/*      FOr EG:-    

            suppose one thread enters the monitor on object X and another thread enters the monitor on object Y     
            If thread in X tries to call any synchronized method in Y, it will be blocked as expected
            illy, If thread in Y tries something similar, it will wait forever
            because in order to get X's monitor it has to give up it's own monitor first so that first thread could complete
            
*/
class X{
    
    synchronized void meth1( Y y ){
        
        String name = Thread.currentThread().getName();
        System.out.println( name + "Thread Entered method 1" );
        
        try{
            Thread.sleep( 1000 );
        }
        catch( InterruptedException e ){
            System.out.println( e );
        }
        
        System.out.println( "Trying to call y.common()" );
        y.common();
    }
    
    synchronized void common(){
        System.out.println( "Inside X.common()" );
    }
}

class Y{
    
    synchronized void meth2( X x ){
        
        String name = Thread.currentThread().getName();
        System.out.println( name + "Thread Entered method 2" );
        
        try{
            Thread.sleep( 1000 );
        }
        catch( InterruptedException e ){
            System.out.println( e );
        }
        
        System.out.println( "Trying to call x.common()" );
        x.common();
    }
    
    synchronized void common(){
        System.out.println( "Inside Y.common()" );
    }
}

public class Deadlock implements Runnable {
    
    X x = new X();
    Y y = new Y();
    
    Deadlock(){
        
        Thread.currentThread().setName( "First" );
        Thread t = new Thread( this, "Second" );
        t.start();
        
        x.meth1( y );   //  get lock on x in First Thread
        System.out.println( "First Thread returned" );
    }
    
    public void run(){
        y.meth2( x );   //  get lock on y in Second Thread
        System.out.println( "Second Thread returned" );
    }
    
	public static void main(String[] args) {
		new Deadlock();
	}
}







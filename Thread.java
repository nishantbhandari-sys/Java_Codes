
class newThread implements Runnable{
    Thread t;
    
    newThread(){
        t = new Thread( this, "thd" );
        System.out.println( t.getName());
        t.start();
    }
    
    public void run(){
        try{
            for( int i = 5; i > 0; i-- ){
                System.out.println( "In childThread " + i );
                t.sleep( 500 );
            }
        }
        catch( Exception e ){
            System.out.println( e );
        }
        
        System.out.println( "Exiting childThread" );
    }
}

public class Main{
    
	public static void main(String[] args) {
	    new newThread();
	    
 		try{
            for( int i = 5; i > 0; i-- ){
                System.out.println( "In MainThread " + i );
                Thread.sleep( 1000 );
            }
        }
        catch( Exception e ){
            System.out.println( e );
        }
        
        
	}
}

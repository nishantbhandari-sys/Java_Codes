/*      Producer Consumer Problem    */

class Q{
    int curr;
    boolean isAval = false;
    
    synchronized void get(){
        
        if( !isAval )
            try{
                wait();
            }
            catch( InterruptedException e ){
                System.out.println( e );
            }
        
        System.out.println( "Got: " + curr );
        isAval = false;
        notify();
    }
    
    synchronized void put( int i ){
        
        if( isAval )
            try{
                wait();
            }
            catch( InterruptedException e ){
                System.out.println( e );
            }
        
        curr = i;
        System.out.println( "Put: " + curr );
        isAval = true;
        notify();
    }
}

class Producer implements Runnable {
    Q q;
    
    Producer( Q q ){
        this.q = q;
        new Thread( this, "Producer" ).start();
    }
    
    public void run(){
        int i = 1;
        
        while( i < 50 ){
            q.put( i++ );
        }
    }
}

class Consumer implements Runnable {
    Q q;
    
    Consumer( Q q ){
        this.q = q;
        new Thread( this, "Consumer" ).start();
    }
    
    public void run(){
        
        while(true){
            q.get();
        }
    }
}

class Main{
	public static void main(String[] args) {
		
		Q q = new Q();
		
		new Producer( q );
		new Consumer( q );
	}
}

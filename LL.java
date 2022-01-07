
public class LL{

	private Node head;
	private Node tail;
	private int size;

	public LL(	){

		this.size = 0 ;
	}
	private class Node{

		int data ;
		Node next ;

		public Node( int val ){
			this.data = val;
			this.next = null;
		}
	}



    public void insert_Rec( int val, int idx ){
        head = rec_pos( head, val, idx );
        size += 1;
    }
    //  User doesn't need to handle this
    private Node rec_pos( Node trv, int val, int idx ){
        if( idx == 0 ){
            
            Node node = new Node( val ) ;
            node.next = trv ;
            return node;
        }
        
        trv.next = rec_pos( trv.next, val, idx -1 );
        return trv;
    }



	public void insert_Pos( int val, int idx ){

		if( idx == 0 ){
			insert_Beg( val );
			return;
		}
		if( idx == size ){
			insert_End( val );
			return;
		}

		Node tmp = head;
		for ( int i = 1; i < idx ; i++ ) {
			tmp = tmp.next;
		}

		Node node = new Node( val );
		node.next = tmp.next;
		tmp.next = node;

		size += 1;
	}

	public void insert_End( int val ){
		if( tail == null ){
			insert_Beg( val );
			return;
		}

		tail.next = new Node( val );
		tail = tail.next;

		size += 1;
	}

	public void insert_Beg( int val ){

		Node node = new Node( val );
		node.next = head;
		head = node ;

		if( tail == null ){
			tail = head;
		}

		size += 1;
	}

	public void display(	){
		Node tmp = head;

		while ( tmp != null ) {
			
			System.out.print( tmp.data + " -> " ) ;	
			tmp = tmp.next ;
		}

		System.out.println( "End" ) ;
	}
}

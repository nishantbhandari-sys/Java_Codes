
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




//  Remove Duplicate nodes from a sorted LL
    public void rm_Duplicates(  ){
        head = Dremove( head );
    }
    private Node Dremove( Node node ){
        Node head = node;
        
        while( node.next != null ){
            
            if( node.data == node.next.data )
                //  Delete next node
                node.next = node.next.next;
            else
                node = node.next;
        }
        return head;
    }



	

    public void Merge( LL list1, LL list2 ){
        // mergeTwoLists( list1.head, list2.head );
    
    //  Merge using REcursion
        head = R_merge( list1.head, list2.head );
    }
//  Merge two Sorted LL
    public void mergeTwoLists(Node f , Node s) {
        
        while( f != null && s != null ){
            if( f.data <= s.data ){
                //  add node from list1
                insert_End( f.data );
                f = f.next;
            }
            else{
                //  add list from list2
                insert_End( s.data );
                s = s.next;
            }
        }
        while( f != null ){
            insert_End( f.data );
            f = f.next;
        }
        while( s != null ){
            insert_End( s.data );
            s = s.next;
        }
        
    }
    
    public Node R_merge( Node f , Node s ){
        
        if( f == null )         return s;
        if( s == null )         return f;
        
        if( f.data <= s.data ){
            f.next = R_merge( f.next, s );
            return f;
        }
        else
            return R_merge( s, f );
    }


	

//  Cycle detection in LL
    public boolean hasCycle( Node node ){
        //  Initially fast & slow both point to 1st Node
        Node s = node;
        Node f = s;
        
        while( f != null ){
            
            s = s.next;
            f = f.next.next;
            if( f == s ){
                //  Cycle detected
                return true;
            }
        }
        return false;
    }

	
	

//  https://leetcode.com/problems/find-the-duplicate-number/solution/
    //  Similar soln at above link Approach: 7
    //  Shows concept that the nodes after intersection pt is always equal to nodes before cycle head
    
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = true;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow) {
                flag = false ;
                break;
            }
        }

        if (flag) {
            return null;
        }

        // find the start node
        fast = head;

        // keep moving both forward and they will meet at cycle start
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

	
	
	
	
// https://leetcode.com/problems/linked-list-cycle
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

	
	
	
	
    // find length of the cycle
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // calculate the length
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
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

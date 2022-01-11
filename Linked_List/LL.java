
public class LL{

	private ListNode head;
	private ListNode tail;
	private int size;

	public LL(	){

		this.size = 0 ;
	}
	private class ListNode{

		int data ;
		ListNode next ;

		public ListNode( int val ){
			this.data = val;
			this.next = null;
		}
	}



    public void insert_Rec( int val, int idx ){
        head = rec_pos( head, val, idx );
        size += 1;
    }
    //  User doesn't need to handle this
    private ListNode rec_pos( ListNode trv, int val, int idx ){
        if( idx == 0 ){
            
            ListNode node = new ListNode( val ) ;
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

		ListNode tmp = head;
		for ( int i = 1; i < idx ; i++ ) {
			tmp = tmp.next;
		}

		ListNode node = new ListNode( val );
		node.next = tmp.next;
		tmp.next = node;

		size += 1;
	}

	public void insert_End( int val ){
		if( tail == null ){
			insert_Beg( val );
			return;
		}

		tail.next = new ListNode( val );
		tail = tail.next;

		size += 1;
	}

	public void insert_Beg( int val ){

		ListNode node = new ListNode( val );
		node.next = head;
		head = node ;

		if( tail == null ){
			tail = head;
		}

		size += 1;
	}




//  Remove Duplicate ListNodes from a sorted LL
    public void rm_Duplicates(  ){
        head = Dremove( head );
    }
    private ListNode Dremove( ListNode node ){
        ListNode head = node;
        
        while( node.next != null ){
            
            if( node.data == node.next.data )
                //  Delete next ListNode
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
    public void mergeTwoLists(ListNode f , ListNode s) {
        
        while( f != null && s != null ){
            if( f.data <= s.data ){
                //  add ListNode from list1
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
    
    public ListNode R_merge( ListNode f , ListNode s ){
        
        if( f == null )         return s;
        if( s == null )         return f;
        
        if( f.data <= s.data ){
            f.next = R_merge( f.next, s );
            return f;
        }
        else
            return R_merge( s, f );
    }


	



//  https://leetcode.com/problems/find-the-duplicate-number/solution/
    //  Similar soln at above link Approach: 7
    //  Shows concept that the ListNodes after intersection pt is always equal to ListNodes before cycle head
    
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

        // find the start ListNode
        fast = head;

        // keep moving both forward and they will meet at cycle start
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

	
	
	
	
// https://leetcode.com/problems/linked-list-cycle
//  Cycle detection in LL
    public boolean hasCycle( ListNode head ){
        //  Initially fast & slow both point to 1st ListNode
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



//  Finding middle ListNode of a LL
    public void middle( ){
        ListNode n = middleListNode( head );
        System.out.println( n.data );
    }
    public ListNode middleListNode( ListNode node ) {
        ListNode slow = node;
        ListNode fast = node;
        
        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
	
	


//  merge Sort in LL
    public void Lsort( ){
        head = divide( head );
        //  70 -> 30 -> 20 -> 10 -> 50 -> 60 -> End
    }
    private ListNode divide( ListNode node ){
        if( node == null || node.next == null )
            return node;
        // System.out.println( ListNode.data );
            
        ListNode mid = BMid( node );
        
        ListNode f = divide( node );
        ListNode s = divide( mid );
        
        return merge( f, s );
    }
    private ListNode merge( ListNode f, ListNode s ){
        ListNode node = new ListNode( -1 ) ;
        ListNode trv = node;
        
        while( f != null && s != null ){
            
            if( f.data < s.data ){
                trv.next = f;
                f = f.next;
            }
            else{
                trv.next = s;
                s = s.next;
            }
            trv = trv.next;
        }
        
        trv.next = ( f != null ) ? f : s ;
        return node.next;
    }
    private ListNode BMid( ListNode fast ){
        ListNode slow = null;
        
        while( fast != null && fast.next != null ){
            slow = ( slow == null ) ? fast : slow.next;
            fast = fast.next.next;
        }
        //  Now slow is pointing 1 ListNode before mid ListNode
        fast = slow.next;   //  mid ListNode
        slow.next = null;   //  Breaking link b/w lists
        return fast;        //  return mid ListNode
    }

	
	
	
	
    public void Hdisplay( ListNode tmp ){
		while ( tmp != null ) {
			
			System.out.print( tmp.data + " -> " ) ;	
			tmp = tmp.next ;
		}

		System.out.println( "End" ) ;
    }

	public void display(	){
		ListNode tmp = head;

		while ( tmp != null ) {
			
			System.out.print( tmp.data + " -> " ) ;	
			tmp = tmp.next ;
		}

		System.out.println( "End" ) ;
	}
}

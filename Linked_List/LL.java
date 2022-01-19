
public class LL{

    private ListNode head;
    private ListNode tail;
    private int size;

    public LL(  ){

        this.size = 0 ;
    }
    private class ListNode{

        int val ;
        ListNode next ;

        public ListNode( int val ){
            this.val = val;
            this.next = null;
        }
        public ListNode( int val, ListNode next ){
            this.val = val;
            this.next = next;
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
            
            if( node.val == node.next.val )
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
            if( f.val <= s.val ){
                //  add ListNode from list1
                insert_End( f.val );
                f = f.next;
            }
            else{
                //  add list from list2
                insert_End( s.val );
                s = s.next;
            }
        }
        while( f != null ){
            insert_End( f.val );
            f = f.next;
        }
        while( s != null ){
            insert_End( s.val );
            s = s.next;
        }
        
    }
    
    public ListNode R_merge( ListNode f , ListNode s ){
        
        if( f == null )         return s;
        if( s == null )         return f;
        
        if( f.val <= s.val ){
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
        System.out.println( n.val );
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
    public void mergeSort( ){
        head = divide( head );
        //  70 -> 30 -> 20 -> 10 -> 50 -> 60 -> End
    }
    private ListNode divide( ListNode node ){
        if( node == null || node.next == null )
            return node;
        // System.out.println( ListNode.val );
            
        ListNode mid = BMid( node );
        
        ListNode f = divide( node );
        ListNode s = divide( mid );
        
        return merge( f, s );
    }
    private ListNode merge( ListNode f, ListNode s ){
        ListNode node = new ListNode( -1 ) ;
        ListNode trv = node;
        
        while( f != null && s != null ){
            
            if( f.val < s.val ){
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
    //  Breaks LL from middle
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

    
    
    
    
    
    
//  Bubble Sort in LL
//  Written Ref
//  https://github.com/nishant-out/Problms/blob/main/Written_ref/WhatsApp%20Image%202022-01-16%20at%2018.36.32.jpeg
//  https://github.com/nishant-out/Problms/blob/main/Written_ref/WhatsApp%20Image%202022-01-16%20at%2018.36.31.jpeg
    
    public void bubbleSort( ){
        head = Bubble( head );
    }
    private ListNode Bubble( ListNode head ){
        ListNode ptr1 = null;
        ListNode ptr2 = null;
        ListNode prev1 = null;
        ListNode prev2 = null;
        
        ptr1 = head;
        head = null;
        while( ptr1 != null ){
            prev2 = ptr1;
            ptr2 = ptr1.next;
            
            while( ptr2 != null ){
                if( ptr2.val < ptr1.val ){
                    //  Swap nodes 
                    ListNode tmp = null;
                    
                    //  Case 1:
                    if( ptr1.next == ptr2 ){
                        ptr1.next = ptr2.next;
                        ptr2.next = ptr1;
                        
                        //  swapping/changing pointer names
                        tmp = ptr1;
                        ptr1 = ptr2;
                        ptr2 = tmp;
                        
                        if( prev1 != null )      prev1.next = ptr1;
                    }
                    //  Case 2:
                    else{
                        tmp = ptr1.next;
                        ptr1.next = ptr2.next;
                        ptr2.next = tmp;
                        
                        //  swapping/changing pointer names
                        tmp = ptr1;
                        ptr1 = ptr2;
                        ptr2 = tmp;
                        
                        if( prev1 != null )      prev1.next = ptr1;
                        prev2.next = ptr2;
                    }
                }
                prev2 = ptr2;
                ptr2 = ptr2.next;
                
                // System.out.print( "With ptr1: " );
                // Hdisplay( ptr1 );
                // System.out.print( "With ptr2: " );
                // Hdisplay( ptr2 );
            }
            if( head == null )      head = ptr1;
            prev1 = ptr1;
            ptr1 = ptr1.next;
        }
        return head;
    }
    
    
    
    
    
    
    
//  Rersing a LL using REcursion without use of tail pointer
    public void revRec( ){
        head = rev( head ); 
    }
    private ListNode rev( ListNode head ){
        if( head.next == null ){
            return head;
        }
        
        ListNode last = rev( head.next );
        head.next.next = head;
        head.next = null;
        
        return last;
    }
    
    


    
    
    
    

//  Reversing a LL using 3 pointers
    public void reverse( ){
        ListNode prev = null;
        ListNode curr = head;
        ListNode ahead = head.next;
        
        while( curr != null ){
            
            curr.next = prev;
            prev = curr;
            curr = ahead;
            if( ahead != null )     //  for null pointer Exception error
                ahead = ahead.next;
        }
        
        head = prev;
    }
    
    
    
    
    
    
    
    
    
//  Reversing a part of LL
    public void revBween( int m, int n ){
        head = RecreverseBetween( head, m, n );
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if( left == right )    return head;
        
        ListNode ptr1 = null;
        ListNode ptr2 = head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode ahead = head.next;
        
        //  Initialize pointers
        int i = left;
        while( i > 1 ){
            prev = curr;
            curr = curr.next;
            ptr2 = curr;
            ptr1 = prev;
            
            i --;
        }
        ahead = ( curr == null ) ? curr : curr.next;
        
        while( right >= left ){
            curr.next = prev;
            prev = curr;
            curr = ahead;
            if( ahead != null )     //  for null pointer Exception error
                ahead = ahead.next;
                
            right--;
        }
        
        if( left == 1 ){            head = prev;        }
        
        if( ptr1 != null ){
            ptr1.next = prev;
        }
        ptr2.next = curr;
        
        return head;
    }
    //  using REcursion:
    public ListNode RecreverseBetween(ListNode head, int m, int n) {
        // if( left == right )    return head;
        if( m <= 1 ){
            return rev_from_start( head, n - m +1 );    //  n - m +1 => no. of nodes to reverse
        }
        
        head.next = reverseBetween( head.next, m -1, n -1 );
        
        return head;
    }
    //  Reverses first n nodes of LL
    public ListNode successor = null;
    public ListNode rev_from_start( ListNode head, int n ){    
        if( n == 1 ){
            successor = head.next;
            return head;
        }
        
        ListNode last = rev_from_start( head.next, n -1 );
        head.next.next = head;
        head.next = successor;
        
        return last;
    }
    
    
    
    


//  Checks if a list is Palindrome
    public boolean issPalindrome( ){
        return isPalindrome( head );
    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid = BMid( head );
        ListNode secondhead = rev( mid );
        
        while( head != null && secondhead != null ){
            if( head.val != secondhead.val )
                return false;;
            head = head.next;
            secondhead = secondhead.next;
        }
        
        return true;
    }
    
    
    
    


    public void reorder( ){
        head = reorderList( head );
    }
    public ListNode reorderList(ListNode head) {
        ListNode mid = BMid( head );
        mid = rev( mid );
        
        ListNode dummy = new ListNode( -1 );
        ListNode ans = dummy;
        
        while( head != null && mid != null ){
            //  Giving head
            dummy.next = head;
            dummy = dummy.next;
            head = head.next;
            
            //  Giving mid
            dummy.next = mid;
            dummy = dummy.next;
            mid = mid.next;
        }
        return ans.next;
    }
    
    
    
    
    
    
    
    
    public void revKGroup( int k ){
        head = reverseKGroup( head, k );
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if( k <= 1 )    return head;
        ListNode pass = head;
        
        //  Makes group of LL
        int i = 1;
        while( i <= k ){
            if( pass == null ){
                return head;
            }
            pass = pass.next;
            i++;
        }
        ListNode tmp = reverseKGroup( pass, k);
        ListNode newtail = head;
        ListNode newhead = rev_from_start( head, k );
        newtail.next = tmp;
        
        return newhead;
    }
    
    
    
    
    
    
    public ListNode org = null;
    public void rotateRight( int k ){
        if( head == null )  return ;
        int len = 0;
        ListNode dummy = head;
        
        while( dummy != null ){
            dummy = dummy.next;
            len++;
        }
        k %= len;
        if( k == 0 )            return ;  
        
        org = head;
        int x = rotateRightt( head, k );
        head = org;
    }
    public int rotateRightt(ListNode head, int k) {
         
        if( head.next == null ){
            head.next = org;
            return k -1;
        }
        k = rotateRightt( head.next, k );
        if( k == 0 ){
            org = head.next;
            head.next = null;
        }
        return k -1;
    }
    






    public void removekthEnd( int k ){
        head = removeNthFromEnd( head, k );
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        n = hlp( head, n );
        
        if( n != -1 ){
            return head.next;
        }
        return head;
    }
    public int hlp( ListNode head, int k ){
        if( head == null ){
            return k;
        }
        
        k = hlp( head.next, k );
        
        if( k == -1 )   return k;
        if( k == 0 ){
            //  delete next node
            head.next = head.next.next;
            return -1;
        }
        return k -1;
    }



    
    
    //  Has bugs not good
    public void swapkNodes( int k ){
        head = swapNodes( head, k );
    }
    public ListNode swapNodes(ListNode head, int k) {
        int len = length( head );
        return hlper( head, k, len - ((2*k) -2) );
    }
    public ListNode hlper( ListNode head, int k, int n ){
        if( k <= 1 ){
            return rev_from_start( head, n );
        }
        
        head.next = hlper( head.next, k -1, n );
        
        return head;
    }
    public int length( ListNode head ){
        int len = 0;
        while( head != null ){
            head = head.next;
            len++;
        }
        return len;
    }
    
    
    
    
    
    
    
    
    //  Adding two Lists
    public void addTwoLists( LL list1, LL list2 ){
        
        head = addTwoNumbers( list1.head, list2.head );
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null;
        ListNode head = null;
        int sum = 0;
        int carry = 0;
        
        while( l1 != null && l2 != null ){
            
            sum = l1.val + l2.val + carry;
            
            carry = 0;
            if( sum > 9 ){
                sum = 0;
                carry = 1;
            }
            
            ans = addBeg( ans, sum );
            if( head == null )  head = ans;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while( l1 != null ){
            
            sum = l1.val + carry;
            
            carry = 0;
            if( sum > 9 ){
                sum = 0;
                carry = 1;
            }
            ans = addBeg( ans, sum );
            
            l1 = l1.next;
        }
        while( l2 != null ){
            
            sum = l2.val + carry;
            
            carry = 0;
            if( sum > 9 ){
                sum = 0;
                carry = 1;
            }
            ans = addBeg( ans, sum );
            
            l2 = l2.next;
        }
        if( carry == 1 ){
            ans = addBeg( ans, 1 );
        }
        
        return head;
    }
    public ListNode addBeg( ListNode tail, int val ){
        
        if( tail == null )  return new ListNode( val );
        tail.next = new ListNode( val, null );
        
        return tail.next;
    }
    
    
    
    
    
    
    
    
    public void Hdisplay( ListNode tmp ){
        while ( tmp != null ) {
            
            System.out.print( tmp.val + " -> " ) ; 
            tmp = tmp.next ;
        }

        System.out.println( "End" ) ;
    }
    public void display(    ){
        ListNode tmp = head;

        while ( tmp != null ) {
            
            System.out.print( tmp.val + " -> " ) ; 
            tmp = tmp.next ;
        }

        System.out.println( "End" ) ;
    }
}

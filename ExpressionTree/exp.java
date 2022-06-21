public class expressionTree{
    
    private Node root;
    private class Node{

        char val;
        Node left ;
        Node right ;
        public Node( char val ){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    
    public void createTree( String exp ){
        int[] freq = new int[3];
        operatorCounter( exp, freq );
        // System.out.println( "lvl3's :" +  freq[ 2 ] );
        // System.out.println( "lvl2's :" +  freq[ 1 ] );
        // System.out.println( "lvl1's :" +  freq[ 0 ] );
        
        root = hlp( exp, 0, exp.length() -1, freq );
    }
    
    public Node hlp( String exp, int st, int en, int[] lvl ){
        
        if( st >= en ){
            return new Node( exp.charAt( st ) );
        }
        Node curr = null;
        int idx = (en -st) /2;
        
        if( lvl[ 2 ] > 0 ){
            idx = operatorAt( exp, st, en, 3 );
            // System.out.println( "lvl3: " + exp.charAt( idx ) );
            
            curr = new Node( exp.charAt( idx ) );
            lvl[ 2 ]--;
        }
        
        else if( lvl[ 1 ] > 0 ){
            idx = operatorAt( exp, st, en, 2 );
            // System.out.println( "lvl2: " + exp.charAt( idx ) );
            
            curr = new Node( exp.charAt( idx ) );
            lvl[ 1 ]--;
        }
        
        else if( lvl[ 0 ] > 0 ){
            idx = operatorAt( exp, st, en, 1 );
            // System.out.println( "lvl1: " + exp.charAt( idx ) );
            
            curr = new Node( exp.charAt( idx ) );
            lvl[ 0 ]--;
        }
        
        curr.left  = hlp( exp, st, idx -1, lvl );
        curr.right = hlp( exp, idx +1, en, lvl );
        
        return curr;
    }
    
    private int operatorAt( String exp, int st, int en, int lvl ){
        //  1. + -
        //  2. * /
        //  3. ^
        //  Finds idx of last operator according to lvls
        char op1 = '!';
        char op2 = '!';
        int ans = -1;
        
        switch( lvl ){
            case 1:     op1 = '^';                  break;
                
            case 2:     op1 = '*';  op2 = '/';      break;
                
            case 3:     op1 = '+';  op2 = '-';      break;
        }
        
        while( st <= en ){
            if( exp.charAt(st) == op1 || ( op2 != '!' && exp.charAt(st) == op2 ) )
                ans = st;
            
            st++;
        }
        
        return ans;
    }
    
    private void operatorCounter( String exp, int[] arr ){
        
        for ( char ch: exp.toCharArray() ){
            if( ch == '+' || ch == '-' )
                arr[ 2 ] += 1;
                
            else if( ch == '*' || ch == '/' )
                arr[ 1 ] += 1;
                
            else if( ch == '^' )
                arr[ 0 ] += 1;
        }
        
    }
    
    public void preOrder(){
        System.out.print( "\nroot: " + root.val + "\npreOrder: " );
        pre( root );
    }
    public void pre( Node root ){
        if( root == null )      return;
        
        System.out.print( root.val + " " );
        pre( root.left );
        pre( root.right );
    }
    
    public void postOrder(){
        System.out.print( "\nroot: " + root.val + "\npostOrder: " );
        post( root );
    }
    public void post( Node root ){
        if( root == null )      return;
        
        post( root.left );
        post( root.right );
        System.out.print( root.val + " " );
    }
} 









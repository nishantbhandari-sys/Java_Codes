public class Main{
	public static void main(String[] args) {
		
		expressionTree exp = new expressionTree();
		
		//  a*b/c+e/f*g+k-x*y
		exp.createTree( "z^m+a*b/c+k" );
		
		exp.preOrder();     //  Prefix
		exp.postOrder();    //  Postfix
	}
	
}

package gfgpractice.tree;

public class CheckIfTreeIsSumTree {
	public static void main(String []args){
		Node root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(4);
		System.out.println("Given tree is sum tree:"+isSumTree(root));
		System.out.println("Given tree is sum tree:"+isSumTreeTricky(root));
		
	}
	static int sum(Node node){
		if (node==null) return 0;
		return sum(node.left) + node.data + sum(node.right);
	}
	//O(n^2)
	static boolean isSumTree(Node node){
		int ls, rs;
		if(node == null || (node.left == null && node.right == null)){
			return true;
		}
		ls = sum(node.left);
		rs = sum(node.right);
		if(node.data == (ls + rs) && isSumTree(node.left) && isSumTree(node.right)){
			return true;
		}
		return false;
	}
	//O(n)
	static boolean isSumTreeTricky(Node node){
		if (node == null || isLeafNode(node))
		return true;
		
		if(isSumTreeTricky(node.left) && isSumTreeTricky(node.right)){
			int ls,rs;
			if(node.left == null){
				ls = 0;
			} else if(isLeafNode(node.left)){
				ls = node.left.data;
			} else {
				ls = 2 * node.left.data;
			}
			
			if(node.right == null){
				rs = 0;
			} else if (isLeafNode(node.right)){
				rs = node.right.data;
			} else {
				rs = 2 * node.right.data;
			}
			if (node.data == (ls + rs)){
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	static boolean isLeafNode(Node node){
		if (node == null) return false;
		if (node.left == null && node.right == null) return true;
		return false;
	}
}

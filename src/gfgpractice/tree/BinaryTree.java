package gfgpractice.tree;

public class BinaryTree {
	Node root;
	public static void main(String []args){
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(26);
		tree.root.left = new Node(10);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(6);
		tree.root.right.right = new Node(3);
		System.out.print("Inorder traversal of tree before mirror:");
		tree.inOrder(tree.root);
		tree.root = tree.mirrorTree(tree.root);
		System.out.print("\nInorder traversal of tree after mirror:");
		tree.inOrder(tree.root);
	}
	
	void inOrder(Node node){
		if (node==null) return;
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}
	
	Node mirrorTree(Node node){
		if (node == null || (node.left == null && node.right == null)) return node;
		Node leftSubTree = mirrorTree(node.left);
		Node rightSubTree = mirrorTree(node.right);
		node.left = rightSubTree;
		node.right = leftSubTree;
		return node;
	}
}

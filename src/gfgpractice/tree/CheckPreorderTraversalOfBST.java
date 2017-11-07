package gfgpractice.tree;

import java.util.Scanner;
import java.util.Stack;

public class CheckPreorderTraversalOfBST {
	/**
	 * @param args
	 */
	public static void main(String []args){
		int pre[] = {40, 30, 35, 80, 100};
		System.out.println("Given sequence is a BST:"+checkIfPreorderIsBST(pre, 0, pre.length));
		System.out.println("Given sequence is a BST:"+checkIfPreorderIsBST(pre));
		int pre1[] = {40, 30, 35, 20, 80, 100};
		//int pre1[] = {7,4,2,1,5,6,9,40};
		//int pre1[] = {2,3,1};
		System.out.println("Given sequence is a BST:"+checkIfPreorderIsBST(pre1, 0, pre1.length));
		System.out.println("Given sequence is a BST:"+checkIfPreorderIsBST(pre1));
	}
	static boolean checkIfPreorderIsBST(int pre[], int start, int end){
		if(start>=end) {
			return true;
		} else {
			int firstGreater = pre[start], firstGreaterPos=start;
			for(int i=start+1; i<end; i++){
				if(pre[i]>firstGreater){
					firstGreater = pre[i];
					firstGreaterPos = i;
					for(int j=i+1; j<end; j++){
						if(pre[start]>pre[j]){
							return false;
						}
					}
					break;
				}	
			}
			return (checkIfPreorderIsBST(pre, start+1, firstGreaterPos) && checkIfPreorderIsBST(pre, firstGreaterPos+1, end));
		}
	}
	static boolean checkIfPreorderIsBST(int pre[]){
		// Create an empty stack
        Stack<Integer> s = new Stack<Integer>();
 
        // Initialize current root as minimum possible
        // value
        int root = Integer.MIN_VALUE;
 
        // Traverse given array
        for (int i = 0; i < pre.length; i++) {
            // If we find a node who is on right side
            // and smaller than root, return false
            if (pre[i] < root) {
                return false;
            }
 
            // If pre[i] is in right subtree of stack top,
            // Keep removing items smaller than pre[i]
            // and make the last removed item as new
            // root.
            while (!s.empty() && s.peek() < pre[i]) {
                root = s.peek();
                s.pop();
            }
 
            // At this point either stack is empty or
            // pre[i] is smaller than root, push pre[i]
            s.push(pre[i]);
        }
        return true;
	}
}

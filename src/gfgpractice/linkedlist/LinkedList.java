package gfgpractice.linkedlist;

public class LinkedList {
	ListNode head = null;
	public static void main(String []args){
		LinkedList obj = new LinkedList();
		for (int i=4;i>0; i--){
			obj.push(i);
		}
		obj.printList();
		obj.printMiddle();
		//obj.reverseList();
		obj.printList();
		//obj.recursiveReverse();
		obj.reverseUtil(obj.head, null);
		obj.printList();
	}
	void push(int d){
		ListNode node = new ListNode(d);
		node.next = head;
		head = node;
	}
	void printList(){
		ListNode tempNode = head;
		while(tempNode!=null){
			System.out.print(tempNode.data+"->");
			tempNode = tempNode.next;
		}
		System.out.println("Null");
	}
	void printMiddle(){
		ListNode slow_ptr = head;
		ListNode fast_ptr = head;
		while(fast_ptr != null && fast_ptr.next != null){
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
		}
		System.out.println("Middle element is:"+slow_ptr.data);
	}
	void reverseList(){
		ListNode currentNode = head;
		ListNode previousNode = null;
		ListNode nextNode = null;
		while(currentNode!=null){
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		head = previousNode;
	}
	
	void recursiveReverse(){
		if(head == null) return;
		ListNode first = head;
		ListNode rest = first.next;
		if(rest == null) return;
		head = rest;
		recursiveReverse();
		first.next.next = first;
		first.next = null;
	}
	
	void reverseUtil(ListNode curr, ListNode prev) {
		 
        /* If last node mark it head*/
        if (curr.next == null) {
            head = curr;
 
            /* Update next to prev node */
            curr.next = prev;
            return;
        }
 
        /* Save curr->next node for recursive call */
        ListNode next1 = curr.next;
 
        /* and update next ..*/
        curr.next = prev;
 
        reverseUtil(next1, curr);
        return;
    }
	
	class ListNode {
		int data;
		ListNode next;
		ListNode(int d){
			data = d;
			next = null;
		}
	}
}

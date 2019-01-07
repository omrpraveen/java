package collections.list.linkedlist;

public class SingleLinkedList {

	Node node;

	class Node {

		int data;

		Node next;

		Node(int t) {
			this.data = t;
		}

	}

	public void push(int new_data) {

		Node newNode = new Node(new_data);

		newNode.next = null;

		if (node == null)
			node = newNode;
		else
			node.next = newNode;
	}

	public void print(Node node) {

		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println();
	}

	public void delete(int key) {
		
		if (node == null)
			return;
		do {
			if (node.data == key) {
				node = node.next;
			} else if (node.next != null && node.next.data == key) {
				if (node.next.next != null) {
					node.next = node.next.next;
				} else {
					node.next = null;
				}
			}
		} while (node != null);

	}
	
	public static void main(String args[]) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.push(1);
		singleLinkedList.push(2);
		singleLinkedList.push(3);
		singleLinkedList.push(4);
		singleLinkedList.push(5);
		singleLinkedList.push(6);
		singleLinkedList.push(7);
		singleLinkedList.push(8);
		singleLinkedList.push(9);
		singleLinkedList.push(10);
		singleLinkedList.print(singleLinkedList.node);
		singleLinkedList.delete(1);
		singleLinkedList.print(singleLinkedList.node);
	}

}

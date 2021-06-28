package com.bridgelabz.HashTable;

public class LinkedList<K> {
	public INode<K> tail;
	public INode<K> head;

	LinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void add(INode<K> node) {
		if (this.tail == null) {
			this.tail = node;
		}
		if (this.head == null) {
			this.head = node;
		} else {
			INode<K> tempNode = this.head;
			this.head = node;
			this.head.setNextNode(tempNode);
		}
	}

	public void append(INode<K> newNode) {
		if (tail == null) {
			this.tail = newNode;
		}
		if (head == null) {
			this.head = newNode;
		} else {
			this.tail.setNextNode(newNode);
			this.tail = newNode;
		}
	}

	public void insert(INode<K> node, INode<K> newNode) {
		INode<K> tempNode = node.getNextNode();
		node.setNextNode(newNode);
		newNode.setNextNode(tempNode);
	}

	public INode<K> pop() {
		INode<K> tempNode = this.head;
		this.head = head.getNextNode();
		return tempNode;
	}

	public INode<K> popLast() {
		INode<K> tempNode = head;
		while (!tempNode.getNextNode().equals(tail)) {
			tempNode = tempNode.getNextNode();
		}
		this.tail = tempNode;
		tempNode = tempNode.getNextNode();
		return tempNode;
	}

	public INode<K> search(K key) {
		INode<K> tempNode = head;
		while (tempNode != null) {
			if (tempNode.getKey().equals(key)) {
				return tempNode;
			}
			tempNode = tempNode.getNextNode();
		}
		return null;
	}

	public void searchInsert(K key, INode<K> newNode) {
		INode<K> tempNode = head;
		while (tempNode.getNextNode() != null) {
			if (tempNode.getKey().equals(key)) {
				INode<K> temp = tempNode.getNextNode();
				tempNode.setNextNode(newNode);
				newNode.setNextNode(temp);
			}
			tempNode = tempNode.getNextNode();
		}
	}

	public void searchDelete(K key) {
		INode<K> tempNode = head;
		while (tempNode.getNextNode() != null) {
			if (tempNode.getNextNode().getKey().equals(key)) {
				INode<K> temp = tempNode.getNextNode().getNextNode();
				tempNode.setNextNode(temp);
			}
			tempNode = tempNode.getNextNode();
		}
	}

	public int size() {
		INode<K> temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.getNextNode();
		}
		return count;
	}

	public void printNode() {
		StringBuffer nodes = new StringBuffer("My Nodes: ");
		INode<K> tempNode = head;
		while (tempNode.getNextNode() != null) {
			nodes.append(tempNode.getKey());
			if (!tempNode.equals(tail))
				nodes.append("->");
			tempNode = tempNode.getNextNode();
		}
		nodes.append(tempNode.getKey());
		System.out.println(nodes);
	}

	public String toString() {
		return "LinkedList Nodes { " + head + '}';
	}
}
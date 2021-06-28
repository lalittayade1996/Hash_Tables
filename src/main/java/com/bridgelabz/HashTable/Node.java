package com.bridgelabz.HashTable;

public class Node<K> implements INode<K> {

	private K key;
	private Node<K> nextNode;

	public Node(K key) {
		this.key = key;
		this.nextNode = null;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public void setKey(K key) {
		this.key = key;
	}

	@Override
	public INode<K> getNextNode() {
		return nextNode;
	}

	@Override
	public void setNextNode(INode<K> nextNode) {
		this.nextNode = (Node<K>) nextNode;
	}
}

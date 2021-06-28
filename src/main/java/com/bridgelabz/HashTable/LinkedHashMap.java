package com.bridgelabz.HashTable;

import java.util.ArrayList;

public class LinkedHashMap<K, V> {
	private final int numBuckets;
	ArrayList<LinkedList<K>> bucketArray;

	public LinkedHashMap() {
		this.numBuckets = 10;
		this.bucketArray = new ArrayList<>(numBuckets);
		for (int i = 0; i < numBuckets; i++) {
			this.bucketArray.add(null);
		}
	}

	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		return hashCode % numBuckets;
	}

	public V get(K key) {
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.bucketArray.get(index);
		if (linkedList == null) {
			return null;
		}
		MapNode<K, V> mapNode = (MapNode<K, V>) linkedList.search(key);
		return (mapNode == null) ? null : mapNode.getValue();
	}

	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.bucketArray.get(index);
		if (linkedList == null) {
			linkedList = new LinkedList<>();
			this.bucketArray.set(index, linkedList);
		}
		MapNode<K, V> mapNode = (MapNode<K, V>) linkedList.search(key);
		if (mapNode == null) {
			mapNode = new MapNode<>(key, value);
			linkedList.append(mapNode);
		} else {
			mapNode.setValue(value);
		}
	}

	public V remove(K key) {
		int index = this.getBucketIndex(key);
		LinkedList<K> newLinkedList = this.bucketArray.get(index);

		MapNode<K, V> headNode = (MapNode<K, V>) newLinkedList.search(key);

		MapNode<K, V> prev = null;
		while (headNode != null) {
			if (headNode.key.equals(key))
				break;

			prev = headNode;
			headNode = headNode.next;
		}

		if (headNode == null)
			return null;

		if (prev != null)
			prev.next = headNode.next;
		else
			bucketArray.set(index, headNode.next);

		return headNode.value;
	}

	@Override
	public String toString() {
		return "MyLinkedHashMap List" + bucketArray + '}';
	}
}
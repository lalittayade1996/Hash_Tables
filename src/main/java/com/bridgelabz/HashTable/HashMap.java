package com.bridgelabz.HashTable;

public class HashMap<K, V> {
	LinkedList<K> linkedList;

	public HashMap() {
		this.linkedList = new LinkedList<>();
	}

	public V get(K key) {
		MapNode<K, V> hashNode = (MapNode<K, V>) this.linkedList.search(key);
		return (hashNode == null) ? null : hashNode.getValue();
	}

	public void add(K key, V value) {
		MapNode<K, V> hashNode = (MapNode<K, V>) this.linkedList.search(key);
		if (hashNode == null) {
			hashNode = new MapNode<>(key, value);
			this.linkedList.append(hashNode);
		} else {
			hashNode.setValue(value);
		}
	}
}
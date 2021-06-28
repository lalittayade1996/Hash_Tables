package com.bridgelabz.HashTable;

import org.junit.Assert;
import org.junit.Test;

public class TestHashMap {
	@Test
	public void givenASentenceWhenWordsAreAddedToListShouldReturnWorldFrequency() {
		String sentence = "To be or not to be";
		HashMap<String, Integer> hashTable = new HashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = hashTable.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			hashTable.add(word, value);
		}
		int frequency = hashTable.get("or");
		hashTable.linkedList.printNode();
		System.out.println(frequency);
		Assert.assertEquals(1, frequency);
	}

	@Test
	public void givenASentence_whenWordsAreAddedToList_ShouldReturnParanoidFrequency() {
		String sentence = "Paranoids are not paranoid because they are paranoid but because "
				+ "they keep putting themselves deliberately into paranoid avoidable situations";

		HashMap<String, Integer> linkedHashMap = new HashMap<>();
		String[] sentenceToWords = sentence.toLowerCase().split(" ");
		for (String word : sentenceToWords) {
			Integer value = linkedHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			linkedHashMap.add(word, value);
		}
		int frequency = linkedHashMap.get("paranoid");

		linkedHashMap.linkedList.printNode();
		System.out.println(frequency);
		Assert.assertEquals(3, frequency);
	}

	@Test
	public void givenASentence_whenWordsAreAddedToListAndRemoveWordShouldReturnWordFrequencyNull() {
		String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting "
				+ "themselves deliberately into paranoid avoidable situations";

		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
		String[] sentenceToWords = sentence.toLowerCase().split(" ");
		for (String word : sentenceToWords) {
			Integer value = linkedHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value++;
			linkedHashMap.add(word, value);
		}

		linkedHashMap.remove("avoidable");
		Integer frequency = linkedHashMap.get("avoidable");
		System.out.println(frequency);
		Assert.assertNull(frequency);
	}
}

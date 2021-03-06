package com.revature.example;

//Authors: Rebecca R. & Sean S.
import java.util.*;

public class HashMapExample {

	public static void main(String[] args) {

		/*
		 * General Description: Hash Table base implementation of the Map interface. It
		 * provides all of the optional map operations, and permits null values and the
		 * null key. (Roughly equivalent to Hashtable, except that it is unsynchronized
		 * and permits nulls.)
		 * 
		 * Are they ordered/indexed? It makes no guarantees as to the order go the map;
		 * in particular, it does not guarantee that the order will remain constant over
		 * time.
		 * 
		 * Are they synchronized(thread safe)? They are NOT synchronized(thread safe),
		 * and they permit nulls.
		 */

		// And here are four methods: put(), containsKey(), keySet(), values()

		// Creation of HashMap
		HashMap<String, String> Example = new HashMap<>();
		System.out.println("HashMap before method: " + Example);

		// put() associates the specified value with the specified key in this map.
		Example.put("Language", "Java");
		Example.put("Fruit", "Apple");
		Example.put("Code", "HashMap");
		Example.put("Learn", "More");
		System.out.println("HashMap after method: " + Example);

		// containsKey() is to check the presence of a particular key
		if (Example.containsKey("Code"))
			System.out.println("Testing .containsKey: " + Example.get("Code"));

		// keySet() returns all the keys in HashMap
		Set<String> Examplekeys = Example.keySet();
		System.out.println("Initial keys: " + Examplekeys);

		// values() returns all the values in HashMap
		Collection<String> Examplevalues = Example.values();
		System.out.println("Initial values: " + Examplevalues);

	}
}

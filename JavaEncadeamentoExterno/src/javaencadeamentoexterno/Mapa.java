// Java program to demonstrate implementation of our 
// own hash table with chaining for collision detection 

package javaencadeamentoexterno;

import java.util.ArrayList; 


// Class to represent entire hash table 
class Mapa<K, V> 
{ 
	// bucketArray is used to store array of chains 
	private ArrayList<NoHash<K, V>> ClasseArray; 

	// Current capacity of array list 
	private int ClasseQTD; 

	// Current size of array list 
	private int TAM; 

	// Constructor (Initializes capacity, size and 
	// empty chains. 
	public Mapa() 
	{ 
		ClasseArray = new ArrayList<>(); 
		ClasseQTD = 100000; 
		TAM = 0; 

		// Create empty chains 
		for (int i = 0; i < ClasseQTD; i++) 
			ClasseArray.add(null); 
	} 

	public int size() { return TAM; } 
	public boolean isEmpty() { return size() == 0; } 

	// This implements hash function to find index 
	// for a key 
	private int getIndiceClasse(K key) 
	{ 
		int hashCode = key.hashCode(); 
		int index = hashCode % ClasseQTD; 
		return index; 
	} 

	// Method to remover a given key 
	public V remover(K key) 
	{ 
		// Apply hash function to find index for given key 
		int IndiceClasse = getIndiceClasse(key); 

		// Get head of chain 
		NoHash<K, V> head = ClasseArray.get(IndiceClasse); 

		// Search for key in its chain 
		NoHash<K, V> prev = null; 
		while (head != null) 
		{ 
			// If Key found 
			if (head.key.equals(key)) 
				break; 

			// Else keep moving in chain 
			prev = head; 
			head = head.next; 
		} 

		// If key was not there 
		if (head == null) 
			return null; 

		// Reduce size 
		TAM--; 

		// Remove key 
		if (prev != null) 
			prev.next = head.next; 
		else
			ClasseArray.set(IndiceClasse, head.next); 

		return head.value; 
	} 

	// Returns value for a key 
	public V get(K key) 
	{ 
		// Find head of chain for given key 
		int bucketIndex = getIndiceClasse(key); 
		NoHash<K, V> head = ClasseArray.get(bucketIndex); 

		// Search key in chain 
		while (head != null) 
		{ 
			if (head.key.equals(key)) 
				return head.value; 
			head = head.next; 
		} 

		// If key not found 
		return null; 
	} 

	// Adds a key value pair to hash 
	public void add(K key, V value) 
	{ 
		// Find head of chain for given key 
		int bucketIndex = getIndiceClasse(key); 
		NoHash<K, V> head = ClasseArray.get(bucketIndex); 

		// Check if key is already present 
		while (head != null) 
		{ 
			if (head.key.equals(key)) 
			{ 
				head.value = value; 
				return; 
			} 
			head = head.next; 
		} 

		// Insert key in chain 
		TAM++; 
		head = ClasseArray.get(bucketIndex); 
		NoHash<K, V> newNode = new NoHash<K, V>(key, value); 
		newNode.next = head; 
		ClasseArray.set(bucketIndex, newNode); 

		// If load factor goes beyond threshold, then 
		// double hash table size 
		if ((1.0*TAM)/ClasseQTD >= 0.7) 
		{ 
			ArrayList<NoHash<K, V>> temp = ClasseArray; 
			ClasseArray = new ArrayList<>(); 
			ClasseQTD = 2 * ClasseQTD; 
			TAM = 0; 
			for (int i = 0; i < ClasseQTD; i++) 
				ClasseArray.add(null); 

			for (NoHash<K, V> headNode : temp) 
			{ 
				while (headNode != null) 
				{ 
					add(headNode.key, headNode.value); 
					headNode = headNode.next; 
				} 
			} 
		} 
	} 

	// Driver method to test Map class 
	public static void main(String[] args) 
	{ 
		Mapa<Integer, Integer>map = new Mapa<>(); 
		map.add(1,1 ); 
		map.add(2,2 ); 
		map.add(3,4 ); 
		map.add(4,5 ); 
		System.out.println(map.size()); 
		//System.out.println(map.remover("this")); 
		//System.out.println(map.remover("this")); 
		System.out.println(map.size()); 
		System.out.println(map.isEmpty()); 
	} 
} 

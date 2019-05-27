package javaencadeamentoexterno;
// A node of chains 
class NoHash<K, V> 
{ 
	K key; 
	V value; 

	// Reference to next node 
	NoHash<K, V> next; 

	// Constructor 
	public NoHash(K key, V value) 
	{ 
		this.key = key; 
		this.value = value; 
	} 
} 
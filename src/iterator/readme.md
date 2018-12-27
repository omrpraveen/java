Java Cursor:
	java cursor is an iterator, which is used to iterate, or 
	traverse or retrieve a collection or Stream objects elements one by one.
	
	Java supports the following four different cursors.
		Enumeration
		Iterator
		ListIterator
		Spliterator
	
Enumeration :
	it is an interface, introduced in java 1.0
	it is used to traversing the collection object.
	Enumeration follows fail-safe in nature, it doesn't
		throw any exception if a collection is modified.
	Basically it is apply on legacy classes
	(ie) Early verion of jave did not iinclude the collection
	framework. it only defined serveral classes and interfaces that
	provide methods for storing objects.
	
	when collection framework added the original classes were reengineered to 
	support the collection interface.
	Ex:
		1. Dictionary
		2. HashTable
		3. Properties
		4. Stack
		5. Vector
		
	Enumeration is the legacy interface.
	
	it has two methods,
		hasMoreElements() - returns true if it has more elements.
		nextElement() - returns next elements.
	
	Limitations of Enumeration :

    	Enumeration is for legacy classes(Vector, Hashtable) only.
    		Hence it is not a universal iterator.
    	Remove operations can’t be performed using Enumeration.
    	Only forward direction iterating is possible.

	
	

	
Iterator:
	it is an interface available in collection framework.
	it is used to iterate collection objects.
	it is universal java cursor, because it is applicable to all the collection
	classes.
	It supports only Forward direction iteration that is Uni-Directional Iterator.
	Compare to Spliterator, it does NOT support iterating elements parallel that means it supports only Sequential iteration.
	Compare to Spliterator, it does NOT support better performance to iterate large volume of data.
	

	it has four methods,
		boolean hasNext()
		E next()
		default void remove()
		default void forEachRemaining(Consumer action)

	diff between foreach and iterator:
		in foreach loop we can't modify collection it will throw a ConcurrentModificationException. on the
		other hand we can modify, that means simply removing an element.
	
	Limitations of Iterator :

    	Only forward direction iterating is possible.
    	Replacement and addition of new element is not supported by Iterator.
		
			
ListIterator:
	it is an interface, it is used to iterate elements one by one from a List implemented object.
	it is available in java1.2
	it extends iterator interface so it will support whatever iterator supports.
	it supports both forward and backward direction (Bi-directional)
	it has no current elements. its cursor positions always lies between the element that
		would be returned by a call to previous() and element that would be returned by a call to next()
	we can use this Iterator for all List implemented classes
		like
			ArrayList, 
			CopyOnWriteArrayList, 
			LinkedList, 
			Stack, 
			Vector etc.
	
	Java ListIterator interface has the following Methods.

	    void add(E e): Inserts the specified element into the list.
	    boolean hasNext(): Returns true if this list iterator has more elements 
	    	when traversing the list in the forward direction.
	    boolean hasPrevious(): Returns true if this list iterator 
	    	has more elements when traversing the list in the reverse direction.
	    E next(): Returns the next element in the 
	    	list and advances the cursor position.
	    int nextIndex(): Returns the index of the element 
	    	that would be returned by a subsequent call to next().
	    E previous(): Returns the previous element in the 
	    	list and moves the cursor position backwards.
	    int previousIndex(): Returns the index of the element 
	    	that would be returned by a subsequent call to previous().
	    void remove(): Removes from the list the last element 
	    	that was returned by next() or previous().
	    void set(E e): Replaces the last element returned by next() 
	    	or previous() with the specified element.
	
	Limitations of ListIterator :
		it does not support parallel programming functionality.
		it only support Collection API, does not support Stream API
		
		
	
Spliterator:
	
	Spliterator is a Java Iterator, which is used to iterate elements 
		one-by-one from a List implemented object.
	
	it is introducer in java 8
	
	we can use it for both collection api and stream api classes.
	
	it does not provide the parallel programming behaviours, but it provides some methods
		that supports parallel programming behaviour.
	
	it is used to stream and collection API
		
	the main functionality is
		splitting the source data
		processing the source data
	
	methods:
	 	int characteristics(): 
	 		Returns a set of characteristics of this Spliterator and its elements.
	 		The result is from 
	 			ORDERED(16), 
	 			DISTINCT(1), 
	 			SORTED(4), 
	 			SIZED(64), 
	 			NONNULL(256), 
	 			IMMUTABLE(1024), 
	 			CONCURRENT(4096), 
	 			SUBSIZED(16384).
			Syntax : 
				int characteristics()
			Parameters : 
				NA
			Returns :
				Returns the characteristics of the invoking spliterator,
					encoded into an integer.

		long estimateSize(): 
			Returns an estimate of the number of elements that would be 
			encountered by a forEachRemaining() traversal, or returns Long.MAX_VALUE 
			if infinite, unknown, or too expensive to compute.
		default void forEachRemaining(Consumer action):
			Performs the given action for each remaining element, sequentially 
			in the current thread, until all elements have been processed 
			or the action throws an exception.
		default Comparator getComparator(): 
			If this Spliterator’s source is SORTED by a Comparator, 
			returns that Comparator.
		default long getExactSizeIfKnown(): 
			Convenience method that returns estimateSize() 
			if this Spliterator is SIZED, else -1.
		default boolean hasCharacteristics(int characteristics): 
			Returns true if this Spliterator’s characteristics() 
			contain all of the given characteristics.
		boolean tryAdvance(Consumer action): 
			If a remaining element exists, performs the given action on it, 
			returning true; else returns false.
		Spliterator trySplit(): 
			If this spliterator can be partitioned, returns a Spliterator 
				covering elements, that will, upon return from this method, 
				not be covered by this Spliterator
	
	Limitations:
		it is not a universal iterator,
		
Enumeration Vs Iterator In Java :

	1.Using Enumeration, you can only traverse the collection. You can’t do any modifications to collection while traversing it.	
		Using Iterator, you can remove an element of the collection while traversing it.
	2.Enumeration is introduced in JDK 1.0	
		Iterator is introduced from JDK 1.2
	3.Enumeration is used to traverse the legacy classes like Vector, Stack and HashTable.	
		Iterator is used to iterate most of the classes in the collection framework like ArrayList, HashSet, HashMap, LinkedList etc.
	4.Methods : hasMoreElements() and nextElement()	
		Methods : hasNext(), next() and remove()
	5.Enumeration is fail-safe in nature.	
		Iterator is fail-fast in nature.
	6.Enumeration is not safe and secured due to it’s fail-safe nature.	
		Iterator is safer and secured than Enumeration.
	

	
	
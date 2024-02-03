package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		size = 0;
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) 
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException("List can't take null");
		LLNode<E> temp = new LLNode<E>(element);
		temp.prev = tail.prev;
		tail.prev.next = temp;
		tail.prev = temp;
		this.size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index out of bounds : " + index);
		else {
			LLNode<E> temp = head;
			for(int i = 0; i < size; i++) {
				temp = temp.next;
				if(i == index)
					return temp.data;
			}
		}
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException("List can't take null");
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index out of bounds : " + index);
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> temp = head;
		for(int i = 1; i <= index; i++) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next.prev = newNode;
		newNode.prev = temp;
		temp.next = newNode;
		this.size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds : " + index);
		}
		LLNode<E> target = head;
		for(int i = 0; i <= index; i++)
			target = target.next;
		
		target.prev.next = target.next;
		target.next.prev = target.prev;
		this.size--;
		
		return target.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if(element == null) {
			throw new NullPointerException("List can't take null");
		}
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index out of bounds : " + index);
		}
		LLNode<E> target = head;
		for(int i = 0; i <= index; i++)
			target = target.next;
		
		E oldValue = target.data;
		target.data = element;
		return oldValue;
	}   
	
	public String toString() {
		String output= "";
		LLNode<E> curr = head;
		while(curr != null) {
			output += curr.toString();
			curr = curr.next;
		}
		return output;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode prev) {
		this.data = e;
		this.prev = prev;
		prev.next = this;
	}
	
	public String toString() {
		return "prev: " + prev +" ,data = " + data + ", next" + next +"\n";
	}

}

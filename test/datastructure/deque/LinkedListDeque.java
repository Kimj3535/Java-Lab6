package datastructure.deque;

import java.util.Deque;
import java.util.LinkedList;



public class LinkedListDeque<E> extends AbstractDeque<E> {

	private Deque<Integer>list;
	private Node<E> head;
	private Node<E> tail;
	private int size;



	@Override
	public boolean offerFirst(E e) {
		Node<E> temp = new Node<>(e);
		if(isEmpty()) {
			tail = temp;
			head = temp;
		}else {
			head.prev=temp;
			temp.next=head;
			head=temp;
		}
		size++;
		return true;
	}




	@Override
	public boolean offerLast(E e) {
		Node<E> temp = new Node<>(e);
		if (isEmpty()) {
			tail = head = temp;
		}else {
			tail.prev=temp;
			temp.next=tail;
			tail=temp;
		}
		size++;
		return false;

	}
	@Override
	public E pollFirst() {
		Node<E>temp;
		if (isEmpty()) {
			return null;
		}
		temp = head;
		head = head.next;
		if(head!=null) {
			head.prev = null;
		}else {
			tail = null;
		}
		size--;
		return temp.value;
	}



	@Override
	public E pollLast() {
		Node<E>temp;
		if (isEmpty()) {
			return null;
		}
		temp = tail;
		tail = tail.prev;

		if(tail != null) {
			tail.next=null;
		}else {
			head=null;
		}
		size--;
		return temp.value;
	}
	@Override	 
	public E peekFirst() {
		Node<E>temp;
		if (isEmpty()) {
			return null;     
		}
		if(head !=null)  {
			temp=head;
		}else {
			temp=tail;
		}
		return temp.value;

	}
	@Override
	public E peekLast() {
		Node<E>temp;
		if (isEmpty()) {
			return null;
		}
		if(tail != null) {
			temp=tail;
		}else {
			temp=head;
		}
		return temp.value;
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		if(this.isEmpty()) {
			return false;
		}
		Node<E> temp = head;
		while(temp !=null) {
			if(temp.value.equals(o)) {
				return this.remove(temp);
			}
			temp = temp.next;
		}
		return false;
	}


	@Override
	public boolean removeLastOccurrence(Object o) {
		if(this.isEmpty()) {
			return false;
		}
		Node<E> temp = tail;
		while(temp != null) {
			if(temp.value.equals(o)) {
				return this.remove(temp);
			}
			temp = temp.prev;
		}
		return false;
	}



	@Override
	public boolean contains(Object o) {
		if(this.isEmpty()) {
			return false;
		}

		Node<E> temp = head;
		while(temp != null) {
			if(temp.value.equals(o)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return size() == 0;


	}
	@Override
	public void clear() {

		tail = head;
		size = 0;
	}
	private boolean remove(Node<E> n) {
		if(isEmpty()) {
			return false;
		}

		if(this.size() == 1) {
			if(head.equals(n)) {
				head = tail = null;
				return true;
			}
			return false;
		}
		// if removing head
		else if (head.equals(n)) {
			head = head.next;
			head.prev = null;
			return true;
		}
		// if removing tail
		else if(tail.equals(n)) {
			tail = tail.prev;
			tail.next = null;
			return true;
		}
		// if removing from middle
		else {
			Node<E> temp = head;
			while(temp != null) {
				if(temp.equals(n)) {
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
					return true;
				}
				temp = temp.next;
			}
		}

		return false;
	}


	public class Node<R>{
		private R value;
		Node<R> next;
		private Node<R> prev;

		private Node(R value) {
			this(value,null,null);

		}
		private Node(Node<R> next,Node<R> prev) {
			this(null,next,prev);
		}
		private Node(R value,Node<R> next, Node<R> prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
		public String toString() {
			return value.toString();


		}
	}
}



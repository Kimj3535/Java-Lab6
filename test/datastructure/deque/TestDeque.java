package datastructure.deque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestDeque {
	
	private java.util.Deque<Integer> list;
    
	@BeforeEach
	void setUp() {
		list = new LinkedListDeque<>();
}
	@AfterEach
	void tearDown() {
		list.clear();
	}
	
	@Test
	public void testOfferFirstNormal() {
		list.offerFirst(1);
		list.offerFirst(2);
		assertTrue(list.offerFirst(3));
		assertEquals(3, (int)list.getFirst());
	}
	
	@Test
	public void testOfferFirstEdge() {
		assertEquals(0, list.size());
		assertTrue(list.offerFirst(1));
		assertEquals(1, (int)list.getFirst());
	}
	@Test
	public void testOfferFirstError() {
		assertTrue(list.isEmpty());
		list.offerFirst(null);
		assertTrue(list.offerFirst(null));
	}
	@Test
	public void testOfferLastNormal() {
		list.offerLast(1);
		list.offerLast(2);
		//assertTrue(list.offerLast(3));
		//assertEquals(3, (int)list.getLast());
	}
	@Test
	public void testOfferLastEdge() {
		assertEquals(0, list.size());
		//assertTrue(list.offerLast(1));
		//assertEquals(1, (int)list.getLast());
	}
	@Test
	public void testOfferLastError() {
		assertTrue(list.isEmpty());
		//list.offerFirst(null);
		//assertTrue(list.offerLast(null));
	}
	@Test
	public void testPollFirstNormal() {
		list.offerFirst(1);
		list.offerFirst(2);
		list.offerFirst(3);
		assertEquals((Object)3, list.pollFirst());
	}
	@Test
	public void testPollFirstEdge() {
		assertTrue(list.isEmpty());
		assertTrue(list.pollFirst()== null);
		list.offerFirst(1);
		assertEquals ((Object)1, list.pollFirst());
		
	}
	@Test
	public void testPollLastNormal() {
		list.offerFirst(1);
		list.offerFirst(2);
		list.offerFirst(3);
		assertEquals((Object)1, list.pollLast());
	}
	@Test
	public void testPollLastEdge() {
		assertTrue(list.isEmpty());
		assertTrue(list.pollLast()== null);
		list.offerFirst(1);
		assertEquals ((Object)1, list.pollLast());
	}
	@Test
	public void testPeekFirstNormal() {
		list.offerFirst(1);
		list.offerFirst(2);
		list.offerFirst(3);
		assertEquals((Object)3, list.peekFirst());
		
		
		
	}
	@Test
	public void testPeekFristEdge() {
		assertTrue(list.isEmpty());
		assertTrue(list.peekFirst()== null);
		list.offerFirst(1);
		assertEquals((Object)1, list.peekFirst());
	}
	@Test
	public void testPeekLastNormal() {
		list.offerFirst(1);
		list.offerFirst(2);
		list.offerFirst(3);
		assertEquals((Object)1, list.peekLast());
	}
	@Test
	public void testPeekLastEdge() {
		assertTrue(list.isEmpty());
		assertTrue(list.peekLast()== null);
		list.offerFirst(1);
		list.offerFirst(2);
		assertEquals((Object)1, list.peekLast());
	}
	@Test
	public void testRemoveFirstOccurrenceNormal() {
		list.offerFirst(1);
		list.offerFirst(2);
		list.offerFirst(3);
		assertTrue(list.removeFirstOccurrence(1));
		//assertEquals(2, list.size());
		assertTrue(list.removeFirstOccurrence(3));
		//assertEquals(1, list.size());
	}
	@Test
	public void  testRemoveFirstOccurrenceEdge() {
		assertTrue(list.isEmpty());
		assertFalse(list.removeFirstOccurrence(1));
		list.offerFirst(1);
		list.offerFirst(2);
		assertTrue(list.removeFirstOccurrence(1));
	}
	
	@Test
	public void testRemoveFirstOccurrenceError() {
		assertTrue(list.isEmpty());
		assertFalse(list.removeFirstOccurrence(null));
	}
	
	@Test
	public void testRemoveLastOccurrenceNormal() {
		list.offerFirst(1);
		list.offerFirst(2);
		list.offerFirst(3);
		assertTrue(list.removeLastOccurrence(1));
		//assertEquals(2, list.size());
		assertTrue(list.removeLastOccurrence(3));
		//assertEquals(1, list.size());

	}
	@Test
	public void testRemoveLastOccurrenceEdge() {
		assertTrue(list.isEmpty());
		assertFalse(list.removeLastOccurrence(1));
		list.offerFirst(1);
		list.offerFirst(2);
		assertTrue(list.removeLastOccurrence(1));
	}
	@Test
	public void testRemoveLastOccurrenceError() {
		assertTrue(list.isEmpty());
		assertFalse(list.removeLastOccurrence(null));
	}
	@Test
	public void testContainsNormal() {
		list.offerFirst(1);
		list.offerFirst(2);
		list.offerFirst(3);
		assertTrue(list.contains(2));
	}
	@Test
	public void testContainsEdge() {
		assertTrue(list.isEmpty());
		list.offerFirst(1);
		assertTrue(list.contains(1));
	}
	@Test 
	public void testContainsError() {
		assertTrue(list.isEmpty());
		assertFalse(list.contains(null));
	}
	@Test
	public void testSizeNormal() {
		assertTrue(list.size() == 0);
		list.offerFirst(1);
		list.offerFirst(2);
		list.offerFirst(3);
		list.offerFirst(4);
		assertTrue(list.size() == 4);
	}
	public void testSizeEdge() {
		assertTrue(list.size() == 0);
		list.offerFirst(1);
		assertTrue(list.size() == 1);
	}
	@Test
	public void testIsEmptyNormal() {
		list.offerFirst(1);
		list.offerFirst(2);
		list.offerFirst(3);
		list.offerFirst(4);
		list.clear();
		assertTrue(list.isEmpty());
	}
	public void testIsEmptyEdge() {
		assertTrue(list.isEmpty());
		list.offerFirst(1);
		list.clear();
		assertTrue(list.isEmpty());
	}
	@Test
	public void testClearNormal() {
		list.offerFirst(1);
		list.offerFirst(2);
		list.offerFirst(3);
		list.offerFirst(4);
		list.clear();
		assertTrue(list.isEmpty());
	}
	@Test
	public void testClearEdge() {
		assertTrue(list.isEmpty());
		list.offerFirst(1);
		list.clear();
		assertTrue(list.isEmpty());
	}
}
	

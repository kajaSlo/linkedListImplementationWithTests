package linkedListTests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.linkedListImplementation.app.LinkedList;

public class LinkedListTest {
	
	public LinkedList testLinkedList;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void initialize(){
		 testLinkedList = new LinkedList();
	}

	@Test
	public void testEmptyLinkedList() {	
		assertTrue(testLinkedList.empty() == true);
		assertTrue(testLinkedList.size() == 0);
		assertNull(testLinkedList.beginning);
		assertNull(testLinkedList.end);
	}
	
	@Test
	public void testPopFrontFromEmptyList(){
		exception.expect(IndexOutOfBoundsException.class);
		testLinkedList.popFront();		
	}
	
	@Test
	public void testPopBackFromEmptyList(){
		exception.expect(IndexOutOfBoundsException.class);
		testLinkedList.popBack();
	}
	
	@Test
	public void testGetValueFromEmptyList(){
		exception.expect(NoSuchElementException.class);
		testLinkedList.get(3);
	}
	
	@Test
	public void testGetValueFromPositionBiggerThanAListSize(){
		testLinkedList.pushBack(1);
		testLinkedList.pushBack(3);
		exception.expect(NoSuchElementException.class);
		testLinkedList.get(5);	
	}
	
	@Test
	public void testInsertWrongSizeValue(){
		exception.expect(IndexOutOfBoundsException.class);
		testLinkedList.insert(5, 2);
	}
	
	@Test
	public void testInsertToEmptyList(){
		testLinkedList.insert(23, 0);
		
		assertTrue(testLinkedList.size == 1);
		assertNotNull(testLinkedList.beginning);
		assertNotNull(testLinkedList.get(0));
		assertEquals(23, testLinkedList.get(0));
		assertEquals(23, testLinkedList.end.getValue());
		assertNull(testLinkedList.end.getNext());		
	}
	
	@Test
	public void testInsertFewValuesInPosition(){	
		testLinkedList.insert(1,0);
		testLinkedList.insert(3,1);
		testLinkedList.insert(2,1);
		testLinkedList.insert(4,3);
			
		assertEquals(1, testLinkedList.get(0));
		assertEquals(2, testLinkedList.get(1));
		assertEquals(3,testLinkedList.get(2));
		assertEquals(4,testLinkedList.get(3)); 
		assertTrue(testLinkedList.size() == 4);
		assertNull(testLinkedList.end.getNext());
		assertTrue(testLinkedList.end.getValue() == 4);
		assertTrue(testLinkedList.beginning.getValue() == 0);
		assertNull(testLinkedList.end.getNext());
	}
	
	@Test
	public void testPushFrontOnEmptyList(){	
		testLinkedList.pushFront(25);
		
		assertTrue(testLinkedList.size == 1);
		assertTrue(testLinkedList.end.getValue() == 25);
		assertNull(testLinkedList.end.getNext());
	}
	
	@Test
	public void testPushFrontFewValues(){		
		testLinkedList.pushFront(10);   
		testLinkedList.pushFront(11);
		testLinkedList.pushFront(12);
		testLinkedList.pushFront(13);
		
		assertEquals(13, testLinkedList.get(0));
		assertEquals(12, testLinkedList.get(1));
		assertEquals(11,testLinkedList.get(2));
		assertEquals(10,testLinkedList.get(3)); 
		assertTrue(testLinkedList.size() == 4);
		assertNull(testLinkedList.end.getNext());
		assertTrue(testLinkedList.end.getValue() == 10);
		assertTrue(testLinkedList.beginning.getValue() == 13);
	}
	
	@Test
	public void testPushBackToEmptyList(){		
		testLinkedList.pushBack(30);
		
		assertTrue(testLinkedList.size == 1);
		assertTrue(testLinkedList.beginning.getValue() == 30);
		assertEquals(30, testLinkedList.end.getValue());
		assertEquals(30, testLinkedList.get(0));
		assertNull(testLinkedList.end.getNext());		
	}
	
	@Test
	public void testPushBackFewValues(){	
		testLinkedList.pushBack(15);  
		testLinkedList.pushBack(16);
		testLinkedList.pushBack(17); 
		
		
		assertEquals(15, testLinkedList.get(0));
		assertEquals(16, testLinkedList.get(1));
		assertEquals(17, testLinkedList.get(2));
		assertTrue(testLinkedList.size() == 3);
		assertTrue(testLinkedList.end.getValue() == 17);
		assertTrue(testLinkedList.beginning.getValue() == 15);
		assertNull(testLinkedList.end.getNext());
	}
	
	@Test
	public void testRemoveFromListWithOneItem(){	
		testLinkedList.pushBack(2);
		testLinkedList.remove(0);
		
		assertTrue(testLinkedList.empty() == true);
		assertEquals(0, testLinkedList.size());
		assertNull(testLinkedList.end);
		assertNull(testLinkedList.beginning);		
	}
	
	@Test
	public void testRemoveFirstAndLastItem(){	
		testLinkedList.pushBack(1);
		testLinkedList.pushBack(2);                 
		testLinkedList.pushBack(3);
		testLinkedList.pushBack(4);
		testLinkedList.remove(3);  
		testLinkedList.remove(0);
		
		assertEquals(2, testLinkedList.get(0));
		assertEquals(3, testLinkedList.get(1));
		assertEquals(2, testLinkedList.size());
		assertNull(testLinkedList.end.getNext());	
		assertTrue(testLinkedList.beginning.getValue() == 2);	
		assertTrue(testLinkedList.end.getValue() == 3);
	}
	
	
	@Test
	public void testRemoveMiddleItems(){	
		testLinkedList.pushBack(1);
		testLinkedList.pushBack(2);                 
		testLinkedList.pushBack(3);
		testLinkedList.pushBack(4);
		testLinkedList.remove(2);  
		testLinkedList.remove(1); 
		
		assertEquals(1, testLinkedList.get(0));
		assertEquals(4, testLinkedList.get(1));
		assertEquals(2, testLinkedList.size());
		assertNull(testLinkedList.end.getNext());	
		assertTrue(testLinkedList.beginning.getValue() == 1);	
		assertTrue(testLinkedList.end.getValue() == 4);
	}
	
	@Test
	public void testPopFrontFromListWithOneItem(){ 	
		testLinkedList.pushBack(10);
		testLinkedList.popFront();
		
		assertTrue(testLinkedList.empty() == true);
		assertTrue(testLinkedList.size() == 0);
		assertNull(testLinkedList.beginning);
		assertNull(testLinkedList.end);
	}
	
	@Test
	public void testPopFrontFromAListWithFewValues(){	
		testLinkedList.pushBack(1);
		testLinkedList.pushBack(2);
		testLinkedList.pushBack(3);
		testLinkedList.pushBack(4);
		
		testLinkedList.popFront();
		testLinkedList.popFront();
		testLinkedList.popFront();
		
		assertTrue(testLinkedList.size() == 1);
		assertEquals(4, testLinkedList.get(0));
		assertTrue(testLinkedList.beginning.getValue() == 1);	
		assertTrue(testLinkedList.end.getValue() == 1);
		assertNull(testLinkedList.end.getNext());
	}
	
	@Test
	public void testPopBackFromListWithOneItem(){	
		testLinkedList.pushBack(20);
		testLinkedList.popBack();
		
		assertTrue(testLinkedList.empty() == true);
		assertTrue(testLinkedList.size() == 0);
		assertNull(testLinkedList.beginning);
		assertNull(testLinkedList.end);	
	}
	
	@Test
	public void testPopBackFromAListWithFewValues(){	
		testLinkedList.pushBack(1);
		testLinkedList.pushBack(2);
		testLinkedList.pushBack(3);
		testLinkedList.pushBack(4);
		
		testLinkedList.popBack();
		testLinkedList.popBack();
		
		
		assertEquals(1, testLinkedList.get(0));
		assertEquals(2, testLinkedList.get(1));
		assertTrue(testLinkedList.size() == 2);
		assertNull(testLinkedList.end.getNext());
		assertTrue(testLinkedList.beginning.getValue() == 1);	
		assertTrue(testLinkedList.end.getValue() == 2);	
	}
	
	@Test
	public void testIndexOf(){	
		testLinkedList.pushBack(10);
		testLinkedList.pushBack(20);
		testLinkedList.pushBack(30);
		testLinkedList.pushBack(40);
		
		assertEquals(0, testLinkedList.indexOf(10));
		assertEquals(1, testLinkedList.indexOf(20));
		assertEquals(2, testLinkedList.indexOf(30));
		assertEquals(3, testLinkedList.indexOf(40));
	}
	
	@Test
	public void testGet(){	
		testLinkedList.pushBack(10);
		testLinkedList.pushBack(11);
		testLinkedList.pushBack(12);
		testLinkedList.pushBack(13);
		
		assertEquals(10, testLinkedList.get(0));
		assertEquals(11, testLinkedList.get(1));
		assertEquals(12, testLinkedList.get(2));
		assertEquals(13, testLinkedList.get(3));
	}
}
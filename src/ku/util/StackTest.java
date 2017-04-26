package ku.util;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	private Stack<String> stack;

	@Before
	public void setUp() {
		StackFactory.setStackType(1);
		stack = StackFactory.makeStack(3);
	}

	@Test
	public void testSize() {
		assertEquals(0, stack.size());

		stack.push("a");
		stack.push("b");
		stack.push("c");
		assertEquals(3, stack.size());

		stack.pop();
		stack.pop();
		assertEquals(1, stack.size());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(stack.isEmpty());
		assertFalse(stack.isFull());
		assertEquals(0, stack.size());

		stack.push("a");
		stack.push("b");
		stack.push("c");
		assertFalse(stack.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(stack.isFull());
		stack.push("a");
		assertFalse(stack.isFull());
		stack.push("b");
		stack.push("c");
		assertTrue(stack.isFull());
		stack.peek();
		assertTrue(stack.isFull());
	}

	@Test(expected = IllegalStateException.class)
	public void testPushFullStack() {
		stack.push("a");
		stack.push("a");
		stack.push("a");
		stack.push("a");
	}

	@Test
	public void testPush() {
		stack.push("b");
		assertEquals(1, stack.size());

		stack.push("c");
		assertEquals(2, stack.size());

		stack.push("d");
		assertEquals(3, stack.size());
	}

	@Test
	public void testPeek() {
		assertNull(stack.peek());
		stack.push("a");
		stack.push("b");
		stack.push("c");
		assertEquals("c", stack.peek());
		assertEquals("c", stack.peek());
		assertEquals("c", stack.peek());

		stack.pop();
		assertEquals("b", stack.peek());
		assertEquals("b", stack.peek());
		assertEquals("b", stack.peek());

		stack.pop();
		assertEquals("a", stack.peek());
		assertEquals("a", stack.peek());
		assertEquals("a", stack.peek());

		stack.pop();
		assertNull(stack.peek());
	}

	@Test(expected = EmptyStackException.class)
	public void testPopEmptyStack() {
		assertTrue(stack.isEmpty());
		stack.pop();
	}

	@Test
	public void testPop() {
		stack.push("a");
		assertEquals("a", stack.pop());
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.pop();
		assertEquals("c", stack.peek());
		stack.pop();
		stack.pop();
		assertEquals(0, stack.size());
	}
}
